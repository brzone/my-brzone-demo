package executor;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
	

	public static void main(String[] args) {
		
		/**
		 * 为什么要线程池 ：
		 *           因为创建线程也是需要资源的，而且在原始的使用方法下，使用了，便结束了生命
		 *           周期，若下次需要线程的话，便又要重新创建，便又要花费资源了，这里把创建的
		 *           线程收集起来，下次有任务的话，是可以重复使用的(可以喻比数据库的连接池)。
		 * 
		 * newCachedThreadPool:
		 *              每一个任务都有一个独立的执行器,他会根据任务的个数而分配执行器的个数.
		 *              当然以前生成的执行器还是可以利用的(如果可以利用，譬如，若以前的某线程，
		 *              已经执行完了某任务，现在又添加某任务，现在便可以利用以前的某任务了).
		 * 
		 * newFixedThreadPool:
		 *              固定的线程池，一次性支付高昂的代价，一次性new出固定的线程执行器，这里有
		 *              一些东西还需要注意.
		 *              1.  如果传的参数值为1，则相当于newSingleThreadExecutor,
		 *              意为new一个单一的线程执行器，在多个任务中，是按照添加顺序，执行器一个一个的
		 *              来驱动任务，第一个任务没有完成，第二个任务是不会开始的。
		 *              
		 *               2. 如果传的参数小于任务书，则先执行前几个和执行器相等的任务，譬如：
		 *               我参数为5，意思为我一次性new出了5个线程执行器，但是，我有7个任务，执行的
		 *               顺序是：先执行前5个任务，现在就没执行器了(执行器在执行任务),任务进入到
		 *               等待队列，直到有空闲的执行器 （意思是某执行器已完成任务了），才会驱动还没完成的任务.
		 * 
		 * 
		 */
		
		//ExecutorService  exec = Executors.newCachedThreadPool();
		ExecutorService  exec = Executors.newFixedThreadPool(4);
	   //ExecutorService  exec =Executors.newSingleThreadExecutor();
		
		for(int i = 0;i<5;i++) {
			/*提交 任务*/
			exec.execute(new SimpleCount());
		
		}
		
		//当ExecutorService shutdown()后，便不能添加新的任务了.
		exec.shutdown();

	}
}
