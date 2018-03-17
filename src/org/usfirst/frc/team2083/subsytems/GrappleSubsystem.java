package org.usfirst.frc.team2083.subsytems;

import org.usfirst.frc.team2083.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class GrappleSubsystem extends Subsystem
{
	public double		joystick;
	public double		joystickThreshold;
	public WPI_TalonSRX	winchMotor;
	public boolean		dropModePrep;
	public boolean		dropModeActive;
	public double		winchRelativePosition;

	public GrappleSubsystem()
	{
		super("GrappleSubsystem");
		
		winchMotor = RobotMap.grappleMotor;
		joystick = RobotMap.RightJoystickVertical;
		joystickThreshold = 0.3;
		dropModePrep = false;
		dropModeActive = false;
		winchRelativePosition = 0;
	}

	@Override
	protected void initDefaultCommand()
	{

	}

	public void dropPrep()
	{
		System.out.println("Grapple Drop Prep Prepared");
		dropModePrep = true;
	}

	public void dropActive()
	{
		if (dropModePrep)
		{
			dropModeActive = true;
			System.out.println("Grapple Drop Prep Active");
		}
		else
		{
			System.out.println("Grapple Drop Prep Failed to Activate");
		}
	}

	public void dropExit()
	{
		dropModeActive = false;
		System.out.println("Grapple Drop Prep Exited");
	}

	public void start()
	{
		System.out.println("Grapple Drop Prep Started");
		dropModeActive = false;
		dropModePrep = false;
	}

	public void winchControl(double aVoltage)
	{
		if (dropModeActive && Math.abs(aVoltage) > joystickThreshold)
		{
			winchMotor.set(ControlMode.PercentOutput, aVoltage);
			winchRelativePosition = winchRelativePosition + aVoltage;
			System.out.println("Winch moved to relative position " + winchRelativePosition);
		}
		else
		{
			winchMotor.set(ControlMode.PercentOutput, 0);
			winchMotor.disable();
			if (dropModeActive)
			{
				System.out.println("Grapple Drop Prep Not Active!");
			}
		}
	}
}
