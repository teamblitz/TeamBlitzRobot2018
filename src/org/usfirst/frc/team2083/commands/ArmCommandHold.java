package org.usfirst.frc.team2083.commands;

public class ArmCommandHold extends CommandBase
{
	double holdPos;

	public ArmCommandHold(double holdPos)
	{
		super("ArmCommandHold");
		requires(armSubsystem);
		requires(wristSubsystem);
//		holdPos = armSubsystem.armMotor.getSelectedSensorPosition(0);
		this.holdPos = holdPos;
		System.out.println("ArmCommandHold" + holdPos);
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
		System.out.println("Execute: " + holdPos);
		armSubsystem.hold(holdPos);
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
