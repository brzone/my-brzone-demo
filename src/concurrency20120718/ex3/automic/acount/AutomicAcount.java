package concurrency20120718.ex3.automic.acount;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author li jian
 *
 * @date 2012-8-13 上午10:20:17
 */
public class AutomicAcount {

	private AtomicInteger atomic;

	public AutomicAcount() {

		atomic = new AtomicInteger();
	}

	public int get() {

		return atomic.get();
	}

	/**
	 * 加一，然后返回加一之后的值
	 * @return
	 */
	public int increment() {

		return atomic.incrementAndGet();
	}

	/**
	 * 加上你想加的值，然后返回加上之后的值
	 * @param amount
	 * @return
	 */
	public int addAndGet(int amount) {

		return atomic.addAndGet(amount);
	}

	@Override
	public String toString() {

		return "" + get();
	}

}
