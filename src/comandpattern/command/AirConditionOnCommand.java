package comandpattern.command;

import comandpattern.AirCondition;

public class AirConditionOnCommand implements Command{
	
	private AirCondition air;

	public AirConditionOnCommand(AirCondition air) {
		super();
		this.air = air;
	}

	@Override
	public void execute() {
		
		air.open();
		
	}

	@Override
	public void undo() {
		
		air.close();
		
	}
	
	
}
