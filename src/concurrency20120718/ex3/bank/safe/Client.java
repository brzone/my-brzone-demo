package concurrency20120718.ex3.bank.safe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author li jian
 *
 * @date 2012-8-13 上午11:11:21
 */
public class Client {

	public static void main(String[] args) {

		ExecutorService exec = Executors.newFixedThreadPool(2);

		Bank bank = new Bank(100);

		exec.execute(new BankRunnable(bank, 100, 2));
		exec.execute(new BankRunnable(bank, 100, 0));

		exec.shutdown();
	}

}
