package timer;

import java.util.TimerTask;

/**
 *
 * @author li.jian
 * @date 2011-9-1 下午05:02:22
 */

public class HelloTimerTask extends TimerTask{

	private static int count = 0;
	
	private String msg ;
	
	public HelloTimerTask(String msg) {
		
		this.msg = msg;
	}
	
	@Override
	public void run() {
		
		/**
		 *  可以把发送邮件的代码放在这儿，当然发送的方法会返回一个boolean值，当boolean的true时，
		 *  便更新账单的标志位，应该把发送邮件的所有异常给处理掉，已免造成Timer出现错误(最后最后一层为Exception)
		 * 
		 * 那此时有个问题：如果是，定时发送，那标志位呢？写不发送，应该不是，因为在未来的某个时间会发送，发送，也不对，因为，
		 * 可能会发送失败.
		 * 
		 * 策约：不管是及时发送，还是，定时发送，首先把标志位置为发送(1)，然后看发送返回的boolean的结果，如果为true，则不需要修改了，
		 * 如果为false，则把标志位修改为未发送.
		 * 
		 * 
		 * 传的值应该有：  地址（to），billid
		 * 
		 */
		
		System.out.println("count:" + (count++) + "\t" +
				  new java.util.Date(scheduledExecutionTime()) + "\t" + msg);
		
	}

}
