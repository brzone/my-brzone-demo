package concurrency20120718.ex1;

/**
 *
 * @author li jian
 *
 * @date 2012-7-18 下午05:49:03
 */
public class SimpleThread extends Thread{

	@Override
	public void run() {

		for(int i = 0; i < 5; i++) {

			System.out.println(this.getName() + ":\t" + i);
		}


	}


	public static void main(String[] args) {

		for(int i = 0;i<5;i++) {

			new SimpleThread().start();

		}

	}


}
