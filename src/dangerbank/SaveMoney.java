package dangerbank;

public class SaveMoney implements Runnable{

	private BankAccountInte bank;
	
	public SaveMoney(BankAccountInte bank) {
		super();
		this.bank = bank;
	}


	@Override
	public void run() {
		
		for(int i = 0;i<100000;i++) {
			
			bank.save(100);
		}
		
	}

}
