package org.usfirst.frc.team2083.commands.groups;

import org.usfirst.frc.team2083.commands.GripperCommand;
import org.usfirst.frc.team2083.commands.WristCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PowerCubeCarry extends CommandGroup
{
	public PowerCubeCarry()
	{
		addSequential(new GripperCommand(GripperCommand.Action.CLOSE), 1500); // call stop or fix code
		addSequential(new WristCommand(0.0));
	}
}
