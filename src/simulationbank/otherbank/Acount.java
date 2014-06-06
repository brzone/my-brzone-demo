package simulationbank.otherbank;

public class Acount {

	private int balance;

	public Acount(int balance) {
		super();
		this.balance = balance;
	}
	
	/**
	 *  取钱
	 * @param amount
	 */
	public synchronized void adopt(int amount,int delay) {
		
		if(balance >= amount) {
			
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
			this.balance = this.balance - amount;
			
			System.out.println(Thread.currentThread().getName() + "  " +
					"取了" + amount + ",还剩" + balance);
		
		} else {
			
			System.out.println("余额不足.");
		}
		
		
	}

}
