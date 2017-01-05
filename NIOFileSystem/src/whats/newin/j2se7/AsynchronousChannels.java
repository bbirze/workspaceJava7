package whats.newin.j2se7;

import java.io.IOException;
import java.nio.channels.AsynchronousChannelGroup;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class AsynchronousChannels {

	private static class myThread extends Thread {
		protected int multiplier;

		myThread(int multiplier) {
			this.multiplier = multiplier+1;
		}

		public void run() {
			System.out.println(getName() + " Doing Work!");
			for (int i=0; i<5; i++)  {
				try {
					Thread.sleep(100*multiplier); // simulate different amts of work
				} catch (InterruptedException e) {
					System.out.println(getName() + " Caught Exception: " + e.getMessage());
				} 
			}
			System.out.println("\t"+getName() + " DONE!");
		}
	}

	public static void main(String[] args) {

		ExecutorService eServ = Executors.newCachedThreadPool();
		for (int i=1; i<6; i++) {
			Thread thrd = new Thread(new myThread(i), "T-"+i);
			eServ.execute(thrd);
		}
		
		AsynchronousChannelGroup acgrp = null;
		try {           // give acgrp ExecutorService 
			acgrp = AsynchronousChannelGroup.withCachedThreadPool(eServ, 4);  
		
			System.out.println("\nWe have"+ Thread.activeCount() + " threads runninng, ");
			System.out.println("\tacg.isShutdown() = " + acgrp.isShutdown() +" acg.isTerminated() = " + acgrp.isTerminated() +"\n");

			
			boolean grpTerminated = acgrp.awaitTermination(2, TimeUnit.SECONDS);
			if (grpTerminated)
				System.out.println("\nThread Group Terminated, We have "+ Thread.activeCount() + " threads runninng");
			else
				System.out.println("\nTimed out, group still running, We have "+ Thread.activeCount() + " threads runninng");
			
			System.out.println("Calling acg.shutdownNow()");
			acgrp.shutdownNow();
			
			System.out.println("\nreturn from acg.isShutdown()");
			System.out.println("\tacg.isShutdown() = " + acgrp.isShutdown() +" acg.isTerminated() = " + acgrp.isTerminated()+"\n");
			
			Thread.sleep(3000);
		} catch (IOException | InterruptedException e) {
			System.out.println("caught exception: " + e);
		}

		System.out.println("\nLeaving Main, we now have" + Thread.activeCount() + " threads runninng");
		System.out.println("\tacg.isShutdown() = " + acgrp.isShutdown() +" acg.isTerminated() = " + acgrp.isTerminated()+"\n");
	}
}
