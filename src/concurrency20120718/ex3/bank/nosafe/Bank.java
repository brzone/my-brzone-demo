package concurrency20120718.ex3.bank.nosafe;

import java.util.concurrent.TimeUnit;

public class Bank {

	private long amount;

	public Bank(long amount) {
		super();
		this.amount = amount;
	}

	public void qun(long account,int delaytime) {

		if(account <= amount) {

			try {

				TimeUnit.SECONDS.sleep(delaytime);

				amount = amount - account;

				System.out.println("successfully!余额：" + amount);


			} catch (InterruptedException e) {

				e.printStackTrace();
				throw new RuntimeException(e);
			}


		} else {

			System.out.println("fail,余额不足:" + this.amount);

		}

	}

}
