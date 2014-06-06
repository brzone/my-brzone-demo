package thread;

public class Consumer implements Runnable {
	
	private StoreHouse store;
	
	public Consumer(StoreHouse store) {
		super();
		this.store = store;
	}


	@Override
	public synchronized void run() {
	
		
		while(true) {
		
		
			
			try {
				store.pop();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			notifyAll();
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
			
			
	}

}
