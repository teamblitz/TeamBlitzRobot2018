package org.usfirst.frc.team2083.robot.commands;

import org.usfirst.frc.team2083.robot.RobotMap;
import org.usfirst.frc.team2083.robot.commands.CommandBase;
import org.usfirst.frc.team2083.toolkit.OperationalMethods;


public class ArmCommand extends CommandBase{
	static int intendedPosition;
	static int currentPosition;
	static boolean analogControl;
	
	public static void mainArm() {
		getIntendedPosition();
		getCurrentPosition();
		if (analogControl) {
			System.out.println(RobotMap.RightJoystickVertical);
		}
		
		else {
			System.out.println("Checking intendedPosition againt currentPosition");
			System.out.println(intendedPosition + ", " + currentPosition);
			
			if(intendedPosition < currentPosition) {
				System.out.println("Motor = -1");
				System.out.println(intendedPosition + ", "+ currentPosition);
			}
			if(intendedPosition > currentPosition){
				System.out.println("Motor = 1");
				System.out.println(intendedPosition + ", "+ currentPosition);
			}
			if( intendedPosition == currentPosition ) {
				System.out.println("Motor = 0");
				System.out.println(intendedPosition + ", "+ currentPosition);
			}
		}
	}
	
	public static void getIntendedPosition() {
		if(OperationalMethods.whenPressed(0)) {
			intendedPosition = 0;
			analogControl = false;

		}
		if(OperationalMethods.whenPressed(1)) {
			intendedPosition = 1;
			analogControl = false;

		}
		if(OperationalMethods.whenPressed(3)) {
			intendedPosition = 2;
			analogControl = false;
		}
		if(OperationalMethods.whenPressed(2)) {
			analogControl = true;
		}
	}
	public static void getCurrentPosition() {
		if(OperationalMethods.limitSwitchClicked(0)) {
			currentPosition = 0;
		}
		if(OperationalMethods.limitSwitchClicked(1)) {
			currentPosition = 2;
		}
		else {
			currentPosition =  3;
		}
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
}

