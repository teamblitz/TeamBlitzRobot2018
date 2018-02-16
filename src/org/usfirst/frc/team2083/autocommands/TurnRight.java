package org.usfirst.frc.team2083.autocommands;

import org.usfirst.frc.team2083.Commands.CommandBase;

public class TurnRight extends CommandBase{

	long duration;
	long startTime;
	
    public TurnRight(long duration)
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(driveSubsystem);
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
    		driveSubsystem.setRightVoltage(-.4);
    		driveSubsystem.setLeftVoltage(.4);
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
