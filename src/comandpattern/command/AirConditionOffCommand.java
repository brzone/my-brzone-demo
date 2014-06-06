package comandpattern.command;

import comandpattern.AirCondition;

public class AirConditionOffCommand implements Command{
	
	private AirCondition air;

	public AirConditionOffCommand(AirCondition air) {
		super();
		this.air = air;
	}

	@Override
	public void execute() {
		
		air.close();
		
	}

	@Override
	public void undo() {
		
		air.open();
		
	}
	
	
}
