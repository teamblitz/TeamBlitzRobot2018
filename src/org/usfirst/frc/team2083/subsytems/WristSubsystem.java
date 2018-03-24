package org.usfirst.frc.team2083.subsytems;

import org.usfirst.frc.team2083.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class WristSubsystem extends Subsystem
{
	public TalonSRX wristMotor;
	public final double encoderUnitsPerRev = 4174.8;

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
	}

	public void disable()
	{
	}

	public void moveTo(double degreesPos)
	{
		double setPt = degreesPos / 360.0 * encoderUnitsPerRev;
		wristMotor.set(ControlMode.Position, setPt);
		System.out.println("wrist up");
		System.out.println("set = " + setPt);
		System.out.println("err = " + wristMotor.getClosedLoopError(0));
		System.out.println("vol = " + wristMotor.getMotorOutputVoltage());
		System.out.println("pos = " + wristMotor.getSensorCollection().getQuadraturePosition());
	}

	public void moveAtSpeed(double speed)
	{
		double setPt = speed / 360.0 * encoderUnitsPerRev * 0.1;
		
		wristMotor.set(ControlMode.Velocity, setPt);
		System.out.println("wrist velocity");
		System.out.println("set = " + setPt);
		System.out.println("err = " + wristMotor.getClosedLoopError(0));
		System.out.println("vol = " + wristMotor.getMotorOutputVoltage());
		System.out.println("pos = " + wristMotor.getSensorCollection().getQuadraturePosition());
	}

	@Override
	protected void initDefaultCommand()
	{
	}
}
