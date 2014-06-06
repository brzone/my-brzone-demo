package concurrency20120718.ex3.barriertest;

import java.text.SimpleDateFormat;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author li jian
 * @mail brzone@126.com
 * @date 2012-9-10 下午05:03:22
 */
public class CyclicBarrierDemo {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


	public static void main(String[] args) {

		int[] walkTime = {5,8,10};

		int[] driverCarBySelf = {1,2,3};

		int[] driverbus = {2,4,6};

		//当到达某一屏障点的时候，由最后一个到达屏障点的线程执行该任务。
		CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {

			@Override
			public void run() {
				System.out.println(sdf.format(new java.util.Date())
						+ "\t" + Thread.currentThread().getName()
						+ "\twe all reached.");

			}
		});

		//起三个线程执行器
		ExecutorService exec = Executors.newFixedThreadPool(3);
		//执行任务
		exec.submit(new RunTask(barrier, walkTime));
		exec.submit(new RunTask(barrier, driverCarBySelf));
		exec.submit(new RunTask(barrier, driverbus));

		exec.shutdown();

	}

}
