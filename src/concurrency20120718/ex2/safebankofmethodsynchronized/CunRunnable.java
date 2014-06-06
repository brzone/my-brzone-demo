package concurrency20120718.ex2.safebankofmethodsynchronized;

public class CunRunnable implements Runnable {

	private Bank bank;

	private int oneCunAmount;






	public CunRunnable(Bank bank, int oneCunAmount) {
		super();
		this.bank = bank;
		this.oneCunAmount = oneCunAmount;
	}






	@Override
	public void run() {

		for(int i = 0;i< 100000;i++) {

			bank.cun(oneCunAmount);
		}

	}

}
