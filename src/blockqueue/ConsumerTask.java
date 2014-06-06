package blockqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ConsumerTask implements Runnable {

	private BlockingQueue<String> queue;

	public ConsumerTask(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		
		boolean flag = true;
		
		while(flag){
			
			try {
				String s = queue.take();
				System.out.println("Consumer :   " +Thread.currentThread().getName()+"  " +s);
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
				flag = false;
			}
		}
		
		
		
		
		
		

	}
	
	
}
