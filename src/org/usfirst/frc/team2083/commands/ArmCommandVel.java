package org.usfirst.frc.team2083.commands;

public class ArmCommandVel extends CommandBase
{
	public enum Direction
	{
		UP, DOWN
	}

	Direction	direction;
	double		speed;

	public ArmCommandVel(Direction direction)
	{
		super("ArmCommandVel");
		requires(armSubsystem);
		requires(wristSubsystem);
		this.direction = direction;
		this.speed = 180;
	}

	@Override
	protected void initialize()
	{
		armSubsystem.reset();
	}

	@Override
	protected void execute()
	{
		wristSubsystem.moveTo(0);

		switch (direction)
		{
			case UP:
				armSubsystem.moveAtSpeed(speed);
				break;
			case DOWN:
				armSubsystem.moveAtSpeed(-speed/3);
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
