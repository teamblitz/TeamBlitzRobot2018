package org.usfirst.frc.team2083.robot;

import org.usfirst.frc.team2083.robot.RobotMap;
import org.usfirst.frc.team2083.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	
	Joystick xbox;

    public OI()
    {
        xbox = RobotMap.xBoxController;
    }
    
    public double getMotorDriveLeftRightValue()
    {
    	return xbox.getX();
    }
    
    public double getMotorDriveForwardBackValue()
    {
    	return -xbox.getY();
    }
   
    public double getMoterDriveScaleFactor()
    {   
    	return xbox.getRawAxis(5);
    }
    
	public static void OI_Method() {
		//ArmCommand.mainArm();
		//DriveCommand.mainDrive(); FIXME
		//GrappleRelease.grappleRelease(); FIXME
	}
}