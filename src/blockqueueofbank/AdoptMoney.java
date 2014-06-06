package blockqueueofbank;

import java.util.concurrent.BlockingQueue;


/**
 * 取钱任务:取一万次钱，每次100元.
 * @author jian.li
 *
 */
public class AdoptMoney implements Runnable {
	
	private BlockingQueue<BankAccount> queue;

	

	public AdoptMoney(BlockingQueue<BankAccount> queue) {
		
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
		
		for(int i = 0;i<10000;i++){
			
				bank.adopt(100);
		}
		
		
		try {
			queue.put(bank);
		
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}

}
