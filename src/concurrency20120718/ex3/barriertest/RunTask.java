package concurrency20120718.ex3.barriertest;

import java.text.SimpleDateFormat;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author li jian
 * @mail brzone@126.com
 * @date 2012-9-10 下午05:12:18
 */
public class RunTask implements Runnable {

	private CyclicBarrier barrier;

	private int[] SencondTimeForWait;

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public RunTask(CyclicBarrier barrier, int[] sencondTimeForWait) {
		super();
		this.barrier = barrier;
		SencondTimeForWait = sencondTimeForWait;
	}

	@Override
	public void run() {

		for(int stepTime: SencondTimeForWait) {

			try {
				TimeUnit.SECONDS.sleep(stepTime);
				System.out.println(getCurrentTime() + "\t" + Thread.currentThread().getName() + " has reached.");



				/**
				 * 当到达某一个屏障点，就等待。
				 *
				 * 可以利用类似信号量来做比方：
				 *              刚刚开始的信号量，是new出来CyclicBarrier传进去的值，
				 *              这里是3，可以理解是：await()一次，其信号量减1，然后
				 *              进入堵塞，直到信号量为0，此时，唤醒全部堵塞的线程，使
				 *              其线程全部继续执行，并把信号量恢复到原来创建时的值，
				 *              这样便可以循环的执行下去。
				 *
				 *
				 */

				barrier.await();

			} catch (InterruptedException e) {

				e.printStackTrace();
				throw new RuntimeException(e);
			} catch (BrokenBarrierException e) {

				e.printStackTrace();
				throw new RuntimeException(e);
			}


		}

	}


	private String getCurrentTime() {

		return sdf.format(new java.util.Date());
	}


	/**
	 * just for test Date format is ok
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(sdf.format(new java.util.Date()));

	}

}
