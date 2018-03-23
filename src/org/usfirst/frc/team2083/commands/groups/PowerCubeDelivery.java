package org.usfirst.frc.team2083.commands.groups;

import org.usfirst.frc.team2083.commands.ArmCommand;
import org.usfirst.frc.team2083.commands.GripperCommand;
import org.usfirst.frc.team2083.commands.WristCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PowerCubeDelivery extends CommandGroup
{

	public PowerCubeDelivery(double wristDegreePos)
	{
		addParallel(new GripperCommand(GripperCommand.Action.CLOSE), 1500);  // call stop or fix code
		addSequential(new ArmCommand(180.0)); 
		addSequential(new WristCommand(wristDegreePos));
	}
	
}
