package org.usfirst.frc.team2083.subsytems;
import org.usfirst.frc.team2083.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;


public class GripperSubsystem extends Subsystem {
	
	double motorSpeed = 0.5;
	
	public WPI_TalonSRX gripperMotor;
	
	public GripperSubsystem() {
		super("Gripper Subsystem");
		
		gripperMotor = RobotMap.gripperMotor;
	}
	
	protected void initDefaultCommand() {
	}
	
	public void gripperOut() {
		gripperMotor.set(ControlMode.PercentOutput, motorSpeed);
	}
	
	public void gripperIn() {
		gripperMotor.set(ControlMode.PercentOutput, -motorSpeed);
	}
	public void gripperStop() {
		gripperMotor.set(ControlMode.PercentOutput, 0);
	}
}
