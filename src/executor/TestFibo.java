package executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TestFibo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService exec = Executors.newCachedThreadPool();
		
		/*FutureTask也实现了Runnable接口,FutureTask是Future的一个实现*/
		FutureTask<Integer> ft = new FutureTask<Integer>(new Fibo(45));
		
		/*当做一个普通的Runnable执行(execute)，因为FutureTask也实现了Runnable*/
		exec.execute(ft);
		
		int result = 0;
		
		//如果你需要任务还没计算出来，便一直等待，你可以这样写
	   /*	while(!ft.isDone()) {
			
			TimeUnit.SECONDS.sleep(1);
			
		}
		
		//但是获取结果，可是要FutureTask的get方法
		result = ft.get();
		*/
		
		try {
		
			/**
			 * 如果对于结果的返回时间很重要，可以用get带
			 * 延迟的方法 , 如果延迟的话便会抛出TimeoutException
			 * 
			 */
			
		result = ft.get(1, TimeUnit.SECONDS);
		
		
		} catch (TimeoutException e) {
			
			System.out.println("哎呀，计算超时了!");
			
			ft.cancel(true);
			
			result = -1;
			
		}
		
		System.out.println(result);
		
		
		/*
		
		List<Future<Integer>> list = new ArrayList<Future<Integer>>();
		
		
		for(int i = 10;i>3;i--) {
			
			//ExecutorService的submit(Callable<T>)可以 返回一个Future
			list.add(exec.submit(new Fibo(i)));
			
		}
		
		for(Future<Integer> future : list) {
			
			try {
				System.out.println(future.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
			
		}
		
		*/
		
		exec.shutdown();
	}

}
