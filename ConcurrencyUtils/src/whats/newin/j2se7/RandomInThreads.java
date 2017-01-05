package whats.newin.j2se7;

import java.util.concurrent.ThreadLocalRandom;

public class RandomInThreads {
	static int CUR_TASK_NUM = 1;

	private static class MessageLoop extends Thread {

		public MessageLoop() {
			System.out.println(getName() + " created");
		}

		public void run() {
			int[] array = new int[4];
			ThreadLocalRandom randomGen = ThreadLocalRandom.current();
			System.out.println(getName() + " got ThreadLocalRandom: " + randomGen);
			try {
				for (int i = 0; i < 4; i++) {
					array[i] = randomGen.nextInt(100);
					Thread.sleep(1000); // Pause a seconds
				}
			} catch (InterruptedException e) {
				System.out.println("MessageLoop(" + getName()
						+ ") Caught Exception: " + e.getMessage());
			}
			synchronized (randomGen) {
				System.out.println("\n" + getName()	+ " generated: ");
				for (int i = 0; i < 4; i++) {
					System.out.print(array[i] + " ");
				}
			}
		}
	}

	public static void main(String args[]) throws InterruptedException {
		System.out.println("main: Starting with " + Thread.activeCount()
				+ " threads");
		Thread t1 = new Thread(new MessageLoop(), "T-1");
		Thread t2 = new Thread(new MessageLoop(), "T-2");
		Thread t3 = new Thread(new MessageLoop(), "T-3");
		Thread t4 = new Thread(new MessageLoop(), "T-4");
		Thread t5 = new Thread(new MessageLoop(), "T-5");
		Thread t6 = new Thread(new MessageLoop(), "T-6");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		System.out.println("main: Starting MessageLoop thread with "
				+ Thread.activeCount() + " threads");

		while (Thread.activeCount() != 1) { // until all threads exit
			t1.join();
			t2.join();    // a better way to do this             
			t3.join();    // is with the new Phaser Class! 
			t4.join();
			t5.join();
			t6.join();
		}
		System.out.println("\nmain: Done!");
	}
}
