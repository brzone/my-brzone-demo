package concurrency20120718.ex2.threadloacl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author li jian
 *
 * @date 2012-8-9 上午09:50:07
 */
public class Client {

	public static void main(String[] args) {

		ExecutorService exec = Executors.newFixedThreadPool(4);

		SequenceNum seqnum = new SequenceNum();

		for(int i = 0;i<4;i++) {

			exec.execute(new SequenceRunnable(seqnum));

		}

		exec.shutdown();

	}

}
