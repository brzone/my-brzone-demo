package concurrency20120718.ex2.nosafebank;

public class QuRunnable implements Runnable {

	private Bank bank;

	private int oneQuAmount;



	public QuRunnable(Bank bank, int oneQuAmount) {
		super();
		this.bank = bank;
		this.oneQuAmount = oneQuAmount;
	}



	@Override
	public void run() {

		for(int i = 0;i< 100000;i++) {

			bank.qu(oneQuAmount);
		}

	}

}
