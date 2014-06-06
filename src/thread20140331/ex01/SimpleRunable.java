package thread20140331.ex01;

public class SimpleRunable implements Runnable {

	@Override
	public void run() {

		System.out.println(Thread.currentThread().getName());

	}

	public static void main(String[] args) {

		for(int i = 0;i<5;i++) {

			new Thread(new SimpleRunable(),"Thread-" + i).start();
		}

	}


}
