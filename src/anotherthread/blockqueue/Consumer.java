package anotherthread.blockqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 
 * 消费者
 * @author jian.li
 *
 */
public class Consumer implements Runnable {
	
	private BlockingQueue<Store> block;

	public Consumer(BlockingQueue<Store> block) {
		this.block = block;
	}

	@Override
	public void run() {

		while(!Thread.interrupted()) {
			
			try {
				
				/**
				 *  消费者：
				 *      1.拿堵塞队列中的Store对象
				 *      2.消费(消费条件在Store中)
				 *      3.把取出的对象put进堵塞队列 
				 */
				
				Store store = block.take();
				store.consumer();
				block.put(store);
				
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

}
