package concurrency20120718.ex3.futuretest;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 一个Callable任务。
 * @author li jian
 * @mail brzone@126.com
 * @date 2012-9-19 下午04:53:57
 */
public class PrivateAccountCallable  implements Callable<Integer>{

	private static final Random random = new Random(47);

	@Override
	public Integer call() throws Exception {

		TimeUnit.SECONDS.sleep(5);

		int privateAccount = random.nextInt(10000);

		System.out.println("私人账户有金额:" + privateAccount);

		return privateAccount;
	}

}
