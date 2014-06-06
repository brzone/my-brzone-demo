package concurrency20120718.ex3.reentrantlockdemo.nosafe.saft;

import java.util.concurrent.CountDownLatch;

public class Gatherable  implements Runnable{

	private CountDownLatch latch;

	private Counter counter;

	public Gatherable(CountDownLatch latch, Counter counter) {
		super();
		this.latch = latch;
		this.counter = counter;
	}


	@Override
	public void run() {

		try {
			latch.await();
			System.out.println("Amount:" + counter.getAmount());
		} catch (InterruptedException e) {

			e.printStackTrace();
			throw new RuntimeException(e);
		}



	}

}
