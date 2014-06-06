package concurrency20120718.ex3.queue.block;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author li jian
 *
 * @date 2012-8-14 下午06:08:23
 */
public class Client {

	public static void main(String[] args) {

		ExecutorService exec = Executors.newCachedThreadPool();

        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(5);

        /**
         * 俩个消费者，一个生产者，造成供不应求，生产一个，便被消费了。
         */
        exec.execute(new Producers(queue));

        exec.execute(new Consumer(queue));
        exec.execute(new Consumer(queue));

        exec.shutdown();

	}

}
