package whats.newin.j2se7;

import java.util.concurrent.Phaser;


public class PhaserSync {
	static Phaser phaser;

	
	/** Main
	 */
	public static void main(String args[]) throws InterruptedException {
		
		phaser = new Phaser(1)  {    // create with 1 registered party

			// @return boolean:  true if phaser should terminate
			//                   false if advance to next phase
			@Override
			protected boolean onAdvance(int phaseNum, int registeredParties) {
				System.out.println("*** onAdvance() with phaser: " + phaserOut(toString())); 
			
				boolean ret = phaseNum >= 2 || registeredParties == 0;
				if (ret)
					System.out.println("*** onAdvance() Phaser Terminating ");
				else 
					System.out.println("*** onAdvance() Advance to Next Phase:" + (getPhase()+1));				
				return ret;
			}
		};     //  End Phaser class

		System.out.println("main:Created phaser: " + phaserOut(phaser.toString()));

		for (int i = 0; i < 4; i++) {
			Thread thrd = new Thread(new myThread(i), "T-"+i);
			phaser.register();       
			System.out.println("main:(" + thrd.getName() + ") registered: " + phaserOut(phaser.toString()));
			thrd.start();            
		}

		System.out.println("main: wait for arriveAndDeregister");
		
		// when we "arrive" arrived parties = registered parties and onArrive is invoked 
		// then all threads can start working.

		phaser.arriveAndDeregister();

		System.out.println("main: after arrived and deregistered: " + phaserOut(phaser.toString()));
		System.out.println("\nmain thread: Done!");
	}
	
	/** myThread Class
	 */
	private static class myThread extends Thread {

		protected int multiplier;
		
		public myThread(int multiplier) {
			super();
			this.multiplier = multiplier+1;
		}

		public void run() {
			try {
				do {
					System.out.println(getName() + " before arriveAndAwaitAdvance" + phaserOut(phaser.toString()));
					phaser.arriveAndAwaitAdvance();
					System.out.println(getName() + " Advanced, Go!");
					for (int i = 0; i < 4; i++) {
						Thread.sleep(100*multiplier); // simulate different amts of work
					}
				} while (!phaser.isTerminated());
			} catch (InterruptedException e) {
				System.out.println(getName() + " Caught Exception: " + e.getMessage());
			}
			System.out.println(getName() + " Exiting: " + phaserOut(phaser.toString()));
		}
	}
	

	private static String phaserOut(String string) {
		//phaser.toString returns
		// whats.newin.j2se7.PhaserSync$1@52e922[phase = 2 parties = 4 arrived = 4]
			
		return string.substring(string.indexOf('['));
	}
}
