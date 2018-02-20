package org.usfirst.frc.team2083.Commands;

import org.usfirst.frc.team2083.robot.RobotMap;
import org.usfirst.frc.team2083.subsytems.ArmSubsystem;
import org.usfirst.frc.team2083.Commands.CommandBase;


public class ArmCommand extends CommandBase{
	
	public enum ArmDirection{
		UP,
		DOWN,
		STAY
	}
	
	ArmDirection direction;
	
	public ArmCommand(ArmDirection direction) {
		requires(armSubsystem);
		this.direction = direction;
	}
	
	protected void execute() {
//		super.execute();
		switch (direction) {
			case UP:
				armSubsystem.moveUp(); 
				break;
			case STAY:
				armSubsystem.hold();
			case DOWN:
				armSubsystem.moveDown();
				break;
		}
	}

	protected void end() {
		//Use this
		armSubsystem.zeroOut(); 
		super.end();
	}
		
	public static void enableControl() {
		armSubsystem.enableControl();
	}
	
	public void disableControl() {
		armSubsystem.disableControl();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	protected void initialize() {
	}
}

