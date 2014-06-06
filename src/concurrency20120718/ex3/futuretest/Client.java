package concurrency20120718.ex3.futuretest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Client {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

		ExecutorService exec = Executors.newSingleThreadExecutor();

		Callable<Integer> call = new PrivateAccountCallable();

		FutureTask<Integer> future = new FutureTask<Integer>(call);

		System.out.println("主线程开始执行......");

		int mainAccount = 1000;

		System.out.println("主账户有金额:" + mainAccount);

		exec.execute(future);

	while(!future.isDone()){

			TimeUnit.SECONDS.sleep(1);

			System.out.println("等私人账户计算...");

		}

	/**
	 * 	try {

		//这里话，当超过2秒没有结果的话，就会抛出TimeoutException，这个时候，我们可以取消执行
			privateAccount = future.get(2, TimeUnit.SECONDS);

		}catch(TimeoutException e) {

			//中断运行为true，不中断则为false(意思就是让它继续在后台执行了)
			future.cancel(true);

			System.out.println("超时了。");

		}
	 *
	 *
	 *
	 */


		System.out.println("私人账户计算完成。");

		int privateAccount = future.get();

		System.out.println("all:" + (mainAccount + privateAccount));

		exec.shutdown();

	}

}
