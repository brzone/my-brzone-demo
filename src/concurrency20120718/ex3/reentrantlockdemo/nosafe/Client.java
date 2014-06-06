package concurrency20120718.ex3.reentrantlockdemo.nosafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

	public static void main(String[] args) {

		//10个增加计数线程
		CountDownLatch latch = new CountDownLatch(10);

		Counter counter = new Counter();

		ExecutorService exec = Executors.newCachedThreadPool();

		exec.execute(new Gatherable(latch,counter));

		for(int i = 0;i<10;i++) {

			exec.execute(new Incrementable(latch,counter));

		}

		exec.shutdown();

	}

}
