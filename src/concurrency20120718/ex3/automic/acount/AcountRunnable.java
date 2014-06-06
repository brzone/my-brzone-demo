package concurrency20120718.ex3.automic.acount;

public class AcountRunnable implements Runnable {

	private AutomicAcount acount;


	public AcountRunnable(AutomicAcount acount) {
		super();
		this.acount = acount;
	}

	@Override
	public void run() {

		for(int i = 0;i<10;i++) {

			int value = acount.increment();

			System.out.println(Thread.currentThread().getName() + ":" + value);

		}
	}

}
