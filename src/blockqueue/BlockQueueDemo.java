package blockqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockQueueDemo {

	public static void main(String[] args) {

		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(4);

		ExecutorService exec = Executors.newFixedThreadPool(3);

		exec.execute(new ProducerTask(queue));

		exec.execute(new ConsumerTask(queue));
		exec.execute(new ConsumerTask(queue));

		exec.shutdown();
	}
} 
