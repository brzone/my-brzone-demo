package thread20140331.ex06;

public class Bank {

	private long balance;

	public Bank(long balance) {
		this.balance = balance;
	}

	public  void deposit(long amount) {

		this.balance +=  amount;

	}

	public  void take(long amount) {

		this.balance -= amount;
	}

	public long getBalance() {

		return this.balance;
	}

	@Override
	public String toString() {
		return "Bank [balance=" + balance + "]";
	}

}
