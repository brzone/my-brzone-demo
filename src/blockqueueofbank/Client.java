package blockqueueofbank;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Client {

	public static void main(String[] args) throws InterruptedException {
	
		BankAccount bank = new BankAccount("007", 1000);
		
		/**阻塞队列
		 * BlockingQueue：
		 *            take：获取队首元素
		 *            put:添加元素至队尾
		 *            
		 *  由于是阻塞队列，当队列没元素时，take操作会阻塞，
		 *               当队列以满，put操作会阻塞。
		 *  author: brzone
		 */
		
		
		BlockingQueue<BankAccount> queue = new ArrayBlockingQueue<BankAccount>(1);
		queue.add(bank);
		
		System.out.println("start balance: " + bank.getBalance());
		
		Thread adoptThread = new Thread( new AdoptMoney(queue));
		
		Thread depositThread = new Thread(new DepositMoney(queue));
		
		adoptThread.start();
		depositThread.start();
		
		adoptThread.join();
		depositThread.join();
		
	
		System.out.println("end balance: " + queue.take().getBalance());
		
	}

}
