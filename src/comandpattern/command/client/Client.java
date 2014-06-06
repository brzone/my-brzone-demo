package comandpattern.command.client;

import comandpattern.AirCondition;
import comandpattern.Light;
import comandpattern.TV;
import comandpattern.command.AirConditionOffCommand;
import comandpattern.command.AirConditionOnCommand;
import comandpattern.command.LightOffCommand;
import comandpattern.command.LightOnCommand;
import comandpattern.command.TVOffCommand;
import comandpattern.command.TVOnCommand;

public class Client {

	/**
	 * o Light on          o Light off
	 * o Air on           o Air off 
	 * o tv on            o tv off
	 * 
	 * 
	 */

	public static void main(String[] args) {

		Light light = new Light();
		LightOnCommand lightOn = new LightOnCommand(light);
		LightOffCommand lightOff = new LightOffCommand(light);

		AirCondition air = new AirCondition();
		AirConditionOnCommand airOn = new AirConditionOnCommand(air);
		AirConditionOffCommand airOff = new AirConditionOffCommand(air);

		TV tv = new TV();
		TVOnCommand tvON = new TVOnCommand(tv);
		TVOffCommand tvOff = new TVOffCommand(tv);

		// 设置按钮
		RemoteControl control = new RemoteControl();
		control.setCommand(0, 0, lightOn);
		control.setCommand(0, 1, lightOff);
		control.setCommand(1, 0, airOn);
		control.setCommand(1, 1, airOff);
		control.setCommand(2, 0, tvON);
		control.setCommand(2, 1, tvOff);

		control.pressOff(0, 0);// lightOn
		control.pressOff(1, 1);// airOff
		control.pressOff(2, 1);// tvOff
		
		control.undo();//this should be tvOpen

	}

}
