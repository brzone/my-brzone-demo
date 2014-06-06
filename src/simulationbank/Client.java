package simulationbank;


public class Client {
	
	public static void main(String[] args) throws InterruptedException {
		
		BankAccount bank = new BankAccount("123456789", 1000);
		
		Thread adoptThread = new Thread(new AdoptMoney(bank));
		Thread depositThread = new Thread(new DepositMoney(bank));
		
		long start = System.currentTimeMillis();
		
		adoptThread.start();
		depositThread.start();
		
		adoptThread.join();
		depositThread.join();
		
		System.out.println("balance:" + bank.getBalance());
		System.out.println("time:" + (System.currentTimeMillis()- start));
		
	}
	
}
