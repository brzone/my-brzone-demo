package blockqueueofbank;

public class BankAccount {

	private String bankno;

	private int balance;

	public BankAccount(String bankno, int balance) {

		this.bankno = bankno;
		this.balance = balance;
	}

	public String getBankno() {
		return bankno;
	}

	public void setBankno(String bankno) {
		this.bankno = bankno;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public  void adopt(int amount) {

		this.balance = this.balance - amount;

	}

	public  void deposit(int amount) {

		this.balance = this.balance + amount;

	}
}
