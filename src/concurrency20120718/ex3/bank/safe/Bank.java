package concurrency20120718.ex3.bank.safe;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class Bank {

	private AtomicLong account;

	public Bank(long amount) {
		super();
		account = new AtomicLong(amount);
	}

	public long getAccount() {

		return account.get();
	}

	public void qun(long amount,int delaytime) {

		if(getAccount() >= amount) {

			try {

				long oldValue = getAccount();

				TimeUnit.SECONDS.sleep(delaytime);

				/**
				 * 获取最新的值，和睡眠钱查询的值进行比较，如果，相同的话，就进行
				 * 原子操作的更新操作，如果，不相同的话，就直接输入错误了。
				 * cas是硬件级别的原子操作
				 */
				if(account.compareAndSet(oldValue, oldValue-amount)){

					System.out.println("successfully!余额：" + getAccount());

				} else {

					System.out.println("fail!余额：" + getAccount());
				}

			} catch (InterruptedException e) {

				e.printStackTrace();

				throw new RuntimeException(e);
			}




		}else {

			System.out.println("fail,余额不足:" + getAccount());
		}

	}


}
