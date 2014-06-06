package scheduledthreadpoolexecutor;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author li.jian
 * @date 2011-9-9 上午09:06:06
 */

public class ScheduledDemo {

	private static final SimpleDateFormat sdf = 
						new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private static String currentTime() {
		
		return sdf.format(new java.util.Date());
	}
	
	public static void main(String[] args) {
		
		
		System.out.println("---" + File.separator + "---");
		
		Runnable run = new Runnable() {
			
			@Override
			public void run() {
				
				System.out.println(currentTime());
				
				
			}
		};
		
		Runnable run2 = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("RuntimeException!");
				throw new RuntimeException();
				
				
			}
		};
		
		
		
		//ScheduledThreadPoolExecutor可以运用多线程进行驱动
		ScheduledThreadPoolExecutor exe = new ScheduledThreadPoolExecutor(2);
		
		System.out.println(currentTime());
		//不想延迟的话，把值设为0L就OK了
	//	exe.schedule(run, 1L, TimeUnit.SECONDS);
		
		//先延迟4秒，再每隔5秒执行一次 
		exe.scheduleAtFixedRate(run, 4L, 5L, TimeUnit.SECONDS);
		exe.scheduleAtFixedRate(run2, 4L, 5L, TimeUnit.SECONDS);
		
		//抛了一次异常，便把那个任务给除掉了，所以，在这里的话，应该把所以的异常给处理掉
		
		/**
		 * 一帮是选择xx年xx月xx日，就可以选择延迟天来了:TimeUnit.DAYS,一天，二天......
		 * 如果，不需要延迟的话，传的值为0L即可
		 */
		
	}
	
}
