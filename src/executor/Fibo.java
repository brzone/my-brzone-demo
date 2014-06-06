package executor;

import java.text.SimpleDateFormat;
import java.util.concurrent.Callable;

public class Fibo implements Callable<Integer> {

	public int count;
	
	public Fibo(){}

	public Fibo(int count) {

		this.count = count;
	}

	@Override
	public Integer call() throws Exception {

		return fibo(count);
	}

	private int fibo(int f) {

		if (f == 1 || f == 2)return 1;

		return fibo(f - 1) + fibo(f - 2);

	}
	
	public static void main(String[] args) {
		
		Fibo fibo = new Fibo();
		
		long start = System.nanoTime();
		
		System.out.println(new SimpleDateFormat("mm:ss").format(new java.util.Date()));
		
		System.out.println(fibo.fibo(45));
		
		long time = System.nanoTime() - start;
		
		System.out.println(new SimpleDateFormat("mm:ss").format(new java.util.Date()));
		
		
		System.out.println(time/1000000000);
		
	}

}
