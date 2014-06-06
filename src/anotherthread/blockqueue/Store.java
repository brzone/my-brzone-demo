package anotherthread.blockqueue;
/**
 * 仓库
 * @author jian.li
 * @date 2011-5-5 10:34
 *
 */
public class Store {

	public int amount;

	public Store() {
		amount = 5;
	}

	/**
	 *  消费
	 */
	public void consumer() {
		int oldamount = amount;

		System.out.print("数量：" + oldamount + ",");

		if (0 < amount)amount--;

		System.out.print(oldamount == amount ? "没消费，" : "消费了一个，");
		System.out.println("还有" + amount + "个。");
	}

	/**
	 *  生产
	 */

	public void procuder() {

		int oldamount = amount;
		System.out.print("数量：" + oldamount + ",");

		if (amount < 10)amount++;

		//仓库最大容量为10
		System.out.print(oldamount == amount ? "没 生产，" : "生产了一个，");
		System.out.println("还有" + amount + "个。");

	}

}
