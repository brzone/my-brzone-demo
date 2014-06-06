package cyclicbarrier;

import java.text.SimpleDateFormat;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Tour implements Runnable{

	private String name;
	private int[] time;
	private CyclicBarrier barrier;
	
	/*时：分：秒*/
    private static SimpleDateFormat sdf = new SimpleDateFormat("kk:mm:ss");
	
	public Tour(String name, int[] time, CyclicBarrier barrier) {
		this.name = name;
		this.time = time;
		this.barrier = barrier;
	}



	@Override
	public void run() {
		
	
			try {
				
				/**
				 * CyclicBarrier: 可循环利用的屏障点
				 * 
				 * 当某任务调用await(),任务的执行便会在此刻而堵塞，那要什么时候才能解除呢？
				 *        曾记否在创建CyclicBarrier的时候传的第一个int类型的参数，记为j，
				 *        如果j个线程都调用了await()，此时便到达了屏障点了，下面的代码便
				 *        会解除锁定，很明显执行下面的代码也会是上一个的循环
				 * 
				 */
				
				
				TimeUnit.SECONDS.sleep(time[0]);
				System.out.println(name + " reach shenzhen , time:" + now());
				barrier.await();
				
				TimeUnit.SECONDS.sleep(time[1]);
				System.out.println(name + " reach guangdong , time:" + now());
				barrier.await();
				
				TimeUnit.SECONDS.sleep(time[2]);
				System.out.println(name + " reach chongqing , time:" + now());
				barrier.await();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
			
			
	
	}
	
	public String now() {
		
		return sdf.format(new java.util.Date());
	}

}
