package org.usfirst.frc.team2083.subsytems;

import org.usfirst.frc.team2083.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ArmSubsystem extends Subsystem
{
	public double	motorSpeed;
	public double	stallSpeed;
	WPI_TalonSRX	armMotor;

	DigitalInput	top;
	DigitalInput	bottom;

	public ArmSubsystem()
	{
		super();
		top = RobotMap.ArmPositionUpper;
		bottom = RobotMap.ArmPositionLower;
		armMotor = RobotMap.armMotor;
		motorSpeed = .7;
		stallSpeed = .2;

		System.out.println("top: " + top);
		System.out.println("bottom:" + bottom);
	}

	// public void armSetter() {
	// top = RobotMap.ArmPositionUpper;
	// bottom = RobotMap.ArmPositionLower;
	// armMotor = RobotMap.armMotor;
	// System.out.println(top);
	// System.out.println("A very very very long string so you can't miss it.");
	// }

	public void moveUp()
	{
		// armSetter();
		if (top.get())
		{
			armMotor.set(ControlMode.PercentOutput, motorSpeed);
		}
		else
		{
			zeroOut();
		}
	}

	public void moveDown()
	{
		// armSetter();
		if (bottom.get())
		{
			armMotor.set(ControlMode.PercentOutput, -motorSpeed);
		}
		else
		{
			zeroOut();
		}
	}

	public void hold()
	{
		// armSetter();
		if (bottom.get())
		{
			armMotor.set(ControlMode.PercentOutput, stallSpeed);
		}
		else
		{
			zeroOut();
		}
	}

	public void zeroOut()
	{
		// armSetter();
		armMotor.set(ControlMode.PercentOutput, 0);
	}

	@Override
	protected void initDefaultCommand()
	{
		System.out.println("Arm 'Initiate Default Command'");
	}

	public void enableControl()
	{
		armMotor.set(ControlMode.PercentOutput, 0);
		System.out.println("Arm Control Enabled");
	}

	public void disableControl()
	{
		System.out.println("Arm Control Disabled");
		armMotor.disable();
	}
}