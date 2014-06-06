package concurrency20120718.ex3.reentrantlockdemo.nosafe.saft;

import java.util.concurrent.CountDownLatch;

public class Incrementable implements Runnable {

	private CountDownLatch latch;

	private Counter counter;

	public Incrementable(CountDownLatch latch, Counter counter) {
		super();
		this.latch = latch;
		this.counter = counter;
	}



	@Override
	public void run() {

		for(int i = 0;i<10000;i++) {

			counter.incrent();

		}

		latch.countDown();

	}

}
