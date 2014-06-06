package simulationbank;


public class DepositMoney implements Runnable {

	private BankAccount bank;

	public DepositMoney(BankAccount bank) {
		this.bank = bank;
	}

	@Override
	public void run() {

		for (int i = 0; i < 10000; i++) {

			bank.deposit(100);
		}

	}

}
