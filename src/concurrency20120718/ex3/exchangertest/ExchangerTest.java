package concurrency20120718.ex3.exchangertest;

import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import concurrency20120718.ex3.countdownlatch.Consumer;

public class ExchangerTest {

	public static void main(String[] args) {

		final Exchanger<List<String>>  ex = new Exchanger<List<String>>();

	/*	ExecutorService exec = Executors.newCachedThreadPool();

		exec.execute(new Consumer(ex));

		exec.execute(new Producers(ex));*/

		new Thread(new Consumer(ex)).start();
		new Thread(new Producers(ex)).start();



		//exec.shutdown();

	}

}
