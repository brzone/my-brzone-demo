package concurrency20120718.ex3.countdownlatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author li jian
 * @mail brzone@126.com
 * @date 2012-9-19 下午03:52:40
 */
public class Consumer implements Runnable {

	private Exchanger<List<String>> ex;

	public Consumer(Exchanger<List<String>> ex) {
		super();
		this.ex = ex;
	}

	@Override
	public void run() {

		List<String> myData = new ArrayList<String>(4);

		for(String s : "I love you forever".split(" ")) {

			myData.add(s);
			System.out.println("消费者产生一个数据:[" + s + "]");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {

				e.printStackTrace();
				throw new RuntimeException(e);
			}

		}

		try {

			List<String> getData = ex.exchange(myData);

			for(String s : getData) {

				System.out.println("消费者从生产者获取的数据:" + s);

			}

		} catch (InterruptedException e) {

			e.printStackTrace();
		}


	}

}
