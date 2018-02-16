package org.usfirst.frc.team2083.robot;

import org.usfirst.frc.team2083.Commands.*;
import org.usfirst.frc.team2083.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	
	Joystick xbox = RobotMap.xBoxController;
	Button ButtonY =  RobotMap.ButtonY;
	Button ButtonA =  RobotMap.ButtonA;
	Button ButtonStart =  RobotMap.Start;
	Button ButtonBack =  RobotMap.Back;
	Button RBumper = RobotMap.RBumper;
	Button LBumper = RobotMap.LBumper;
	Button ButtonB = RobotMap.ButtonB;
	
	
	
	
    public OI(){
       ButtonA.whileHeld(new ArmCommand(ArmCommand.ArmDirection.DOWN));
       ButtonY.whileHeld(new ArmCommand(ArmCommand.ArmDirection.UP));
       ButtonStart.whenPressed(new GrappleCommand(GrappleCommand.Options.START));
       ButtonBack.whenPressed(new GrappleCommand(GrappleCommand.Options.BACK));
       ButtonB.whenPressed(new GrappleCommand(GrappleCommand.Options.EXIT));
       RBumper.whenPressed(new GripperCommand(GripperCommand.WheelDirection.OUT));
       LBumper.whenPressed(new GripperCommand(GripperCommand.WheelDirection.IN));
       RBumper.whenReleased(new GripperCommand(GripperCommand.WheelDirection.STOP));
       LBumper.whenReleased(new GripperCommand(GripperCommand.WheelDirection.STOP));
    }
    
    public double getMotorDriveLeftRightValue(){					//Gets horizontal left joystick value (how far it is pushed left or right)
    	return xbox.getX();
    }
    
    public double getMotorDriveForwardBackValue(){					//Gets vertical left joystick value (how far it is pushed up or down)
    	return -xbox.getY();
    }
   
    public double getMotorWristValue() {							//Get D-Pad value (how far it is pushed left or right)
    	return xbox.getPOV();
    }
    
    public double getMotorGrappleValue() {							//Gets vertical left joystick value (how far it is pushed up or down)
    	return xbox.getRawAxis(5);
    }
    
    public double getMoterDriveScaleFactor()
    {   
    	return xbox.getRawAxis(5);
    }
	public static void OI_Method() {
	}
}