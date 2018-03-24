package org.usfirst.frc.team2083.autocommands;

import org.usfirst.frc.team2083.commands.CommandBase;

public class DriveStraightWithDelay extends CommandBase
{
	long	duration;
	long	delay;
	long	startTime;
	double	voltage;
	double	voltageAccommodater	= .5;	// Because our robot is part of the alt-right (or at least leans to the right)
										// Tests: VA Value | Distance | Avg. Deviation | Trials (Deviation to the Right,
										// Negative is Left)
										// 50% 30' 6"/30'; 1"/~5' 10", 12", -1", -10", 19"

	public DriveStraightWithDelay(long duration, double voltage, long delay)
	{
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(driveSubsystem);
		this.delay = delay;
		this.voltage = voltage;
		this.duration = duration;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize()
	{
		startTime = System.currentTimeMillis();
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute()
	{
		
		long Cur_Time = System.currentTimeMillis();
		if(Cur_Time - startTime < delay)
		{
			driveSubsystem.setRightVoltage(0);
			driveSubsystem.setLeftVoltage(0);
		}
		
		else if ((Cur_Time - startTime < (duration + delay)))
		{
			driveSubsystem.setRightVoltage(voltage);
			driveSubsystem.setLeftVoltage(voltage * voltageAccommodater);
		}
		else {
			driveSubsystem.setRightVoltage(0);
			driveSubsystem.setLeftVoltage(0);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished()
	{
		return System.currentTimeMillis() - startTime > (duration+delay);
	}

	// Called once after isFinished returns true
	@Override
	protected void end()
	{
		driveSubsystem.setRightVoltage(0);
		driveSubsystem.setLeftVoltage(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted()
	{
	}
}
