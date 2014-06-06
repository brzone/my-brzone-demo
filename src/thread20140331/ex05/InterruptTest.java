package thread20140331.ex05;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class InterruptTest implements Runnable {

	private static final SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	@Override
	public void run() {

		String start = sdf.format(new Date());
		System.out.println("start:" + start);
		System.out.println(Thread.currentThread().isInterrupted());
		try {

			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			//当一个线程在sleep或者wait的时候，如果被interrupt，这时会抛出InterruptedException异常，我们可以在这catch到异常后
			//做一些清理工作，比如：我们用线程打开一个文件，我们可以在这里进行文件打开流的关闭etc
			System.out.println(Thread.currentThread().isInterrupted());
			System.out.println("收到了打断信号，立即退出...");
			return;
		}

		String end = sdf.format(new Date());

		System.out.println("end:" + end);

	}

	public static void main(String args[]) {

		Thread t = new Thread(new InterruptTest());
		System.out.println("主进程开始.....");

		t.start();
		try {
			t.join(2000);
			t.interrupt();

		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		System.out.println("主进程结束.....");

	}

}
