package org.usfirst.frc.team2083.subsytems;

import org.usfirst.frc.team2083.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSubsystem extends Subsystem
{
	public TalonSRX		leftFront;
	public VictorSPX	leftBack;
	
	double encoderUnitsPerRev;
	
	public TalonSRX		rightFront;
	public VictorSPX	rightBack;

	public DriveSubsystem()
	{
		super("DriveSubsystem");

		leftFront = RobotMap.frontLeftMotor;
		leftBack = RobotMap.backLeftMotor;
		rightFront = RobotMap.frontRightMotor;
		rightBack = RobotMap.backRightMotor;
		
		encoderUnitsPerRev = 250;
	}

	@Override
	protected void initDefaultCommand()
	{
		// Initialize the Drive Subsystem
		System.out.println("Drive System Initialized");
	}

	public void enableControl()
	{
		// Set the all motors in the drive system to 0 to wake them into enabled when
		// called
		System.out.println("Drive System Enabled");

//		rightFront.configNominalOutputForward(0, 0);
//		rightFront.configNominalOutputReverse(0, 0);
//		rightFront.configPeakOutputForward(1, 10);
//		rightFront.configPeakOutputReverse(-1, 10);
//		leftFront.configNominalOutputForward(0, 0);
//		leftFront.configNominalOutputReverse(0, 0);
//		leftFront.configPeakOutputForward(1, 10);
//		leftFront.configPeakOutputReverse(-1, 10);
//		leftBack.set(ControlMode.PercentOutput, 0);
//		leftFront.set(ControlMode.PercentOutput, 0);
//		rightFront.set(ControlMode.PercentOutput, 0);
//		rightBack.set(ControlMode.PercentOutput, 0);
	}

	public void disableControl()
	{
	}

	/*
	 * public void leftVelocity(double aVelocity) { leftBack.follow(leftFront);
	 * double finalVelocity = aVelocity * 500.0 * 4096 / 600;
	 * leftFront.set(ControlMode.Velocity, finalVelocity);
	 * System.out.println("Left: " + leftFront.getMotorOutputVoltage() + ", " +
	 * aVelocity + ", " + finalVelocity); }
	 * 
	 * public void rightVelocity(double aVelocity) { rightBack.follow(rightFront);
	 * rightFront.set(ControlMode.Velocity, aVelocity * 1000);
	 * System.out.println("Right: " + rightFront.getMotorOutputVoltage() + ", " +
	 * aVelocity); }
	 */

	public void setLeftVoltage(double aVoltage) 
	{
		// When called, set the front left motor to -aVoltage and set the back
		// left motor to the same value
		leftBack.follow(leftFront);
		leftFront.set(ControlMode.PercentOutput, -aVoltage);
		//leftBack.follow(leftFront);
		//leftFront.set(ControlMode.Velocity, -aVoltage / 360.0 * encoderUnitsPerRev * 0.1);
	}

//	public void setRightWheelsVelocity(double speed)
//	{
//		double setPt = speed * 4 * 360 / 360.0 * encoderUnitsPerRev * 0.1;
//		
//		rightBack.follow(rightFront);
//		rightFront.set(ControlMode.Velocity, setPt);
//	}
//	
//	public void setLeftWheelsVelocity(double speed)
//	{
//		double setPt = speed * 4 * 360 / 360.0 * encoderUnitsPerRev * 0.1;
//		
//		leftBack.follow(rightFront);
//		leftFront.set(ControlMode.Velocity, setPt);
//	}
	
	public void setRightVoltage(double aVoltage)
	{
		// When called, set the front right motor to aVoltage and set the back
		// right motor to the same value
		rightBack.follow(rightFront);
		rightFront.set(ControlMode.PercentOutput, aVoltage);
	}
}
