package org.usfirst.frc.team2083.subsytems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team2083.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class WristSubsystem extends Subsystem
{
	public WPI_TalonSRX wristMotor;

	DigitalInput	top;
	DigitalInput	bottom;

	public WristSubsystem()
	{
		super("WristSubsystem");

		top = RobotMap.WristPositionUpper;
		bottom = RobotMap.WristPositionLower;
		wristMotor = RobotMap.wristMotor;
	}

	protected void intDefaultCommand()
	{
	}

	public void enableControl()
	{
//		wristMotor.set(ControlMode.PercentOutput, 0);
	}

	public void disable()
	{
		wristMotor.disable();
	}

	public void moveUp()
	{
		System.out.println(top.get());
//		if (top.get())
		{
			double setPt = 0.0 / 360.0 * 4174.8;
			wristMotor.set(ControlMode.Position, setPt);
			System.out.println("wrist up");
			System.out.println("set = " + setPt);
			System.out.println("err = " + wristMotor.getClosedLoopError(0));
			System.out.println("vol = " + wristMotor.getMotorOutputVoltage());
			System.out.println("pos = " + wristMotor.getSensorCollection().getQuadraturePosition());
//			setVoltage(1);
		}
//		else
//		{
//			setVoltage(0);
//		}
	}

	public void moveDown()
	{
//		if (bottom.get())
		{
			double setPt = 180.0 / 360.0 * 4174.8;
			wristMotor.set(ControlMode.Position, setPt);
			System.out.println("wrist down");
			System.out.println("set = " + setPt);
			System.out.println("err = " + wristMotor.getClosedLoopError(0));
			System.out.println("vol = " + wristMotor.getMotorOutputVoltage());
			System.out.println("pos = " + wristMotor.getSensorCollection().getQuadraturePosition());
//			setVoltage(-1);
		}
//		else
//		{
//			setVoltage(0);
//		}
	}

	public void setVoltage(double aVoltage)
	{
//		wristMotor.set(ControlMode.PercentOutput, aVoltage);
	}

	@Override
	protected void initDefaultCommand()
	{
		// TODO Auto-generated method stub
	}
}
