package comandpattern.command;

import comandpattern.TV;

public class TVOnCommand implements Command {

	private TV tv;

	public TVOnCommand(TV tv) {
		super();
		this.tv = tv;
	}

	@Override
	public void execute() {

		tv.openTV();

	}

	@Override
	public void undo() {
		
		tv.closeTV();
		
	}

}
