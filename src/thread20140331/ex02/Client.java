package thread20140331.ex02;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

	public static void main(String[] args) {

		//ExecutorService es =  Executors.newFixedThreadPool(2);

		ExecutorService es =  Executors.newCachedThreadPool();

		for(int i = 0;i<40;i++) {

			es.execute(new SimpleRunable("" + i));

		}
		//不接收新任务，当任务都执行ok，顺序关闭
		es.shutdown();
	}

}
