/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2083.robot;

import org.usfirst.frc.team2083.autocommands.DriveStraight;
import org.usfirst.frc.team2083.commands.CommandBase;
import org.usfirst.frc.team2083.commands.DriveCommand;
import org.usfirst.frc.team2083.commands.GrappleCommand;
import org.usfirst.frc.team2083.commands.WristCommand;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/*
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	/*
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	DriveCommand driveCommand;
	WristCommand wristCommand;
	Command autoCommand;
	
	@Override
	public void robotInit() {
		CommandBase.init();
        driveCommand = new DriveCommand();
        driveCommand.disableControl();
        wristCommand = new WristCommand();
	}

	/*
	 * This function is run once each time the robot enters autonomous mode.
	 */
	@Override
	public void autonomousInit() {
		autoCommand = new DriveStraight(10000, .3);
		autoCommand.start();
	}
	
	/*
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	/*
	 * This function is called once each time the robot enters teleoperated mode.
	 */
	@Override
	public void teleopInit() {
		GrappleCommand.grappleSubsystem.start();
		driveCommand.enableControl();
		driveCommand.start();
		wristCommand.start();
		
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
	
	@Override
	public void testPeriodic() {
	}
}
