package anotherthread.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试类
 * @author jian.li
 *
 */
public class Client {

	
	public static void main(String[] args) {

		ExecutorService exec = Executors.newCachedThreadPool();
		
		/*由于生产者和消费者操作的是同一对象，故传的容量大小为1*/
		BlockingQueue<Store> block = new ArrayBlockingQueue<Store>(1);
		
		/*BlockingQueue添加一个仓库对象*/
		block.add(new Store());
		
		/**
		 * 一个生产者和俩个消费者，最后会造成供不应求的局面
		 */
		exec.execute(new Procuder(block));
		
		exec.execute(new Consumer(block));
	    exec.execute(new Consumer(block));
		
		
	}

}
