package thread20140331.ex01;

public class SimpleThread extends Thread {

	public SimpleThread(String name) {

		super(name);
	}

	@Override
	public void run() {

		System.out.println(this.getName() + "\t" + this.getPriority());

	}

	public static void main(String[] args) {

		for(int i = 0;i<5;i++) {

			new SimpleThread("Thread-" + i).start();

		}

	}

}
