package thread20140331.ex02;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SimpleRunable implements Runnable {

	private static final Random random = new Random(47);

	private String name;

	public SimpleRunable(String name) {
		this.name = name;
	}

	@Override
	public void run() {

		try {

			long sleepTime = random.nextInt(3);

			TimeUnit.SECONDS.sleep(sleepTime);
			System.out.println(name + "---" + Thread.currentThread().getName() + " has sleep " + sleepTime + "SECONDS.");
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

}
