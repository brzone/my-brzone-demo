package concurrency20120718.ex3.futuretest.other2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 *
 * @author li jian
 * @mail brzone@126.com
 * @date 2012-9-25 上午09:47:37
 */
public class Client2 {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

		ExecutorService exec = Executors.newSingleThreadExecutor();

		Future<Boolean>  futer = exec.submit(new GirlAnswerCallable());

		System.out.println("To girl: When I first saw you, I fell in love with you.");

		boolean success = false;

		try {
			success = futer.get(5, TimeUnit.SECONDS);

			System.out.print("girl says: ");
			System.out.println(success ? "yes." : "no.");

		}catch(TimeoutException e) {

			System.out.println("女孩超过5秒没回复，你就死了这份心吧。");

			//中断运行，不能让女方给张"好人卡"，拔腿就跑.
			futer.cancel(true);

		}

		exec.shutdown();

	}

}
