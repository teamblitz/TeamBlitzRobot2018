package org.usfirst.frc.team2083.subsytems;

import org.usfirst.frc.team2083.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class GripperSubsystem extends Subsystem
{
	public TalonSRX gripperMotor;

	double motorSpeed = 0.7;

	public GripperSubsystem()
	{
		super("GripperSubsystem");

		gripperMotor = RobotMap.gripperMotor;
	}

	@Override
	protected void initDefaultCommand()
	{
	}

	public void gripperOut()
	{
		gripperMotor.set(ControlMode.PercentOutput, motorSpeed);
	}

	public void gripperIn()
	{
		gripperMotor.set(ControlMode.PercentOutput, -motorSpeed);
	}

	public void gripperStop()
	{
		gripperMotor.set(ControlMode.PercentOutput, 0);
	}
}
