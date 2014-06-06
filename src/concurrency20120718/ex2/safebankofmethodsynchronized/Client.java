package concurrency20120718.ex2.safebankofmethodsynchronized;



public class Client {

	public static void main(String[] args) throws InterruptedException {

          Bank bank = new Bank(1000);


          Thread quThread = new Thread(new QuRunnable(bank, 100));

          Thread cunThread = new Thread(new CunRunnable(bank, 100));

          quThread.start();

          cunThread.start();

          //当前线程要等待quThread执行完才执行
          quThread.join();

          cunThread.join();

          System.out.println(bank);


	}

}
