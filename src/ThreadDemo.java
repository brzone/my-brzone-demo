
public class ThreadDemo {

	public static void main(String[] args) {

		new Thread(){

			@Override
			public void run() {
				System.out.println("abcd");
			}}.start();

	}

}
