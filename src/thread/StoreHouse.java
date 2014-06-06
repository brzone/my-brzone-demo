package thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 一个仓库类: 加入同步
 * 
 * @author jian.li
 * 
 */

public class StoreHouse {

	private int acount = 5;

	/* 仓库的容量 */
	private final static int MAX_ACOUNT = 10;

	public synchronized int getAcount() {

		return acount;
	}

	public synchronized void push() throws InterruptedException {

		while (full()) {
			System.out.println("Thread :[" + Thread.currentThread().getName()
					+ "] wait.");
			wait();

		}

		System.out.println();
		System.out.println("当前仓库数量为：" + getAcount());
		acount++;
		System.out.println("-----------After push--"
				+ Thread.currentThread().getName()
				+ "   "
				+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.format(new Date()));
		System.out.println("当前仓库数量为：" + getAcount());
		System.out.println();

		notifyAll();

	}

	public synchronized void pop() throws InterruptedException {

		while (this.empty()) {
			System.out.println("Thread :[" + Thread.currentThread().getName()
					+ "] wait.");
			wait();
		}
		System.out.println();
		System.out.println("当前仓库数量为：" + getAcount());
		acount--;
		System.out.println("-----------After pop---"
				+ Thread.currentThread().getName()
				+ "  "
				+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.format(new Date()));
		System.out.println("当前仓库数量为：" + getAcount());
		System.out.println();

		notifyAll();

	}

	public synchronized boolean empty() {

		return acount <= 0;
	}

	public synchronized boolean full() {

		return acount >= MAX_ACOUNT;
	}

}
