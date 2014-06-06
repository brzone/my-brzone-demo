package thread20140331.ex06;

public class DepositRunable implements Runnable {

	private Bank bank;
	private int amount;

	public DepositRunable (Bank bank,int amount) {
		this.bank = bank;
		this.amount = amount;
	}

	@Override
	public void run() {

		for(int i = 0;i<amount;i++) {
			bank.deposit(100);
		}

	}

}
