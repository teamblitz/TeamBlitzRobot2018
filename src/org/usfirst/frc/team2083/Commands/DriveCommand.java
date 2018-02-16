package org.usfirst.frc.team2083.Commands;

import org.usfirst.frc.team2083.robot.RobotMap;
import org.usfirst.frc.team2083.subsytems.DriveSubsystem;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveCommand extends CommandBase{
	final double joystickZeroThreshold = 0.15;
	public boolean pidControl;
	public DriveCommand() {								//Check that the driveSubsystem is accessible
		requires(driveSubsystem);
		pidControl = false;
	}
	
	public void enableControl() {						//Call "enableControl" in DriveSubsytem.java
		driveSubsystem.enableControl();
	}
	
	public void disableControl() {						//Call "disableControl" in DriveSubsystem.java
		driveSubsystem.disableControl();
	}
	
	protected void initialize() {						//???
	}
	
	protected void execute(){							//Taking into account threshold amount and joystick positions, set the voltage to the desired amount
    	double x = 0, y = 0;

    	// Get controller input.
    	x = oi.getMotorDriveLeftRightValue();
    	y = oi.getMotorDriveForwardBackValue();
    	x = x * Math.abs(x);
    	y = y * Math.abs(y);
    	
    	// Set drive motor input to zero if joystick is close to zero.
    	if (Math.abs(x) < joystickZeroThreshold && Math.abs(y) < joystickZeroThreshold)
    	{
    		//System.out.println("Raw (x, y) = (" + x + ", " + y + ")");
    		x = 0;
    		y = 0;    		
    	}
    	
    	// System.out.println("Raw (X,Y): (" + x + ", " + y + ")");
    	
//    	double m = -oi.getMoterDriveScaleFactor();
//		final double a0 = 0.4;
//		final double a1 = 0.26666;
//		final double a2 = 0.2;
//		final double a3 = 0.13333;
//		double driveMotorScaleFactor = a0 + (a1 * m) + (a2 * Math.pow(m, 2)) + (a3 * Math.pow(m, 3));
		double leftDriveVoltage = (y + x) ;//* driveMotorScaleFactor;
		double rightDriveVoltage = (y - x) ;//* driveMotorScaleFactor;
//        
//        driveSubsystem.setLeftVoltage(leftDriveVoltage);
//      driveSubsystem.setRightVoltage(rightDriveVoltage);
//    	if(pidControl) {
        	//driveSubsystem.leftPID(leftDriveVoltage);
        	//driveSubsystem.rightPID(rightDriveVoltage);
//    	}
    	
//    	else {
    		driveSubsystem.setLeftVoltage(leftDriveVoltage);
    		driveSubsystem.setRightVoltage(rightDriveVoltage);
    		
//    	}
        
//        double lbc = RobotMap.backLeftMotor.getOutputCurrent();
//        double rbc = RobotMap.backRightMotor.getOutputCurrent();
//        double lfc = RobotMap.frontLeftMotor.getOutputCurrent();
//        double rfc = RobotMap.frontRightMotor.getOutputCurrent();
//                
//        SmartDashboard.putNumber("Left Front Current", lfc);
//        SmartDashboard.putNumber("Left Back Current", lbc);
//        SmartDashboard.putNumber("Right Front Current", rfc);
//        SmartDashboard.putNumber("Right Back Current", rbc);
    }
	
	@Override
	protected boolean isFinished() {
		
		return false;
	}
	protected void end() {
		System.out.println("Drive System Ended");
	}
	
	protected void interrupted() {
		System.out.println("Drive System Interuppted");
	}
}
