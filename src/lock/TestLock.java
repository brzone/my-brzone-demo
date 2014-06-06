package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {

	private ReentrantLock rlock = new ReentrantLock();

	public void lock1() throws InterruptedException {
	
		try {

		rlock.lock();

			

			while (1 < 2)
				Thread.sleep(4000);

		} finally {

				rlock.unlock();
			
		}

	}

	public void lock2() throws InterruptedException {

		boolean canlock = false;

		try {

			System.out.println("ttt");
			canlock = rlock.tryLock(2, TimeUnit.SECONDS);

			if (!canlock) {

				System.out.println("lock2--canlock : " + canlock);
				return;
			}

		} finally {

			if (canlock) {

				rlock.unlock();
				System.out.println("lock2--unlock. ");
			}

		}

	}

	public static void main(String[] args) throws InterruptedException {

		final TestLock tk = new TestLock();

		
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					
					tk.lock1();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}).start();
		
		

		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					System.out.println("xxx");
					tk.lock2();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}).start();

	}

}
