package comandpattern.command;

import comandpattern.TV;

public class TVOffCommand implements Command {

	private TV tv;

	public TVOffCommand(TV tv) {
		super();
		this.tv = tv;
	}

	@Override
	public void execute() {

		tv.closeTV();

	}

	@Override
	public void undo() {
		
		tv.openTV();
		
	}

}
