package concurrency20120718.ex1.runable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import concurrency20120718.ex1.executors.SimpleRunnable;

/**
 *
 * @author li jian
 *
 * @date 2012-7-19 上午10:22:39
 */
public class Client {

	public static void main(String[] args) {

		ExecutorService exec =  Executors.newFixedThreadPool(2);

		for(int i = 0;i<10;i++) {

			exec.execute(new SimpleRunnable("id:"+i));

		}

		//会把任务给执行完之后，关闭线程，即清理其中的线程池，此时是不能提交新的任务的。
		exec.shutdown();
	}

}
