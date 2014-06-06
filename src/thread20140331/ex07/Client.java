package thread20140331.ex07;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

	public static void main(String[] args) {

		CreateNumber cn = new CreateNumber();

		/*Thread t1 = new Thread(new CreateRunnable(cn));

		Thread t2 = new Thread(new CreateRunnable(cn));

		Thread t3 = new Thread(new CreateRunnable(cn));

		t1.start();
		t2.start();
		t3.start();*/

		//由于初始化的时候，把当前的线程对象作为Map的key，设置值的时候，也是通过当前线程的key获取其对象。
		ExecutorService es = Executors.newFixedThreadPool(1);

		es.execute(new CreateRunnable(cn));
		es.execute(new CreateRunnable(cn));
		es.execute(new CreateRunnable(cn));

		es.shutdown();


	}
}
