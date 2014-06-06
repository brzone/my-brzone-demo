package atomicinteger;

import java.util.TreeSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Client implements Runnable{

	private SafeCount count;
	
	private static Set<Integer> set = new TreeSet<Integer>();
	
	public Client(SafeCount count) {
		this.count = count;
	}

	@Override
	public void run() {
		
		int value = count.increment();
		System.out.println("value:" + value);
		set.add(value);
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		SafeCount count = new SafeCount();
		
		ExecutorService exec = Executors.newCachedThreadPool();
		
		for(int i = 0;i<100;i++) {
			
			exec.execute(new Client(count));
		}
		
		exec.shutdown();

		TimeUnit.SECONDS.sleep(5);
		
		System.out.println(set.size());
		System.out.println(set);
		
	}

	

}
