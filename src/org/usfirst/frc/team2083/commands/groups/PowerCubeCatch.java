package org.usfirst.frc.team2083.commands.groups;

import org.usfirst.frc.team2083.commands.ArmCommandPos;
import org.usfirst.frc.team2083.commands.GripperCommand;
import org.usfirst.frc.team2083.commands.WristCommandPos;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PowerCubeCatch extends CommandGroup
{
	public PowerCubeCatch()
	{
		addSequential(new GripperCommand(GripperCommand.Action.CLOSE), 1500); // call stop or fix code
		addSequential(new WristCommandPos(0.0));
		addSequential(new ArmCommandPos(0.0));
		addSequential(new WristCommandPos(0.0));
		addSequential(new GripperCommand(GripperCommand.Action.OPEN), 1500);  // call stop or fix code

	}
}
