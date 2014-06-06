package dangerbank;

/**
 * 银行卡
 * 
 * @author jian.li
 * @tip 跑步也是一种艺术，热爱丢脸是艺术?李阳说Yes.
 */

public class BankAccount implements BankAccountInte {

	/* 卡号 */
	private int number;

	/* 余额 */
	private int balance;

	public BankAccount(int number, int balance) {
		this.number = number;
		this.balance = balance;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	/**
	 * 存钱
	 * 
	 * @param amount
	 */
	public void save(int amount) {

		this.balance += amount;

	}

	/**
	 * 取钱
	 * 
	 * @param amount
	 */
	public void take(int amount) {

		this.balance -= amount;
	}

}
