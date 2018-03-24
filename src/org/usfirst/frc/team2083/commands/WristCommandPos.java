package org.usfirst.frc.team2083.commands;

public class WristCommandPos extends CommandBase
{
	double degreePos;
	
	public WristCommandPos()
	{
		super("WristCommand");
		requires(wristSubsystem);
	}

	public WristCommandPos(double degreePos)
	{
		super("WristCommandPos");
		requires(wristSubsystem);
		this.degreePos = degreePos;
	}


	@Override
	protected void initialize()
	{
	}

	@Override
	protected void execute()
	{
		wristSubsystem.moveTo(degreePos);
	}

	@Override
	protected boolean isFinished()
	{
		boolean finished = Math.abs(wristSubsystem.wristMotor.getSelectedSensorPosition(0) - degreePos * wristSubsystem.encoderUnitsPerRev / 360.0f) < 10.0f;
		System.out.print("WristCommand finished: " + finished);
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
}
