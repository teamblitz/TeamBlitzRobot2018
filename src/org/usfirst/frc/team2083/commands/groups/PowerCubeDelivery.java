package org.usfirst.frc.team2083.commands.groups;

import org.usfirst.frc.team2083.commands.ArmCommandPos;
import org.usfirst.frc.team2083.commands.GripperCommand;
import org.usfirst.frc.team2083.commands.WristCommandPos;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PowerCubeDelivery extends CommandGroup
{

	public PowerCubeDelivery(double wristDegreePos)
	{
		addParallel(new GripperCommand(GripperCommand.Action.CLOSE), 1500);  // call stop or fix code
		addSequential(new ArmCommandPos(180.0)); 
		addSequential(new WristCommandPos(wristDegreePos));
	}
	
}
