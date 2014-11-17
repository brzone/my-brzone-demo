package designpatterns.status;

import java.util.concurrent.TimeUnit;

public class YellowState implements State {

	@Override
	public void change(Light light) {
		
		System.out.println("现在是黄灯，警示，等一等");
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//黄灯变成红灯
		light.toRedState(light);
		

	}

}
