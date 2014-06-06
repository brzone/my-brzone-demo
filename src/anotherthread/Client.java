package anotherthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

	
	public static void main(String[] args) throws InterruptedException {

	
		ExecutorService exec = Executors.newCachedThreadPool();
		
		Store store = new Store();
		
		Procuder procuder = new Procuder(store);
		Consumer consumer = new Consumer(store);
		
		exec.submit(procuder);
		exec.submit(consumer);
		
		
		//TimeUnit.SECONDS.sleep(8);
		
		exec.shutdown();
		
		
	}

}
