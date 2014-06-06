package concurrency20120718.ex3.queue.block;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 消费者
 * @author li jian
 *
 * @date 2012-8-14 下午02:39:24
 */
public class Consumer implements Runnable {

	private BlockingQueue<String> queue;

	public Consumer(BlockingQueue<String> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {

		while(true) {

			try {

				TimeUnit.SECONDS.sleep(2);
				String msg = queue.take();

				System.out.println(Thread.currentThread().getName()+" Consumer:" + msg);

			} catch (InterruptedException e) {

				e.printStackTrace();
			}



		}
	}



}
