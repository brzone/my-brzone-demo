package concurrency20120718.ex1.runable;

/**
 *
 * @author li jian
 *
 * @date 2012-7-18 下午05:54:52
 */
public class SimpleRunable implements Runnable{

	@Override
	public void run() {

		for(int i = 0;i<5;i++) {
				System.out.println(Thread.currentThread().getName() + ":\t" + i);
		}
	}

	public static void main(String[] args) {

		for (int i = 0;i< 5;i++) {

			new Thread(new SimpleRunable()).start();

		}

	}

}
