package thread20140331.ex04;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class JoinTest implements Runnable {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public void run() {
		String start = sdf.format(new Date());
		System.out.println("start:" + start);

		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		String end = sdf.format(new Date());

		System.out.println("end:" + end);

	}


	public static void main(String[] args) {

		Thread t = new Thread(new JoinTest());

		System.out.println("主线程开始。。。。");

		t.start();
		try {
			/**
			 *  当前的执行环境是：主线程，在主线程中调用t.join()，意思就是：
			 *  当前线程要等待t线程执行完毕后，才执行t.join()后面的代码。。
			 *  等待t。。。
			 *  当然我们可以传递一个join的时间参数，比如，我们传递2000,2s，等待t俩秒，
			 *  如果t线程还无执行完毕，我们也要执行t.join()后面的代码了。
			 */
			t.join(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("主线程结束。。。。");

	}



}
