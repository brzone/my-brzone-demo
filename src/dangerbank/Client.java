package dangerbank;

import java.lang.reflect.Proxy;

public class Client {

	
	public static void main(String[] args) throws InterruptedException {
		
		BankAccount bank = new BankAccount(123456,10000);

		/**
		 * 动态代理，代理的类必须要实现某一接口
		 * 也就是说，java JDK实现的动态代理，只能针对接口而代理(其他的CGLB,其中类也可以)
		 * 
		 * 
		 * 
		 */
		
		BankAccountInte proxyBank = (BankAccountInte)Proxy.newProxyInstance(
	    		bank.getClass().getClassLoader(), 
			    bank.getClass().getInterfaces(),
			    new BankInvocationHandle( bank));
		
		Runnable save = new SaveMoney(proxyBank);
		         
		Runnable  take = new TankMoney(proxyBank);

		Thread tsave = new Thread(save);
		
		Thread ttake = new Thread(take);
		
		tsave.start();
		ttake.start();
		
		tsave.join();
		ttake.join();
		
		/*This is should be run if tsave and ttake of thread is over.*/
		System.out.println(proxyBank.getBalance());
		
		
	}

}
