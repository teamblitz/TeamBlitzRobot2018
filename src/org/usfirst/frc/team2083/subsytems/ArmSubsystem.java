package org.usfirst.frc.team2083.subsytems;

import org.usfirst.frc.team2083.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ArmSubsystem extends Subsystem
{
	public TalonSRX armMotor;
	public final double encoderUnitsPerRev = 1440.0;
	
	boolean midPtSet = false;
	double midPt;
	double quarterPt;

	DigitalInput	top;
	DigitalInput	bottom;

	public ArmSubsystem()
	{
		super("ArmSubsystem");

		top = RobotMap.ArmPositionUpper;
		bottom = RobotMap.ArmPositionLower;
		armMotor = RobotMap.armMotor;
	}

	public void moveTo(double degreesPos)
	{
		double setPt = degreesPos / 360.0 * encoderUnitsPerRev;
		double currentPos = armMotor.getSensorCollection().getQuadraturePosition();
		if (!midPtSet)
		{
			midPt = (setPt - currentPos)/2.0 + currentPos;
			quarterPt = (setPt - currentPos)/4.0 + currentPos;
			midPtSet = true;
		}
		else if (currentPos >= quarterPt)
		{
			midPtSet = false;
		}
		
		if (Math.abs(setPt - midPt) < 10.0)
		{
			midPt = setPt;
		}
		
		armMotor.set(ControlMode.Position, midPt);
		System.out.println("arm position");
		System.out.println("set = " + setPt);
		System.out.println("err = " + armMotor.getClosedLoopError(0));
		System.out.println("vol = " + armMotor.getMotorOutputVoltage());
		System.out.println("pos = " + armMotor.getSensorCollection().getQuadraturePosition());
	}
	
	public void moveAtSpeed(double speed)
	{
		double setPt = speed / 360.0 * encoderUnitsPerRev * 0.1;
		
		armMotor.set(ControlMode.Velocity, setPt);
		System.out.println("arm velocity");
		System.out.println("set = " + setPt);
		System.out.println("err = " + armMotor.getClosedLoopError(0));
		System.out.println("vol = " + armMotor.getMotorOutputVoltage());
		System.out.println("pos = " + armMotor.getSensorCollection().getQuadraturePosition());
	}
	public void hold(double setPt)
	{
		armMotor.set(ControlMode.Position, setPt);
		System.out.println("arm hold");
		System.out.println("set = " + setPt);
		System.out.println("err = " + armMotor.getClosedLoopError(0));
		System.out.println("vol = " + armMotor.getMotorOutputVoltage());
		System.out.println("pos = " + armMotor.getSensorCollection().getQuadraturePosition());
	}
	public void reset() {
		midPtSet = false;
		midPt = 0.0;
	}
	
	@Override
	protected void initDefaultCommand()
	{
	}

	public void enableControl()
	{
	}

	public void disableControl()
	{
	}
}