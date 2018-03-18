package org.usfirst.frc.team2083.commands.groups;

import org.usfirst.frc.team2083.commands.ArmCommand;
import org.usfirst.frc.team2083.commands.GripperCommand;
import org.usfirst.frc.team2083.commands.WristCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PowerCubeCatch extends CommandGroup
{
	public PowerCubeCatch()
	{
		addSequential(new GripperCommand(GripperCommand.Action.CLOSE), 1500); // call stop or fix code
		addSequential(new WristCommand(WristCommand.Positions.UP));
		addSequential(new ArmCommand(ArmCommand.ArmDirection.DOWN));
		addSequential(new WristCommand(WristCommand.Positions.DOWN));
		addSequential(new GripperCommand(GripperCommand.Action.OPEN), 1500);  // call stop or fix code

	}
}
