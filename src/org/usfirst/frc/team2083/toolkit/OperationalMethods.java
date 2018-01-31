package org.usfirst.frc.team2083.toolkit;

import org.usfirst.frc.team2083.robot.RobotMap;

public class OperationalMethods {
	public static boolean buttonPastValues[] = new boolean[7];
	
	public static boolean whenPressed(int buttonNumber){
		boolean buttonValues[] = new boolean[] {
				RobotMap.ButtonA.get(),
				RobotMap.ButtonB.get(),
				RobotMap.ButtonX.get(),
				RobotMap.ButtonY.get(),
				RobotMap.LBumper.get(),
				RobotMap.RBumper.get(),
				RobotMap.Back.get(),
				RobotMap.Start.get()
				};
		if(buttonValues[buttonNumber] == true && buttonValues[buttonNumber] != buttonPastValues[buttonNumber]) {
			buttonPastValues[buttonNumber] = buttonValues[buttonNumber];
			System.out.println(buttonNumber);
			return true;
		}
		else {
			buttonPastValues[buttonNumber] = buttonValues[buttonNumber];
			return false;
		}
		
	}
	
	public static boolean whenReleased(int buttonNumber){
		boolean buttonValues[] = new boolean[] {
				RobotMap.ButtonA.get(),
				RobotMap.ButtonB.get(),
				RobotMap.ButtonX.get(),
				RobotMap.ButtonY.get(),
				RobotMap.LBumper.get(),
				RobotMap.RBumper.get(),
				RobotMap.Back.get(),
				RobotMap.Start.get()
				};
		if(buttonValues[buttonNumber] == false && buttonValues[buttonNumber] != buttonPastValues[buttonNumber]) {
			buttonPastValues[buttonNumber] = buttonValues[buttonNumber];
			return true;
		}
		else {
			buttonPastValues[buttonNumber] = buttonValues[buttonNumber];
			return false;
		}
	}
	public static boolean limitSwitchClicked(int switchNumber) {
		boolean switchValues[] = new boolean[] {
				RobotMap.ArmPositionLower.get(),
				RobotMap.ArmPositionUpper.get()
				};
		if(switchValues[switchNumber] == false && switchValues[switchNumber] != buttonPastValues[switchNumber]) {
			buttonPastValues[switchNumber] = switchValues[switchNumber];
			return true;
		}
		else {
			buttonPastValues[switchNumber] = switchValues[switchNumber];
			return false;
		}
	}
}
