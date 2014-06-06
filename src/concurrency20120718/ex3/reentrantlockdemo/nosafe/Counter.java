package concurrency20120718.ex3.reentrantlockdemo.nosafe;

/**
 *
 * @author li jian
 * @mail brzone@126.com
 * @date 2012-9-24 下午03:28:16
 */
public class Counter {

	private int amount;

	public void incrent() {

		amount++;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {

		return ""  + amount;
	}

}
