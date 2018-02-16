package org.usfirst.frc.team2083.autocommands;

import org.usfirst.frc.team2083.Commands.CommandBase;
import org.usfirst.frc.team2083.robot.RobotMap;
import org.usfirst.frc.team2083.subsytems.DriveSubsystem;

public class DriveStraight extends CommandBase{
	long duration;
	long startTime;
	double voltage;
	
    public DriveStraight(long duration, double voltage)
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(driveSubsystem);
    	this.voltage = voltage;
    	this.duration = duration;
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    	startTime = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
    	if(System.currentTimeMillis() - startTime < duration )
    	{
    		driveSubsystem.setRightVoltage(voltage);
    		driveSubsystem.setLeftVoltage(voltage);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return System.currentTimeMillis() - startTime > duration;
    }

    // Called once after isFinished returns true
    protected void end()
    {
    	driveSubsystem.setRightVoltage(0);
		driveSubsystem.setLeftVoltage(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
    }

}
