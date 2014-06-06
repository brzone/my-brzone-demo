package concurrency20120718.ex3.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 学生
 * @author li jian
 * @mail brzone@126.com
 * @date 2012-9-11 下午05:27:06
 */
public class StudentTask implements Runnable{

	private CountDownLatch latch;

	private String name;

	private static final Random random  = new Random(37);

	public StudentTask(String name,CountDownLatch latch) {
		super();
		this.latch = latch;
		this.name = name;
	}

	@Override
	public void run() {

		doWork();

		try {

			//为了效果，随机休眠秒数
			TimeUnit.SECONDS.sleep(random.nextInt(4));

		} catch (InterruptedException e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		}

		//做完自己的事情后，便要使计数器减一
		latch.countDown();

	}

	private void doWork() {

		System.out.println(Thread.currentThread().getName()
				+ "\t" + name + " has here.");
	}

}
