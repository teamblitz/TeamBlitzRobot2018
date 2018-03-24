package org.usfirst.frc.team2083.robot;

import org.usfirst.frc.team2083.commands.ArmCommandHold;
import org.usfirst.frc.team2083.commands.ArmCommandVel;
import org.usfirst.frc.team2083.commands.GripperCommand;
import org.usfirst.frc.team2083.commands.WristCommandPos;
import org.usfirst.frc.team2083.commands.WristCommandVel;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

public class OI
{
	public Joystick	xbox		= RobotMap.xBoxController;
	Button			ButtonY		= RobotMap.ButtonY;
	Button			ButtonA		= RobotMap.ButtonA;
	Button			ButtonStart	= RobotMap.Start;
	Button			ButtonBack	= RobotMap.Back;
	Button			RBumper		= RobotMap.RBumper;
	Button			LBumper		= RobotMap.LBumper;
	Button			ButtonB		= RobotMap.ButtonB;
	Button			ButtonX		= RobotMap.ButtonX;

	public OI()
	{
		ButtonA.whileHeld(new ArmCommandVel(ArmCommandVel.Direction.DOWN));
		ButtonA.whenReleased(new ArmCommandHold(RobotMap.armMotor.getSensorCollection().getQuadraturePosition()));
		ButtonY.whileHeld(new ArmCommandVel(ArmCommandVel.Direction.UP));
		ButtonY.whenReleased(new ArmCommandHold(RobotMap.armMotor.getSensorCollection().getQuadraturePosition()));
		
		ButtonX.whenPressed(new WristCommandPos(0.0));
		ButtonB.whenPressed(new WristCommandPos(-120.0));
		
		ButtonStart.whileHeld(new WristCommandVel(WristCommandVel.Direction.UP));
		ButtonBack.whileHeld(new WristCommandVel(WristCommandVel.Direction.DOWN));
		
		RBumper.whenPressed(new GripperCommand(GripperCommand.Action.OPEN));
		RBumper.whenReleased(new GripperCommand(GripperCommand.Action.STOP));

		LBumper.whenPressed(new GripperCommand(GripperCommand.Action.CLOSE));
		LBumper.whenReleased(new GripperCommand(GripperCommand.Action.STOP));
	}

	public double getMotorDriveLeftRightValue()
	{ // Gets horizontal left joystick value (how far it is pushed left or right)
		return xbox.getX();
	}

	public double getMotorDriveForwardBackValue()
	{ // Gets vertical left joystick value (how far it is pushed up or down)
		return -xbox.getY();
	}

	public double getMotorWristValue()
	{ // Get D-Pad value (how far it is pushed left or right)
		return xbox.getPOV();
	}

	public double getMotorGrappleValue()
	{ // Gets vertical left joystick value (how far it is pushed up or down)
		return xbox.getRawAxis(5);
	}

	public double getMoterDriveScaleFactor()
	{
		return xbox.getRawAxis(5);
	}

	public static void OI_Method()
	{
	}
}