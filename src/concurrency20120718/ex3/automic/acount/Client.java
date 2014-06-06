package concurrency20120718.ex3.automic.acount;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

	public static void main(String[] args) {

		ExecutorService exec =  Executors.newCachedThreadPool();

		AutomicAcount acount = new AutomicAcount();

		for(int i = 0;i<3;i++) {

			exec.execute(new AcountRunnable(acount));

		}

		exec.shutdown();

	}

}
