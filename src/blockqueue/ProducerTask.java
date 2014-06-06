package blockqueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ProducerTask implements Runnable {

	private BlockingQueue<String> queue;

	private static String[] msg = { "I", "love", "you", "forever" };

	private static Random random = new Random();

	public ProducerTask(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {

		boolean flag = true;

		while (flag) {

			try {
				String s = produce();
				queue.put(s);
				System.out.println("Produce :   " +Thread.currentThread().getName() +"   " +s);
				
				TimeUnit.SECONDS.sleep(2);
				
			} catch (InterruptedException e) {

				e.printStackTrace();

				flag = false;
			}
		}
	}

	public String produce() {

		return msg[random.nextInt(msg.length)];

	}

}
