package countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class SomeNoNeedWaitTask implements Runnable{

	/*有点信号量 的意味*/
	private CountDownLatch countDown;
	
	private static int index = 1;
	
	private int id;
	
	public SomeNoNeedWaitTask(CountDownLatch countDown) {
		this.countDown = countDown;
		id = index++;
	}


	@Override
	public void run() {
		
		/*做一些事情，做完之后，便把信号量减一*/
		/*这可要自己做，不然就会让人干等着*/
		doWork();
		countDown.countDown();
		
	}
	
	public void doWork() {
		
		try {
			TimeUnit.SECONDS.sleep(5);
			System.out.println("The["+ id+ "]  SomeNoNeedWaitTask of task has finish!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
}


class NeedAllTaskEnd implements Runnable {
	
	private CountDownLatch countDown;
	

	public NeedAllTaskEnd(CountDownLatch countDown) {
		this.countDown = countDown;
	}



	@Override
	public void run() {
		
		try {
			/*
			 * 在CountDownLatch的计数器不为零的情况下，该线程是一直等待，也就是一直堵塞
			 * 比方说：
			 * 		在一个班级里，老师要等到全班同学都到了才开始上课，这里老师应该一直await(),
			 * 		直到同学们一起到了的时候(当然任意同学到的时候，可要调用countDown())，await()
			 * 		才解除堵塞，同学们上课了.
			 * 
			 */
			countDown.await();
			doWork();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void doWork() {
		
		System.out.println("Wa,It's me time.");
		
	}
}

/**
 * 测试CountDownLatch，也就是某任务，需在某某任务完成后才能执行
 * @author jian.li
 * @date 2011-4-13 09:10
 *
 */

public class CountDownLatchDemo {

	public static void main(String[] args) {
		
		/**
		 * 10个学生，三个老师
		 */
		
		int noneedwaitsize = 10;
		
		int needwaitsize = 3;
		
		/*All task should be share the single of CountDownLatch*/
		CountDownLatch countDown = new CountDownLatch(noneedwaitsize);
		
		ExecutorService exec = Executors.newCachedThreadPool();
		
		for(int i = 0;i<needwaitsize;i++) {
			
			exec.execute(new NeedAllTaskEnd(countDown));
		}
		
		for(int i = 0;i<noneedwaitsize;i++) {
			
			exec.execute(new SomeNoNeedWaitTask(countDown));
		}
		
		exec.shutdown();
	}
	
}
