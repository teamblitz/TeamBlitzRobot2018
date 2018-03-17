package org.usfirst.frc.team2083.commands;

import org.usfirst.frc.team2083.robot.OI;
import org.usfirst.frc.team2083.subsytems.ArmSubsystem;
import org.usfirst.frc.team2083.subsytems.DriveSubsystem;
import org.usfirst.frc.team2083.subsytems.GrappleSubsystem;
import org.usfirst.frc.team2083.subsytems.GripperSubsystem;
import org.usfirst.frc.team2083.subsytems.WristSubsystem;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {

	public static DriveSubsystem driveSubsystem = new DriveSubsystem();
    public static ArmSubsystem armSubsystem = new ArmSubsystem();
    public static GrappleSubsystem grappleSubsystem = new GrappleSubsystem();
    public static GripperSubsystem gripperSubsystem = new GripperSubsystem();
    public static WristSubsystem wristSubsystem = new WristSubsystem();
    
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