package org.usfirst.frc.team2083.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class RobotMap {
	// Setup for motor controllers
	public static WPI_TalonSRX frontLeftMotor = new WPI_TalonSRX(1); 
	public static WPI_TalonSRX frontRightMotor = new WPI_TalonSRX(2); 
	public static WPI_TalonSRX backLeftMotor = new WPI_TalonSRX(4);
	public static WPI_TalonSRX backRightMotor = new WPI_TalonSRX(3);
//	public static WPI_VictorSPX backLeftMotor = new WPI_VictorSPX(3); 
//	public static WPI_VictorSPX backRightMotor = new WPI_VictorSPX(4);
	public static WPI_TalonSRX testMotor = new WPI_TalonSRX(8);	
	
	//Setup for Joystick 
	static Joystick xBoxController = new Joystick(0); 
	public static double LeftJoystickVertical = xBoxController.getRawAxis(0);
	public static double LeftJoystickHorizontal = xBoxController.getRawAxis(1);
	public static double RightJoystickVertical = xBoxController.getRawAxis(5);
	public static Button ButtonA = new JoystickButton(xBoxController, 1);
	public static Button ButtonB = new JoystickButton(xBoxController, 2);
	public static Button ButtonX = new JoystickButton(xBoxController, 3);
	public static Button ButtonY = new JoystickButton(xBoxController, 4);
	public static Button Start = new JoystickButton(xBoxController, 8);
	public static Button Back = new JoystickButton(xBoxController, 7);
	public static Button RBumper = new JoystickButton(xBoxController, 6);
	public static Button LBumper = new JoystickButton(xBoxController, 5);
	
//	public static boolean buttonValues[] = new boolean[] {
//			ButtonA.get(),
//			ButtonB.get(),
//			ButtonX.get(),
//			ButtonY.get(),
//			LBumper.get(),
//			RBumper.get(),
//			Back.get(),
//			Start.get()
//			};
//	
	//Limit Switches
	public static DigitalInput ArmPositionLower = new DigitalInput(0);
	public static DigitalInput ArmPositionUpper = new DigitalInput(9);

}