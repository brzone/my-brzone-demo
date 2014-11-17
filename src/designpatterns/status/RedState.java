package designpatterns.status;

import java.util.concurrent.TimeUnit;

public class RedState implements State {

	@Override
	public void change(Light light) {
		
		System.out.println("现在是红灯，不能通过");
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//红灯变成绿灯
		light.toGreenState(light);

	}

}
