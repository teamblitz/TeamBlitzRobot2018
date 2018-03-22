package org.usfirst.frc.team2083.robot;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class RobotMap
{
	/*
	 * Motor IDs
	 */
	
	// Drive System Motors
	public static WPI_TalonSRX frontLeftMotor = new WPI_TalonSRX(1); // 1
	static
	{
		frontLeftMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
		frontLeftMotor.getSensorCollection().setQuadraturePosition(0, 10);
		frontLeftMotor.setInverted(false);
	}

	public static WPI_TalonSRX frontRightMotor = new WPI_TalonSRX(2); // 2
	static
	{
		frontRightMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
		frontRightMotor.getSensorCollection().setQuadraturePosition(0, 10);
		frontRightMotor.setInverted(false);
	}

	public static WPI_VictorSPX	backRightMotor	= new WPI_VictorSPX(5);	// 5 (Slave)
	public static WPI_VictorSPX	backLeftMotor	= new WPI_VictorSPX(6);	// 6 (Slave)

	// Arm Motors
	public static WPI_TalonSRX armMotor = new WPI_TalonSRX(8); // 8
	static
	{
		armMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
		armMotor.getSensorCollection().setQuadraturePosition(0, 10);
		armMotor.setSensorPhase(false);
//		armMotor.setInverted(false);
		armMotor.configNominalOutputForward(0, 10);
		armMotor.configNominalOutputReverse(0, 10);
		armMotor.configPeakOutputForward(1, 10);
		armMotor.configPeakOutputReverse(-1, 10);
		armMotor.configAllowableClosedloopError(0, 0, 10);
		armMotor.config_kF(0, 0.0, 10);
		armMotor.config_kP(0, 0.1, 10);
		armMotor.config_kI(0, 0.0, 10);
		armMotor.config_kD(0, 0.0, 10);
		armMotor.configForwardSoftLimitThreshold(1000, 10);
		armMotor.configForwardSoftLimitThreshold(-1000, 10);
		armMotor.setSelectedSensorPosition(0, 0, 10);
	}

	// Wrist Motors
	public static WPI_TalonSRX wristMotor = new WPI_TalonSRX(9); // 9
	static
	{
		wristMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
		wristMotor.getSensorCollection().setQuadraturePosition(0, 10);
		wristMotor.setInverted(false);
	}

	// Gripper Motors
	public static WPI_TalonSRX gripperMotor = new WPI_TalonSRX(3); // 3
	static
	{
		gripperMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
		gripperMotor.getSensorCollection().setQuadraturePosition(0, 10);
		gripperMotor.setInverted(false);
	}

	// Grapple Motor (for the winch)
	public static WPI_TalonSRX grappleMotor = new WPI_TalonSRX(4); // 4

	/*
	 * Joystick IDs
	 */

	// XBox Controller ID
	static Joystick xBoxController = new Joystick(0); // 0

	// XBox Joystick IDs


	public static double RightJoystickHorizontal = xBoxController.getRawAxis(6); // Unused and Untested

	// XBox ABXY Button IDs
	public static Button	ButtonA	= new JoystickButton(xBoxController, 1);	// 1
	public static Button	ButtonB	= new JoystickButton(xBoxController, 2);	// 2
	public static Button	ButtonX	= new JoystickButton(xBoxController, 3);	// 3
	public static Button	ButtonY	= new JoystickButton(xBoxController, 4);	// 4

	// XBox Bumper IDs
	public static Button	LBumper	= new JoystickButton(xBoxController, 5);	// 5
	public static Button	RBumper	= new JoystickButton(xBoxController, 6);	// 6

	// XBox Miscellaneous IDs
	public static Button	Back	= new JoystickButton(xBoxController, 7);	// 7
	public static Button	Start	= new JoystickButton(xBoxController, 8);	// 8
	public static double	POV		= xBoxController.getPOV();					// "N/A"

	/*
	 * Other IDs
	 */

	// Limit Switch IDs
	public static DigitalInput	WristPositionLower	= new DigitalInput(1);	// 0
	public static DigitalInput	WristPositionUpper	= new DigitalInput(8);	// 8
	public static DigitalInput	ArmPositionLower	= new DigitalInput(9);	// 0
	public static DigitalInput	ArmPositionUpper	= new DigitalInput(0);	// 9
	
	// Game Data
	public static String gameData;
}
