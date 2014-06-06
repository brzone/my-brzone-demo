package comandpattern.command.client;

import comandpattern.command.Command;
import comandpattern.command.NoCommand;

public class RemoteControl {

	/**
	 * o Light on [0][0] o Light off [0][1] o Air on [1][0] o Air off [1][1] o
	 * tv on [2][0] o tv off [2][1]
	 * 
	 * 
	 */

	private Command[][] command;
	
	private Command undo = new NoCommand();

	public RemoteControl() {

		command = new Command[3][2];

		for (int i = 0; i < command.length; i++) {

			for (int j = 0; j < command[i].length; j++) {

				command[i][j] = new NoCommand();

			}

		}

	}

	public void setCommand(int row, int col, Command c) {

		command[row][col] = c;
		

	}
	
	public void pressOn(int row, int col) {
		
		command[row][col].execute();
		undo = command[row][col];
	}
	
	public void pressOff(int row, int col) {
		
		command[row][col].execute();
		undo = command[row][col];
	}
	
	public void undo() {
		
		undo.undo();
	}
	
	
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		for (int i = 0, j = command.length; i < j; i++) {

			for (int m = 0, n = command[i].length; m < n; m++) {

				sb.append(command[i][m].getClass().getSimpleName() + "\t");

			}

			sb.append("\t");

		}

		return sb.toString();

	}

}
