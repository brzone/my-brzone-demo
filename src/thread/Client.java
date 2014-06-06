package thread;

public class Client {

	public static void main(String[] args) {

		StoreHouse store = new StoreHouse();

		/* Producer-01 */
		new Thread(new Producer(store), "Producer-01").start();

		/* Consumer-01 */
		new Thread(new Consumer(store), "Consumer-01").start();

		/* Consumer-02 */
		new Thread(new Consumer(store), "Consumer-02").start();

	}

}
