package org.usfirst.frc.team2083.subsytems;

import org.usfirst.frc.team2083.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
public class DriveSubsystem extends Subsystem {
	
	public WPI_TalonSRX  leftFront;
	//public WPI_TalonSRX leftBack;
	public WPI_VictorSPX  leftBack;
	public WPI_TalonSRX  rightFront;
	//public WPI_TalonSRX rightBack;
	public WPI_VictorSPX  rightBack;
	
	    public DriveSubsystem() {									//Link generic variable names to the Robot.map, which contains their true ID values
	    	super("Drive Subsystem");
	    	
	    	leftFront = RobotMap.frontLeftMotor;
	    	leftBack = RobotMap.backLeftMotor;
	    	rightFront = RobotMap.frontRightMotor;
	    	rightBack = RobotMap.backRightMotor;
	    }
	    
	    protected void initDefaultCommand(){						//Initialize the Drive Subsystem
			System.out.println("Drive System Initialized");
	    }
	    
	    public void enableControl(){								//Set the all motors in the drive system to 0 to wake them into enabled when called
			System.out.println("Drive System Enabled");

			rightFront.configNominalOutputForward(0, 0);
			rightFront.configNominalOutputReverse(0, 0);
			rightFront.configPeakOutputForward(1, 10);
			rightFront.configPeakOutputReverse(-1, 10); 
			leftFront.configNominalOutputForward(0, 0);
			leftFront.configNominalOutputReverse(0, 0);
			leftFront.configPeakOutputForward(1, 10);
			leftFront.configPeakOutputReverse(-1, 10); 
	    	leftBack.set(ControlMode.PercentOutput, 0);
	    	leftFront.set(ControlMode.PercentOutput, 0);
	    	rightFront.set(ControlMode.PercentOutput, 0);
	    	rightBack.set(ControlMode.PercentOutput, 0);
	    }

	    public void disableControl(){								//Disable all motors in the drive system when called
			System.out.println("Drive System Disabled");
	    	leftBack.disable();
	    	leftFront.disable();
	    	rightFront.disable();
	    	rightBack.disable();
	    }
	    
/*	    public void leftVelocity(double aVelocity) {
	    	leftBack.follow(leftFront);
	    		double finalVelocity = aVelocity  * 500.0 * 4096 / 600;
	    		leftFront.set(ControlMode.Velocity, finalVelocity);
	    		System.out.println("Left: " + leftFront.getMotorOutputVoltage() + ", " + aVelocity + ", " + finalVelocity);
	    }

	    public void rightVelocity(double aVelocity) {
	    	rightBack.follow(rightFront);
	    	rightFront.set(ControlMode.Velocity, aVelocity * 1000);
	    	System.out.println("Right: " + rightFront.getMotorOutputVoltage() + ", " + aVelocity);
	    }
	    */
	    

	    public void setLeftVoltage(double aVoltage)					//When called, set the front left motor to -aVoltage and set the back left motor to the same value
		{
			leftBack.follow(leftFront);
			leftFront.set(ControlMode.PercentOutput, -aVoltage);
			System.out.println("Left Voltage: " );
		}
	    
	    public void setRightVoltage(double aVoltage)				//When called, set the front right motor to aVoltage and set the back right motor to the same value
	    {
			rightBack.follow(rightFront);
			rightFront.set(ControlMode.PercentOutput, aVoltage);
		}
}
