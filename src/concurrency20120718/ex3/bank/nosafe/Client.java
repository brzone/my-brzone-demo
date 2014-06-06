package concurrency20120718.ex3.bank.nosafe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

	public static void main(String[] args) {

		ExecutorService exec = Executors.newFixedThreadPool(2);

		final Bank bank = new Bank(100);



		for(int i = 0;i<2;i++) {

			final int temp = i;

			exec.execute(new Runnable() {

				@Override
				public void run() {

					bank.qun(100,temp==0 ? 2:0 );

				}
			});

		}


		exec.shutdown();
	}

}
