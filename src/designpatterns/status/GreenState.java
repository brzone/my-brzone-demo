package designpatterns.status;

import java.util.concurrent.TimeUnit;

public class GreenState implements State {

	@Override
	public void change(Light light) {
		
		System.out.println("现在是绿灯，可以通行");
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//绿灯变成黄灯
		light.toYellowState(light);

	}

}
