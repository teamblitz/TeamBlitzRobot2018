package org.usfirst.frc.team2083.autocommands;

import org.usfirst.frc.team2083.commands.CommandBase;

public class DriveStraight extends CommandBase
{
	long	duration;
	long	startTime;
	double	voltage;
	double	voltageAccommodater	= .5;	// Because our robot is part of the alt-right (or at least leans to the right)
										// Tests: VA Value | Distance | Avg. Deviation | Trials (Deviation to the Right,
										// Negative is Left)
										// 50% 30' 6"/30'; 1"/~5' 10", 12", -1", -10", 19"

	public DriveStraight(long duration, double voltage)
	{
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(driveSubsystem);
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
		if (System.currentTimeMillis() - startTime < duration)
		{
			driveSubsystem.setRightVoltage(voltage);
			driveSubsystem.setLeftVoltage(voltage * voltageAccommodater);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished()
	{
		System.out.println("is finished");
		return System.currentTimeMillis() - startTime > duration;
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
