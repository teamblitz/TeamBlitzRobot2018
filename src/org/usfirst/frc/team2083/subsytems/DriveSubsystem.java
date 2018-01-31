package org.usfirst.frc.team2083.subsytems;

import org.usfirst.frc.team2083.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
//import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
public class DriveSubsystem extends Subsystem {
		
	public WPI_TalonSRX  leftFront;
	public WPI_TalonSRX leftBack;
	//public WPI_VictorSPX  leftBack;
	public WPI_TalonSRX  rightFront;
	public WPI_TalonSRX rightBack;
	//public WPI_VictorSPX  rightBack;

	
	    public DriveSubsystem() {
	    	super("Drive Subsystem");
	    	
	    	leftFront = RobotMap.frontLeftMotor;
	    	leftBack = RobotMap.backLeftMotor;
	    	rightFront = RobotMap.frontRightMotor;
	    	rightBack = RobotMap.backRightMotor;
	    }
	    
	    protected void initDefaultCommand(){
	    }
	    
	    public void enableControl(){
	    	leftBack.set(ControlMode.PercentOutput, 0);
	    	leftFront.set(ControlMode.PercentOutput, 0);
	    	rightFront.set(ControlMode.PercentOutput, 0);
	    	rightBack.set(ControlMode.PercentOutput, 0);
	    }

	    public void disableControl(){
	    	leftBack.disable();
	    	leftFront.disable();
	    	rightFront.disable();
	    	rightBack.disable();
	    }
	    
	    public void setLeftVoltage(double aVoltage)
		{
//	    	if(aVoltage > 1)
//	    	{
//	    		aVoltage = 1;
//	    	}
//	    	else if(aVoltage < -1)
//	    	{
//	    		aVoltage = -1;
//	    	}
	    	
			leftBack.set(ControlMode.PercentOutput, -aVoltage);
			leftFront.set(ControlMode.PercentOutput, -aVoltage);
		}
	    
	    public void setRightVoltage(double aVoltage)
		{
//	    	if(aVoltage > 1)
//	    	{
//	    		aVoltage = 1;
//	    	}
//	    	else if(aVoltage < -1)
//	    	{
//	    		aVoltage = -1;
//	    	}
			rightBack.set(ControlMode.PercentOutput, aVoltage);
			rightFront.set(ControlMode.PercentOutput, aVoltage);
		}
}
