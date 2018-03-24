package org.usfirst.frc.team2083.commands;

import org.usfirst.frc.team2083.subsytems.ArmSubsystem;
import org.usfirst.frc.team2083.subsytems.DriveSubsystem;
import org.usfirst.frc.team2083.subsytems.GripperSubsystem;
import org.usfirst.frc.team2083.subsytems.WristSubsystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public abstract class CommandBase extends Command
{
	public static DriveSubsystem	driveSubsystem		= new DriveSubsystem();
	public static ArmSubsystem		armSubsystem		= new ArmSubsystem();
	public static WristSubsystem	wristSubsystem		= new WristSubsystem();
	public static GripperSubsystem	gripperSubsystem	= new GripperSubsystem();

	public static void init()
	{
		SmartDashboard.putData(driveSubsystem);
		SmartDashboard.putData(armSubsystem);
		SmartDashboard.putData(wristSubsystem);
		SmartDashboard.putData(gripperSubsystem);
	}

	public CommandBase()
	{
		super();
	}

	public CommandBase(String name)
	{
		super(name);
	}
}