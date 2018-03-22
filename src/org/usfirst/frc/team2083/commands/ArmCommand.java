package org.usfirst.frc.team2083.commands;

import org.usfirst.frc.team2083.robot.RobotMap;

public class ArmCommand extends CommandBase
{
	public enum ArmDirection
	{
		UP, DOWN, STAY
	}

	ArmDirection direction;

	public ArmCommand(ArmDirection direction)
	{
		super("ArmCommand");
		requires(armSubsystem);
//		requires(wristSubsystem);
		this.direction = direction;
	}

	@Override
	protected void initialize()
	{
	}

	@Override
	protected void execute()
	{
		// super.execute();
		switch (direction)
		{
			case UP:
				armSubsystem.moveUp();
				if (!RobotMap.ArmPositionUpper.get())
				{
//					isFinished();
				}
				break;
			case STAY:
				armSubsystem.hold();
			case DOWN:
				armSubsystem.moveDown();
				if (!RobotMap.ArmPositionLower.get())
				{
//					isFinished();
				}
				break;
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
		armSubsystem.zeroOut();
		super.end();
	}

	@Override
	protected void interrupted()
	{
		super.interrupted();
	}

	public static void enableControl()
	{
		armSubsystem.enableControl();
	}

	public void disableControl()
	{
		armSubsystem.disableControl();
	}
}
