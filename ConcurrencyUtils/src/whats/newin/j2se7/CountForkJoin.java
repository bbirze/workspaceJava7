package whats.newin.j2se7;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class CountForkJoin {
	static int CUR_TASK_NUM = 1;

	class RTask extends RecursiveTask<Long> {
		private static final long serialVersionUID = 1L;
		private final long from;
		private final long to;
		private long[] array;
		private int taskNum;

		public RTask(long fromIdx, long toIdx, long[] srcArray) {
			this.from = fromIdx;
			this.to   = toIdx;
			this.array= srcArray;
			taskNum = CUR_TASK_NUM++;
			System.out.println("RTask(" + taskNum + ") from:" + from +" to:" + to);
		}

		@Override
		protected Long compute() {
			final int SPLIT_SIZE = 10_000; // split task when reach this threshold
			long sum = 0L;
			List<RTask> taskLst = new LinkedList<>();
			
			if (to-from <= SPLIT_SIZE) {          // work is small
				System.out.println("RTask(" + taskNum + ") Doing work");
	            for (int i = (int) from; i < to; i++) {
	                sum = sum + array[i];
	            }		
				System.out.println("RTask(" + taskNum + ") computed: " + sum);
	        } else {                              // work is big, divide it
				System.out.println("RTask(" + taskNum + ") Splitting work");
	            long mid = (to + from) >>> 1;      
				RTask task1 = new RTask(from, mid, array);
				taskLst.add(task1);               // add new tasks to our list
				task1.fork();                     // go do it
				
				RTask task2 = new RTask(mid+1, to, array);
				taskLst.add(task2);               // add new tasks to our list
				task2.fork();                     // go do it     

		        for (RecursiveTask<Long> task : taskLst) {
		        	RTask tt = (RTask)task;  // unsafe cast
		        	sum = sum + task.join();          // wait for everyone to finish
					System.out.println("RTask(" + taskNum + ") Task(" + tt.taskNum + ") finished with sum: " + sum);
		        }
			}
			return sum;
		}
	}
	
	public CountForkJoin() {
		long results = 0L;
		long[] array = new long[50_000];
        for (int i=0; i< array.length; i++) {           // fill array with index value
            array[i] = i;
        }
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
 
		System.out.println("CountForkJoin creating CountArrayTask"); 
		System.out.println("\twith 1st in 1st out scheduleing mode: " + pool.getAsyncMode());
		System.out.println("\tparallelism: " + pool.getParallelism());
		RTask task = new RTask(0, array.length, array);
		results = pool.invoke(task); // go do the work
		System.out.println("Result: " + results);
		System.out.println("Pool size: " + pool.getPoolSize() +" Number of steals: " + pool.getStealCount());
	}
	
	public static void main(String[] args) {
		CountForkJoin forkJoin = new CountForkJoin();
	}

}
