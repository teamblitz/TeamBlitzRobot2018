package org.usfirst.frc.team2083.commands;

public class WristCommandVel extends CommandBase
{
	public enum Direction
	{
		UP, DOWN
	}

	Direction	direction;
	double		speed;
	
	public WristCommandVel(Direction direction)
	{
		super("WristCommandVel");
		requires(wristSubsystem);
		this.direction = direction;
		this.speed = 180;
	}

	@Override
	protected void initialize()
	{
	}

	@Override
	protected void execute()
	{
		switch (direction)
		{
			case UP:
				wristSubsystem.moveAtSpeed(speed);
				break;
			case DOWN:
				wristSubsystem.moveAtSpeed(-speed);
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
}
