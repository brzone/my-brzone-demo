package blockqueueofbank;

import java.util.concurrent.BlockingQueue;

/**
 * 存钱:存一万次钱，每次100元.
 * @author jian.li
 *
 */
public class DepositMoney implements Runnable {

	private BlockingQueue<BankAccount> queue;
	
	

	public DepositMoney(BlockingQueue<BankAccount> queue) {
	
		this.queue = queue;
	}



	@Override
	public void run() {

		BankAccount bank = null;
		try {
			bank = queue.take();
		} catch (InterruptedException e1) {
		
			e1.printStackTrace();
		}
		
		for (int i = 0; i < 10000; i++) {

				bank.deposit(100);
		
		}
		
		
		try {
			queue.put(bank);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
