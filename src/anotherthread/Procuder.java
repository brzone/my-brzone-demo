package anotherthread;

public class Procuder implements Runnable {
	
	private Store store;
	
	public Procuder(Store store) {
		
		this.store = store;
	}
	

	@Override
	public void run() {
		
		while(!Thread.interrupted()){
			
			try {
				store.waitForConsumer();
				store.produce();
				} catch (InterruptedException e) {
				System.out.println("Procuder has Interrupted!");
			}
			
			
			
		}

	}

}
