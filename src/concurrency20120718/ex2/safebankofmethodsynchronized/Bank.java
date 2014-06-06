package concurrency20120718.ex2.safebankofmethodsynchronized;

/**
 *银行类
 * @author li jian
 *
 * @date 2012-8-3 上午10:07:05
 */
public class Bank {

	private int account;

	public Bank(int account) {
		super();
		this.account = account;
	}

	/**
	 * 取钱
	 * @param amount
	 */
	public  synchronized void qu(int amount) {

		account = account - amount;
	}

	/**
	 * 存钱
	 * @param amount
	 */
	public  synchronized void cun(int amount) {

		account = account + amount;
	}

	@Override
	public String toString() {
		return "Bank [account=" + account + "]";
	}

}
