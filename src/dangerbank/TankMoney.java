package dangerbank;

public class TankMoney implements Runnable{

	private BankAccountInte bank;
	
	public TankMoney(BankAccountInte bank) {
		super();
		this.bank = bank;
	}

	@Override
	public void run() {
		
		for(int i = 0;i<100000;i++){
			bank.take(100);
		}
	}

}
