package thread;

/**
 * 生产者
 * 
 * @author jian.li
 * 
 */

public class Producer implements Runnable {

	private StoreHouse store;

	public Producer(StoreHouse store) {
		super();
		this.store = store;
	}

	@Override
	public  void run() {

		
		while(true){
		
	
		

		try {
			store.push();
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		}
		

	}

}
