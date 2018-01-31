package org.usfirst.frc.team2083.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team2083.robot.OI;
import org.usfirst.frc.team2083.subsytems.*;

public abstract class CommandBase extends Command {
	
	public static DriveSubsystem driveSubsystem = new DriveSubsystem();
	
	public static OI oi;
	
	public static void init() {
		oi = new OI();
	}
	
	public CommandBase(String name) {
		super(name);
	}
	
	public CommandBase() {
		super();
	}
}
