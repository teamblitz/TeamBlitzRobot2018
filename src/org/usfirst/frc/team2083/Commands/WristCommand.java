package org.usfirst.frc.team2083.Commands;

import org.usfirst.frc.team2083.robot.RobotMap;

public class WristCommand extends CommandBase{
	final int POVThreshold = 15;
	final double wristSpeed = 0.25;
	
	public WristCommand() {
		requires(wristSubsystem);
	}
	
	protected void initialize() {
	}
	
	protected void execute() {
		double POV = oi.getMotorWristValue();
		if(POV == 0) {
			wristSubsystem.setVoltage(1);
		}
		else if(POV == 180) {
			wristSubsystem.setVoltage(-1);
		}		
		else {
			wristSubsystem.setVoltage(0);
		}
	}
	
	@Override
	protected boolean isFinished() {

		return false;
	}
	protected void end() {
	}
	
	protected void interrupted() {
		System.out.println("Wrist Interuppted!");
	}
}
