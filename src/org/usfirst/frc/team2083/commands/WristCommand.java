package org.usfirst.frc.team2083.commands;

public class WristCommand extends CommandBase
{
	final int		povThreshold	= 15;
	final double	wristSpeed		= 0.25;

	public WristCommand()
	{
		super("WristCommand");
		requires(wristSubsystem);
	}

	@Override
	protected void initialize()
	{
	}

	@Override
	protected void execute()
	{
		double POV = oi.getMotorWristValue();
		if (POV == 0)
		{
			wristSubsystem.moveUp();
		}
		else if (POV == 180)
		{
			wristSubsystem.moveDown();
		}
		else
		{
			wristSubsystem.setVoltage(0);
		}
	}

	@Override
	protected boolean isFinished()
	{

		return false;
	}

	@Override
	protected void end()
	{
		super.end();
	}

	@Override
	protected void interrupted()
	{
		super.interrupted();
		System.out.println("Wrist Interuppted!");
	}
}
