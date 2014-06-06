package joindemo;

public class JoinDemo implements Runnable {

	public static int index = 1;

	public final int id;

	public JoinDemo() {
		this.id = index++;

	}

	@Override
	public void run() {

		for (int i = 0; i < 50; i++)
			System.out.println("【" + id + "】" + "(" + i + ")");

	}

	public static void main(String[] args) throws InterruptedException {

		JoinDemo join1 = new JoinDemo();
		JoinDemo join2 = new JoinDemo();
		JoinDemo join3 = new JoinDemo();
		JoinDemo join4 = new JoinDemo();

		Thread t1 = new Thread(join1);
		Thread t2 = new Thread(join2);
		Thread t3 = new Thread(join3);
		Thread t4 = new Thread(join4);

		t2.start();
		t3.start();
		t4.start();
		
		

		t2.join();
		t3.join();
		t4.join();
		
		/**
		 * 是哪个线程在调用join，很明显嘛，main线程呗，join之后的代码
		 * 是要等待join的那些线程执行完才能执行.
		 *  实际上在这里，下面的代码都属于main中的.
		 * 
		 */
		
		
		t1.start();
		for(int i = 0;i<100;i++) {
			
			System.out.println("main: " + i);
			
		}
		
		

	}

}
