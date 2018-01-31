package org.usfirst.frc.team2083.robot.commands;

import org.usfirst.frc.team2083.toolkit.OperationalMethods;

public class GrappleRelease {
	static boolean grappleModeEnabled;
	public static void grappleRelease() {
		if(OperationalMethods.whenPressed(7) && !grappleModeEnabled) {
			grappleModeEnabled = true;
		}
		if(OperationalMethods.whenPressed(7) && grappleModeEnabled) {
			grappleModeEnabled = false;
		}
		if(OperationalMethods.whenPressed(8) && grappleModeEnabled) {
			System.out.println("We dropped a thing");
		}
	}
}
