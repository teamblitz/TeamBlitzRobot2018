package org.usfirst.frc.team2083.commands;

public class WristCommand extends CommandBase
{
	final int		povThreshold	= 15;
	final double	wristSpeed		= 0.25;

	public enum Positions {
		UP,
		DOWN
	}
	
	Positions position;
	
	public WristCommand()
	{
		super("WristCommand");
		requires(wristSubsystem);
	}

	public WristCommand(Positions position)
	{
		super("WristCommand");
		requires(wristSubsystem);
		this.position = position;
	}


	@Override
	protected void initialize()
	{
	}

	@Override
	protected void execute()
	{
		switch (position)
		{
			case UP:
				wristSubsystem.moveUp();
				break;
			case DOWN:
				wristSubsystem.moveDown();
				break;
		}

		//		double POV = Robot.oi.getMotorWristValue();
//		if (POV == 0)
//		{
//			wristSubsystem.moveUp();
//			if (RobotMap.WristPositionUpper.get()) {
//				isFinished();
//			}
//		}
//		else if (POV == 180)
//		{
//			wristSubsystem.moveDown();
//		}
//		else
//		{
//			wristSubsystem.setVoltage(0);
//		}
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
