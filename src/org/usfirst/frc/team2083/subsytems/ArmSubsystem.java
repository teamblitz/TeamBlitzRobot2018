package org.usfirst.frc.team2083.subsytems;

import org.usfirst.frc.team2083.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ArmSubsystem extends Subsystem
{
	public double	motorSpeed;
	public double	stallSpeed;
	TalonSRX	armMotor;

	DigitalInput	top;
	DigitalInput	bottom;

	public ArmSubsystem()
	{
		super("ArmSubsystem");

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
		// if (top.get())
		{
			// armMotor.set(ControlMode.PercentOutput,
			// upwardScaleFactor(armMotor.getSelectedSensorPosition(0), 1440));
			armMotor.set(ControlMode.Position, 180.0 / 360.0 * 1440.0);
			System.out.println("arm up");
			System.out.println("err = " + armMotor.getClosedLoopError(0));
			System.out.println("vol = " + armMotor.getMotorOutputVoltage());
			System.out.println("pos = " + armMotor.getSensorCollection().getQuadraturePosition());
		}
		// else
		// {
		// zeroOut();
		// }
	}

	public void moveDown()
	{
		// armSetter();
		// if (bottom.get())
		{
			armMotor.set(ControlMode.Position, 0.0 / 360.0 * 1440.0);
			System.out.println("arm down");
			System.out.println("err = " + armMotor.getClosedLoopError(0));
			System.out.println("vol = " + armMotor.getMotorOutputVoltage());
			System.out.println("pos = " + armMotor.getSensorCollection().getQuadraturePosition());
		}
		// }
		// else
		// {
		// zeroOut();
		// }
	}

	public void hold()
	{
		// armSetter();
		if (bottom.get())
		{
//			armMotor.set(ControlMode.PercentOutput, stallSpeed);
		}
		else
		{
			zeroOut();
		}
	}

	double downwardScaleFactor(double currentPosition, int totalUnits)
	{
		double topPosition = totalUnits / 2;
		if (currentPosition <= topPosition / 180 * 30)
		{
			return 0.25;
		}
		else if (currentPosition <= topPosition / 180 * 60)
		{
			return 0.25;
		}
		else if (currentPosition <= topPosition / 180 * 90)
		{
			return 0.50;
		}
		else
		{
			return 1.0;
		}
	}

	double upwardScaleFactor(double currentPosition, int totalUnits)
	{
		double topPosition = totalUnits / 2;
		if (currentPosition <= topPosition / 180 * 120)
		{
			return 7.0;
		}
		else if (currentPosition <= topPosition / 180 * 140)
		{
			return 0.6;
		}
		else if (currentPosition <= topPosition / 180 * 170)
		{
			return 0.5;
		}
		else
		{
			return 0.2;
		}
	}

	public void zeroOut()
	{
		// armSetter();
//		armMotor.set(ControlMode.PercentOutput, 0);
	}

	@Override
	protected void initDefaultCommand()
	{
		System.out.println("Arm 'Initiate Default Command'");
	}

	public void enableControl()
	{
//		armMotor.set(ControlMode.PercentOutput, 0);
		System.out.println("Arm Control Enabled");
	}

	public void disableControl()
	{
		System.out.println("Arm Control Disabled");
//		armMotor.disable();
	}
}