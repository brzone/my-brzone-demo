package anotherthread;

public class Consumer implements Runnable {
	
	private Store store;

	public Consumer(Store store) {
		this.store = store;
	}



	@Override
	public void run() {
		while(!Thread.interrupted()) {
			
			try {
				store.waitForProduce();
				store.consumer();
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("Consumer has Interrupted!");
			}
		
		}
	}

}
