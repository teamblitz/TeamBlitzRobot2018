package org.usfirst.frc.team2083.commands;

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
				break;
			case STAY:
				armSubsystem.hold();
			case DOWN:
				armSubsystem.moveDown();
				break;
		}
	}

	@Override
	protected void end()
	{
		armSubsystem.zeroOut();
		super.end();
	}

	public static void enableControl()
	{
		armSubsystem.enableControl();
	}

	public void disableControl()
	{
		armSubsystem.disableControl();
	}

	@Override
	protected boolean isFinished()
	{
		return false;
	}
}
