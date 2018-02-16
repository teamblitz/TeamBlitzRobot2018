package org.usfirst.frc.team2083.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class RobotMap { //Where all the cool kid IDs hang out
	
	/*
	 *  Motor IDs
	 */
	
		//Drivesystem Motors
		public static WPI_TalonSRX frontLeftMotor = new WPI_TalonSRX(1); //1
		public static WPI_TalonSRX frontRightMotor = new WPI_TalonSRX(2);//2
		public static WPI_VictorSPX backRightMotor = new WPI_VictorSPX(5);//5
		public static WPI_VictorSPX backLeftMotor = new WPI_VictorSPX(6);//6
		
		//Arm Motors
		public static WPI_TalonSRX armMotor = new WPI_TalonSRX(8);//8
		public static WPI_VictorSPX armSlave = new WPI_VictorSPX(7);//7
		
		//Wrist Motors
		public static WPI_TalonSRX wristMotor = new WPI_TalonSRX(9);//9
		public static WPI_TalonSRX wristSlave = new WPI_TalonSRX(10);//10
	
		//Gripper Motors
		public static WPI_TalonSRX gripperMotor = new WPI_TalonSRX(3);//3
		public static WPI_VictorSPX gripperSlave = new WPI_VictorSPX(11);//11
		
		//Grapple Motor (for the winch)
		public static WPI_TalonSRX grappleMotor = new WPI_TalonSRX(4);//4

	/*
	 *  Joystick IDs
	 */
		
		//XBox Controller ID
		static Joystick xBoxController = new Joystick(0); 
		
		//XBox Joystick IDs
		public static double LeftJoystickVertical = xBoxController.getRawAxis(0);
		public static double LeftJoystickHorizontal = xBoxController.getRawAxis(1);
		public static double RightJoystickVertical = xBoxController.getRawAxis(5);
		public static double RightJoystickHorizontal = xBoxController.getRawAxis(6); //Unused and Untested
		
		//XBox ABXY Button IDs
		public static Button ButtonA = new JoystickButton(xBoxController, 1);
		public static Button ButtonB = new JoystickButton(xBoxController, 2);
		public static Button ButtonX = new JoystickButton(xBoxController, 3);
		public static Button ButtonY = new JoystickButton(xBoxController, 4);
		
		//XBox Bumper IDs
		public static Button LBumper = new JoystickButton(xBoxController, 5);
		public static Button RBumper = new JoystickButton(xBoxController, 6);
		
		//XBox Miscellaneous IDs
		public static Button Back = new JoystickButton(xBoxController, 7);
		public static Button Start = new JoystickButton(xBoxController, 8);
		public static double POV = xBoxController.getPOV();
	
	/*
	 *  Other IDs
	 */
		
		//Encoders
		
		//Limit Switch IDs
		public static DigitalInput ArmPositionLower = new DigitalInput(0);
		public static DigitalInput ArmPositionUpper = new DigitalInput(9);

}