package timer;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

/**
 * 
 *
 * @author li.jian
 * @date 2011-9-1 下午05:03:34
 */

public class Client {
	
	private static Timer timer = new Timer();
	
	public static void addTask(String msg) {
		
		
		timer.schedule(new HelloTimerTask(msg), new java.util.Date());
		
	}
	
	public static void main(String[] args) throws InterruptedException {

		
		//一个Timer可以有上千个TimerTask(意思是可以共用Timer)
		
		//一个TimerTask也就是一个Runnable，它应该可以并行运行
		
		timer.schedule(new HelloTimerTask("first timer"), new java.util.Date());
		
		TimeUnit.SECONDS.sleep(3);
		addTask("city");
		TimeUnit.SECONDS.sleep(3);
		addTask("make");
		TimeUnit.SECONDS.sleep(3);
		addTask("life");
	}

}
