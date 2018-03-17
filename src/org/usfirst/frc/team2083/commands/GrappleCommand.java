package org.usfirst.frc.team2083.commands;

import org.usfirst.frc.team2083.robot.RobotMap;

public class GrappleCommand extends CommandBase
{
	public enum Options
	{
		START,
		BACK,
		EXIT
	}

	Options state;
	public double joystick;

	public GrappleCommand()
	{
		super("GrappleCommand");
		requires(grappleSubsystem);
		joystick = RobotMap.RightJoystickVertical;
	}

	public GrappleCommand(Options state)
	{
		super("GrappleCommand");
		requires(grappleSubsystem);
		this.state = state;
	}

	protected void execute()
	{
		switch (state)
		{
			case START:
				grappleSubsystem.DropActive();
				break;
			case BACK:
				grappleSubsystem.DropPrep();
				break;
			case EXIT:
				grappleSubsystem.DropExit();
				break;
			default:
				break;
		}
		grappleSubsystem.WinchControl(oi.getMotorGrappleValue());
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
