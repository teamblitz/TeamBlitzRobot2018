package org.usfirst.frc.team2083.commands;

public class GripperCommand extends CommandBase
{
	public enum WheelDirection
	{
		OUT,
		IN,
		STOP
	}

	WheelDirection state;

	public GripperCommand(WheelDirection state)
	{
		super("GripperCommand");
		requires(gripperSubsystem);
		this.state = state;
	}

	@Override
	protected void execute()
	{
		switch (state)
		{
			case OUT:
				gripperSubsystem.gripperOut();
				break;
			case IN:
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
	protected void initialize()
	{
		super.initialize();
	}
}
