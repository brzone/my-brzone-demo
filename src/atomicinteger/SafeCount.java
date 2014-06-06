package atomicinteger;

import java.util.concurrent.atomic.AtomicInteger;

public class SafeCount {

	/*原子Integer，采用的无锁算法*/
	private AtomicInteger ai;
	
	public SafeCount() {
	   
		/*lazy init*/	
		ai = new AtomicInteger();
	}
	
	/**
	 * 获取计数的值
	 * @return
	 */
	public int get() {
		return ai.get();
	}
	
	/**
	 * 递增1
	 * @return
	 */
	public int increment() {
		
		return ai.incrementAndGet();
	}
	
	/**
	 * 递增i
	 * @param i
	 * @return
	 */
	
	public int increment(int i) {
		
		return ai.addAndGet(i);
	}
	
	/**
	 * 递减1
	 * @return
	 */
	public int decrement() {
		
		return ai.decrementAndGet();
	}
	
	/**
	 * 递减i
	 * @param i
	 * @return
	 */
	public int decrement(int i) {
		
		return ai.addAndGet(-i);
	}
	
}
