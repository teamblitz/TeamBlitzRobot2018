package org.usfirst.frc.team2083.subsytems;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team2083.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


public class GripperSubsystem extends Subsystem{
	double motorSpeed = 0.5;
	
	public WPI_TalonSRX gripperMotor;
	public WPI_VictorSPX gripperSlave;
	
	public GripperSubsystem() {
		super("Gripper Subsystem");
		
		gripperMotor = RobotMap.gripperMotor;
		gripperSlave = RobotMap.gripperSlave;
	}
	
	protected void initDefaultCommand() {
	}
	
	public void gripperOut() {
		gripperSlave.set(ControlMode.PercentOutput, -motorSpeed);
		gripperMotor.set(ControlMode.PercentOutput, motorSpeed);
	}
	
	public void gripperIn() {
		gripperSlave.set(ControlMode.PercentOutput, motorSpeed);
		gripperMotor.set(ControlMode.PercentOutput, -motorSpeed);
	}
	public void gripperStop() {
		gripperSlave.set(ControlMode.PercentOutput, 0);
		gripperMotor.set(ControlMode.PercentOutput, 0);
	}
}
