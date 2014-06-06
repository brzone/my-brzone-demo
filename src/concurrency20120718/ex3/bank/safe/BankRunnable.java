package concurrency20120718.ex3.bank.safe;

public class BankRunnable implements Runnable {

	private Bank bank;

	private long amount;

	private int delaytime;

	public BankRunnable(Bank bank, long amount, int delaytime) {
		super();
		this.bank = bank;
		this.amount = amount;
		this.delaytime = delaytime;
	}


	@Override
	public void run() {

		bank.qun(amount, delaytime);
	}

}
