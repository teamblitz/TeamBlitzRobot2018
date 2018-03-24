package org.usfirst.frc.team2083.commands;

public class ArmCommandPos extends CommandBase
{
	double degreePos;

	public ArmCommandPos(double degreePos)
	{
		super("ArmCommandPos");
		requires(armSubsystem);
		requires(wristSubsystem);
		this.degreePos = degreePos;
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
		armSubsystem.moveTo(degreePos);
	}

	@Override
	protected boolean isFinished()
	{
		boolean finished = Math.abs(armSubsystem.armMotor.getSelectedSensorPosition(0) - degreePos * armSubsystem.encoderUnitsPerRev / 360.0f) < 10.0f;
		System.out.print("ArmCommand finished: " + finished);
		return finished;
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
