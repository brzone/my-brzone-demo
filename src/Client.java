import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class Bank {

	private AtomicInteger banlance;

	public Bank(int amount) {

		banlance = new AtomicInteger(amount);
	}

	public void draw(int amount, int delay) {

		if (banlance.get() >= amount) {

			int oldvalue = banlance.get();

			try {
				TimeUnit.SECONDS.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (banlance.compareAndSet(oldvalue, oldvalue - amount)) {

				System.out.println("successful,banlance:" + banlance + "\t"
						+ Thread.currentThread().getName());

			} else {

				System.out.println("fail,banlance:" + banlance);
			}

		} else {

			System.out.println("The balance is not enought!");

		}

	}

}

public class Client implements Runnable {

	private Bank bank;

	private int delay;

	public Client(Bank bank, int delay) {
		super();
		this.bank = bank;
		this.delay = delay;
	}

	@Override
	public void run() {

		bank.draw(100, delay);
	}



	public static void main(String[] args) {

		Bank bank = new Bank(100);
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new Client(bank, 1));
		exec.execute(new Client(bank, 0));

		exec.shutdown();


	}

}
