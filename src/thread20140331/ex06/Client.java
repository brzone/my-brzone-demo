package thread20140331.ex06;

public class Client {

	public static void main(String[] args) {

		Bank bank = new Bank(100);

		Thread deposit = new Thread(new DepositRunable(bank,10000));

		Thread take = new Thread(new TakeRunnable(bank,10000));

		deposit.start();

		take.start();

		try {
			deposit.join();
			take.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		/**
		 * 输出的值，大部分不会是100元，因为简单的+ 和- 都不是原子操作，都有中间变量。
		 * 当一个线程要做+操作，先读取某个值保存起来，然后进行加操作，然后把值写回去，覆盖原值，
		 * 可不知，在写回去的同时，这个值已经被修改了。
		 *
		 */
		System.out.println(bank);

	}
}
