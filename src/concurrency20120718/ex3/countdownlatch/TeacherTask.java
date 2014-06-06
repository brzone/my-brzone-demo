package concurrency20120718.ex3.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * 老师
 * @author li jian
 * @mail brzone@126.com
 * @date 2012-9-11 下午05:14:44
 */
public class TeacherTask implements Runnable {

	private CountDownLatch latch;

	public TeacherTask(CountDownLatch latch) {
		super();
		this.latch = latch;
	}

	@Override
	public void run() {

		try {

		   //在计数器不能0的时候，该方法会一直堵塞，直至计数器为0
			latch.await();
            doWork();
		} catch (InterruptedException e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		}


	}

	private void doWork() {

		System.out.println("we can attend class.");

	}

}
