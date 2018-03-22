package org.usfirst.frc.team2083.commands;

public class WristUpCommand extends CommandBase
{
	public WristUpCommand()
	{
		requires(wristSubsystem);
	}

	protected void execute()
	{
		wristSubsystem.moveUp();
	}
	
	@Override
	protected boolean isFinished()
	{
		// TODO Auto-generated method stub
		return false;
	}
}
