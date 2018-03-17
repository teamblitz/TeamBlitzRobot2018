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
			case START:
				grappleSubsystem.dropActive();
				break;
			case BACK:
				grappleSubsystem.dropPrep();
				break;
			case EXIT:
				grappleSubsystem.dropExit();
				break;
			default:
				break;
		}
		grappleSubsystem.winchControl(oi.getMotorGrappleValue());
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
