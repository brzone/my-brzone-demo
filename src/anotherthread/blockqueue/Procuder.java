package anotherthread.blockqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 生产者
 * @author jian.li
 *
 */

public class Procuder implements Runnable {

	private BlockingQueue<Store> block;

	public Procuder(BlockingQueue<Store> block) {
		this.block = block;
	}

	@Override
	public void run() {

		while (!Thread.interrupted()) {
			try {

				/**
				 * 首先生产者从堵塞队列中take仓库对象，若堵塞队列
				 * 没有元素，将等待，拿到对象之后，进行生产(在这
				 * 里，是否生产的条件在Store类中写好)，生产完，便
				 * 把刚才取出的对象put进去
				 *
				 */

				Store store = block.take();
				store.procuder();
				block.put(store);

				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
