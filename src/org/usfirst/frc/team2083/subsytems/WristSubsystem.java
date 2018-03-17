package org.usfirst.frc.team2083.subsytems;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team2083.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class WristSubsystem extends Subsystem {
	
	public WPI_TalonSRX wristMotor;
	
	DigitalInput top;
	DigitalInput bottom;
	
	public WristSubsystem() {
		super("Wrist Subsystem");
		
		top = RobotMap.WristPositionUpper;
	    bottom = RobotMap.WristPositionLower;
		wristMotor = RobotMap.wristMotor;
	}
	
	protected void intDefaultCommand() {
	}
	
	public void enableControl() {
		wristMotor.set(ControlMode.PercentOutput, 0);
	}
	
	public void disable() {
		wristMotor.disable();
	}
	
	public void moveUp() {
    	if(top.get()) {
    		setVoltage(1);
    	}
    	else {
    		setVoltage(0);
    	}
	}
	
	public void moveDown() {
    	if(bottom.get()) {
    		setVoltage(-1);
    	}
    	else {
    		setVoltage(0);
    	}
	}
	
	public void setVoltage(double aVoltage) {
		wristMotor.set(ControlMode.PercentOutput, aVoltage);
		System.out.println("Voltage Set" + aVoltage);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}
