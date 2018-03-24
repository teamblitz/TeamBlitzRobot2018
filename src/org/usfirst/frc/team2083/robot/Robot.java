/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2083.robot;

import org.usfirst.frc.team2083.autocommands.DriveStraight;
import org.usfirst.frc.team2083.autocommands.DriveStraightWithDelay;
import org.usfirst.frc.team2083.autocommands.TurnLeft;
import org.usfirst.frc.team2083.autocommands.TurnRight;
import org.usfirst.frc.team2083.commands.CommandBase;
import org.usfirst.frc.team2083.commands.DriveCommand;
import org.usfirst.frc.team2083.commands.WristCommandPos;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot
{
	/*
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	DriveCommand	driveCommand;
	WristCommandPos	wristCommand;

	public static OI oi;

	Command autonomousCommand;
	SendableChooser<Command> autoChooser;
	
	boolean zerosSet;
	
	@Override
	public void robotInit()
	{
		oi = new OI();
		CommandBase.init();
		SmartDashboard.putData(Scheduler.getInstance());

		driveCommand = new DriveCommand();
		driveCommand.disableControl();
		wristCommand = new WristCommandPos();
		
		autoChooser = new SendableChooser<Command>();
		autoChooser.addDefault("Drive Straight", new DriveStraight(1000, 0.3));
		autoChooser.addDefault("Turn Left", new TurnLeft(3));
		autoChooser.addDefault("Turn Right", new TurnRight(3));
		SmartDashboard.putData("Autonomous Mode Chooser", autoChooser);		
	}

	/*
	 * This function is run once each time the robot enters autonomous mode.
	 */
	@Override
	public void autonomousInit()
	{
		RobotMap.armMotor.getSensorCollection().setQuadraturePosition(0, 10);
		RobotMap.wristMotor.getSensorCollection().setQuadraturePosition(0, 10);
		RobotMap.frontLeftMotor.getSensorCollection().setQuadraturePosition(0, 10);
		RobotMap.frontRightMotor.getSensorCollection().setQuadraturePosition(0, 10);
		zerosSet = true;
		
		loadGameData();

//		autonomousCommand = autoChooser.getSelected();
		autonomousCommand = new DriveStraightWithDelay(3000, 0.45, 10000);
		autonomousCommand.start();
	}

	/*
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic()
	{
		Scheduler.getInstance().run();
	}

	/*
	 * This function is called once each time the robot enters teleoperated mode.
	 */
	@Override
	public void teleopInit()
	{
		RobotMap.frontLeftMotor.getSensorCollection().setQuadraturePosition(0, 10);
		RobotMap.frontRightMotor.getSensorCollection().setQuadraturePosition(0, 10);
		driveCommand.enableControl();
		driveCommand.start();
//		wristCommand.start();

		if (!zerosSet)
		{
			RobotMap.armMotor.getSensorCollection().setQuadraturePosition(0, 10);
			RobotMap.wristMotor.getSensorCollection().setQuadraturePosition(0, 10);
		}
	}

	@Override
	public void teleopPeriodic()
	{
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic()
	{
	}

	void loadGameData()
	{
		RobotMap.gameData = DriverStation.getInstance().getGameSpecificMessage();
	}
}
