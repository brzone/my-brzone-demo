package concurrency20120718.ex3.queue.block;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 生产者
 * @author li jian
 *
 * @date 2012-8-14 下午02:15:34
 */
public class Producers implements Runnable{

	private String[] arr = "city marke life more better".split(" ");

	private Random random;

	private BlockingQueue<String> queue;

	public Producers(BlockingQueue<String> queue) {
		super();
		this.queue = queue;
		random = new Random();
	}

	@Override
	public void run() {

		while(true) {

			String msg = getProducerString();
			try {
				queue.put(msg);

				TimeUnit.SECONDS.sleep(2);

				System.out.println(Thread.currentThread().getName()+" Producer:" + msg);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}


		}

	}


	private String getProducerString() {

	//	return arr.
		return arr[random.nextInt(arr.length-1)];
	}

}
