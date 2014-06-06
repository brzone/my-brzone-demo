package concurrency20120718.ex3.exchangertest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class Producers implements Runnable {

	private Exchanger<List<String>> ex;

	public Producers(Exchanger<List<String>> ex) {
		super();
		this.ex = ex;
	}

	@Override
	public void run() {

		List<String> myDate = new ArrayList<String>(4);

		for(String s : "one world one dream".split(" ")) {

			System.out.println("生成者生成一个数据：[" + s + "]");

			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {

				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}



		try {

			List<String> getDate = ex.exchange(myDate);

			for(String s : getDate) {

				System.out.println("生成者从消费者获取的数据：" + s);

			}

		} catch (InterruptedException e) {

			e.printStackTrace();

			throw new RuntimeException(e);
		}

	}

}
