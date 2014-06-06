package atomicinteger;

import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NoSafeClient implements Runnable {

	private NotSafeCount count;
	private static Set<Integer> set = new TreeSet<Integer>();

	public NoSafeClient(NotSafeCount count) {
		super();
		this.count = count;
	}

	@Override
	public void run() {

		int value = count.increment();
		System.out.println("value:" + value);
		set.add(value);
		
	}

	public static void main(String[] args) throws InterruptedException {

		NotSafeCount count = new NotSafeCount();
		
		ExecutorService exec = Executors.newCachedThreadPool();
		
		/**
		 * 线程起到10000的时候，终于出现了不对劲地方：
		 * size：9971
		 * 很明显出现了重复的数字，这也证明++i不是原子操作,
		 * 那这是怎么出现这中现象的呢？
		 * 譬如：有俩线程A、B，
		 *           value：5
		 *           A，把值给修改为6，但是这是还没来得及写入到内存中，B这时也
		 *           来修改值，但是它获取的值是5，也给修改为6，这样俩次的增加确
		 *           只有一次增加。
		 *           
		 *           B读取的不是最近写入的值，最近写入的值还没来得及写入，便读取了
		 *           不正常状态下的值。
		 */
		
		for(int i = 0;i<10000;i++) {
			
			exec.execute(new NoSafeClient(count));
		}
		
		exec.shutdown();
		
		TimeUnit.SECONDS.sleep(10);
		
		System.out.println(set.size());
		System.out.println(set);
	}

}
