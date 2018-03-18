package org.usfirst.frc.team2083.commands;

public class GripperCommand extends CommandBase
{
	public enum Action
	{
		OPEN,
		CLOSE,
		STOP
	}

	Action state;

	public GripperCommand(Action state)
	{
		super("GripperCommand");
		requires(gripperSubsystem);
		this.state = state;
	}

	@Override
	protected void initialize()
	{
		super.initialize();
	}

	@Override
	protected void execute()
	{
		switch (state)
		{
			case OPEN:
				gripperSubsystem.gripperOut();
				break;
			case CLOSE:
				gripperSubsystem.gripperIn();
				break;
			case STOP:
				gripperSubsystem.gripperStop();
				break;
			default:
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
