package anotherthread;

import java.util.concurrent.TimeUnit;

public class Store {
	
	private int count = 5;
	
	/**
	 *  生产：每次生产一个 
	 * @throws InterruptedException 
	 */
	
	public synchronized void produce() throws InterruptedException {
		
		count++;
		System.out.println("生产了1个,共有" + count + "个.");
	
		TimeUnit.SECONDS.sleep(2);
		notifyAll();
		
	}
	
	/**
	 * 消费:每次消费个2个
	 * @throws InterruptedException 
	 */
	
	public synchronized void consumer() throws InterruptedException {
		
		count--;
		count--;
		System.out.println("消费了2个，还有" + count + "个!");
		TimeUnit.SECONDS.sleep(2);
		notifyAll();
	}
	
	/**
	 * 小于2个的时候，便要等待生产了
	 * @throws InterruptedException
	 */
	
	public synchronized void waitForProduce() throws InterruptedException {
		
		while(count < 2)
			wait();
	}
	
	/**
	 * 等于10的时候，便不能生产了，因为满了 ，等待消费了
	 * @throws InterruptedException
	 */
	
	public synchronized void waitForConsumer() throws InterruptedException {
		
		while(count == 10)
			wait();
		
	}
	
}
