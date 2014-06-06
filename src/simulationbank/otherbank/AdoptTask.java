package simulationbank.otherbank;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AdoptTask implements Runnable{
	
	private Acount acount;
	private int delay;
	
	public AdoptTask(Acount acount,int delay) {
		
		this.acount = acount;
		this.delay = delay;
	}

	@Override
	public void run() {
		
		acount.adopt(100, delay);
		
	}
	
	public static void main(String[] args) {
		
		ExecutorService exec = Executors.newFixedThreadPool(2);
		
		Acount acount = new Acount(100);
		
		exec.execute(new AdoptTask(acount,1000));
		exec.execute(new AdoptTask(acount,0));
		
		exec.shutdown();
	}
	
	

}
