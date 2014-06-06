package cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {

	
	public static void main(String[] args) {

		 String[] name = {
				"walk",
				"bus",
				"car of self",
		};
		
		int[] walktime = {3,6,9};
		
		int[] bustime = {2,4,6};
		
		int[] cartime = {1,2,3};
		
		/**
		 * 参数解释：
		 *     第一个参数：整形，也就是说要到达屏障点的线程的个数，在这里，有三中线程，"走路"、"大巴"
		 *              、"自驾"，故传的参数为3
		 * 
		 *     第二个参数：Runable, 都到达屏障点的时候执行的任务，可以执行多次，因为CyclicBarrier
		 * 
		 */
		
		CyclicBarrier barrier = new CyclicBarrier(3,new Runnable(){
			
			@Override
			public void run(){
				
				System.out.println("All here!");
			}
			
		});
		
		
		ExecutorService exec = Executors.newCachedThreadPool();
		
		exec.execute(new Tour(name[0],walktime,barrier));
		exec.execute(new Tour(name[1],bustime,barrier));
		exec.execute(new Tour(name[2],cartime,barrier));
		
		exec.shutdown();
		
	}

}
