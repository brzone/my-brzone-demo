package simulationbank;


/**
 * 取钱任务
 * @author jian.li
 *
 */
public class AdoptMoney implements Runnable {

	private BankAccount bank;

	public AdoptMoney(BankAccount bank) {
		this.bank = bank;
	}

	@Override
	public void run() {

		for(int i = 0;i<10000;i++){
			
			bank.adopt(100);
			
		}
		
	}

}
