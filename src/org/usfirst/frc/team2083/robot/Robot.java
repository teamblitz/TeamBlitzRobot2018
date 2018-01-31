/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2083.robot;

import org.usfirst.frc.team2083.robot.commands.CommandBase;
import org.usfirst.frc.team2083.robot.commands.DriveCommand;
import org.usfirst.frc.team2083.toolkit.OperationalMethods;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	DriveCommand driveCommand;
	@Override
	public void robotInit() {
		CommandBase.init();
        driveCommand = new DriveCommand();
        driveCommand.disableControl();
	}

	/**
	 * This function is run once each time the robot enters autonomous mode.
	 */
	@Override
	public void autonomousInit() {

	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {

	}

	/**
	 * This function is called once each time the robot enters teleoperated mode.
	 */
	@Override
	public void teleopInit() {
		System.out.println("Hello, this is teleopInit");
		driveCommand.enableControl();
		driveCommand.start();
		
	}

	@Override
	public void teleopPeriodic() {
//		RobotMap.frontLeftMotor.set(ControlMode.PercentOutput, .3);
//		RobotMap.frontRightMotor.set(ControlMode.PercentOutput, .3);
//		RobotMap.backLeftMotor.set(ControlMode.PercentOutput, .3);
//		RobotMap.backRightMotor.set(ControlMode.PercentOutput, .3);
		Scheduler.getInstance().run();
	}
	@Override
	public void testPeriodic() {
	}
}
