package org.usfirst.frc.team2083.subsytems;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team2083.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class WristSubsystem extends Subsystem {
	
	public WPI_TalonSRX wristMotor;
	public WPI_TalonSRX wristSlave;
	
	public WristSubsystem() {
		super("Wrist Subsystem");
		
		wristMotor = RobotMap.wristMotor;
		wristSlave = RobotMap.wristSlave;
	}
	
	protected void intDefaultCommand() {
	}
	
	public void enableControl() {
		wristMotor.set(ControlMode.PercentOutput, 0);
		wristSlave.set(ControlMode.PercentOutput, 0);
	}
	
	public void disable() {
		wristMotor.disable();
		wristSlave.disable();
	}
	
	public void setVoltage(double aVoltage) {
		wristMotor.set(ControlMode.PercentOutput, aVoltage);
		wristSlave.follow(wristMotor);
		System.out.println("Voltage Set" + aVoltage);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}
