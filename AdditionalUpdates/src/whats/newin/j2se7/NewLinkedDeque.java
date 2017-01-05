package whats.newin.j2se7;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewLinkedDeque {

	static ConcurrentLinkedDeque<Integer> myQueue = new ConcurrentLinkedDeque<>();

	class GetFirst implements Runnable{
		private String name;
		public GetFirst(String nm)   { name = nm; }

		public void run() {
			try {
				while(true) {
					Integer i = myQueue.poll();
					System.out.println(name + " got first element <" + i + ">");
					Thread.sleep(500);       //  simulate work
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	class GetLast implements Runnable{
		private String name;
		public GetLast(String nm)   { name = "\t" + nm; }

		public void run() {
			try {
				while(true) {
					Integer i = myQueue.removeLast();
					System.out.println(name + " got last element <" + i + ">");
					Thread.sleep(500);       //  simulate work
				}
			} catch (NoSuchElementException e) {
				System.out.println(name + " Dequeue is empty, exiting...");
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ExecutorService exService = Executors.newFixedThreadPool(3);
		GetFirst consumer1 = new NewLinkedDeque().new GetFirst("GetFirst");
		GetLast consumer2 = new NewLinkedDeque().new GetLast("GetLast");

		for(int i=0; i<8; i++){
			System.out.println("Producer offer: <" + i + "> to dequeue tail" );
			myQueue.offer(i);
		}
		
		String str = "ConcurrentLinkedDequeue MyQueue contains <";
		for(Iterator<Integer> itr = myQueue.iterator(); itr.hasNext();){
			str += itr.next() + " ";
		}
		System.out.println(str + ">\n");				
		exService.execute(consumer1);
		exService.execute(consumer2);
		exService.shutdown();
	}
}
