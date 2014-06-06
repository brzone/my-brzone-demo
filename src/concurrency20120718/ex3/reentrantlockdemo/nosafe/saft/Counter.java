package concurrency20120718.ex3.reentrantlockdemo.nosafe.saft;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author li jian
 * @mail brzone@126.com
 * @date 2012-9-24 下午03:28:16
 */
public class Counter {

	private int amount;

	private static final Lock lock = new ReentrantLock();

	public void incrent() {

		try {
		lock.lock();
		amount++;
		}finally {
			lock.unlock();

		}
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {

		return ""  + amount;
	}

}
