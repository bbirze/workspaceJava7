package whats.newin.j2se7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;

public class NewTransferQueue {
	static LinkedTransferQueue<Integer> myQueue = new LinkedTransferQueue<Integer>();

	class Producer implements Runnable{

		public void run() {
			try {	                         // produce as fast as consumers take
				for(int i=0; i<8; i++) {
					System.out.println("Producer transfer: <" + i +
							"> for <" + myQueue.getWaitingConsumerCount() + "> consumers");
					myQueue.transfer(i);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
	}

	class Consumer implements Runnable{
		private String name;
		public Consumer(String nm)   { name = "\t" + nm; }

		public void run() {
			try {
				while(true) {
					System.out.println(name + " waiting for element...");
					Integer i= myQueue.take();
					System.out.println(name + " got <" + i + ">");
					Thread.sleep(1000);       //  simulate work
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ExecutorService exService = Executors.newFixedThreadPool(3);
		Producer producer = new NewTransferQueue().new Producer();
		Consumer consumer1 = new NewTransferQueue().new Consumer("Consumer1");
		Consumer consumer2 = new NewTransferQueue().new Consumer("Consumer2");
		exService.execute(producer);
		exService.execute(consumer1);
		exService.execute(consumer2);
		exService.shutdown();
	}


}
