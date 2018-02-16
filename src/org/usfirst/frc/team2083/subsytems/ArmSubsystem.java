package org.usfirst.frc.team2083.subsytems;

import org.usfirst.frc.team2083.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ArmSubsystem extends Subsystem{
	public double motorSpeed;
	WPI_TalonSRX armMotor;
	WPI_VictorSPX armSlave;
	
	DigitalInput top;
	DigitalInput bottom;
	
	
	 public ArmSubsystem() {
		 super();
	    top = RobotMap.ArmPositionUpper;
	    bottom = RobotMap.ArmPositionLower;
	 	armMotor = RobotMap.armMotor;
	 	armSlave = RobotMap.armSlave;
	 	motorSpeed = 0.10;
	 	
	 	System.out.println("top: " + top);
	 	System.out.println("bottom:" + bottom);
	    }
//	    
//	 public void armSetter() {
//	    top = RobotMap.ArmPositionUpper;
//	    bottom = RobotMap.ArmPositionLower;
//	 	armMotor = RobotMap.armMotor;
//	 	System.out.println(top);
//	 	System.out.println("A very very very long string so you can't miss it.");
//	    }

	  	
	    public void moveUp()
		{
//	    	armSetter();
	    	if(top.get()) {
	    		System.out.println(top.get() + ", moveUp");
	    		armSlave.follow(armMotor);
	    		armMotor.set(ControlMode.PercentOutput, motorSpeed);
	    	}
	    	else {
	    		zeroOut();
	    	}
		}
	    public void moveDown() 
	    {
//	    	armSetter();
	    	if(bottom.get()) {
	    		System.out.println(bottom.get() + ", moveDown");
	    		armSlave.follow(armMotor);
	    		armMotor.set(ControlMode.PercentOutput, -motorSpeed);
	    	}
	    	else {
	    		zeroOut();
	    	}
	    }
	    public void zeroOut() 
	    {
//	    	armSetter();
	    		armSlave.set(ControlMode.PercentOutput, 0);
	    		armMotor.set(ControlMode.PercentOutput, 0);
	    }
	    
	    
	    
	    protected void initDefaultCommand()
	    {
	    	System.out.println("Arm 'Initiate Default Command'");
	    }
	    
	    public void enableControl()
	    {
	    	armMotor.set(ControlMode.PercentOutput, 0);
	    	System.out.println("Arm Control Enabled");
	    }

	    public void disableControl()
	    {
	    	System.out.println("Arm Control Disabled");
	    	armMotor.disable();

	    }
}