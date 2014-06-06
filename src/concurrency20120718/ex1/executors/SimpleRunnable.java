package concurrency20120718.ex1.executors;

/**
 *
 * @author li jian
 *
 * @date 2012-7-19 上午10:20:53
 */
public class SimpleRunnable implements Runnable  {

	private String runableName;

	public SimpleRunnable(String runableName) {
		this.runableName = runableName;
	}

	@Override
	public void run() {

		for(int i = 0;i<5;i++) {

			System.out.println(Thread.currentThread().getName() + ":\t" +runableName + "\t" + i);

		}


	}

}
