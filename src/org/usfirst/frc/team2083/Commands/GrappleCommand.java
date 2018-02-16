package org.usfirst.frc.team2083.Commands;

import org.usfirst.frc.team2083.robot.RobotMap;
import org.usfirst.frc.team2083.subsytems.GrappleSubsystem;
import org.usfirst.frc.team2083.toolkit.OperationalMethods;


public class GrappleCommand extends CommandBase {
	public double joystick;
	public enum Options{
		START,
		BACK,
		EXIT
	}
	 Options state;
	
	public GrappleCommand(Options state) {
		requires(grappleSubsystem);
		this.state = state;
	}
	public GrappleCommand() {
		joystick = RobotMap.RightJoystickVertical;
	}
	protected void execute() {
		switch (state) {
		case START:
			grappleSubsystem.DropActive();
			break;
		case BACK:
			grappleSubsystem.DropPrep();
			break;
		case EXIT:
			grappleSubsystem.DropExit();
			break;
		default:
			break;
		}
		grappleSubsystem.WinchControl(oi.getMotorGrappleValue());
	}
	@Override
	
	protected boolean isFinished() {
		return false;
	}
	@Override
	protected void initialize() {
		super.initialize();
	}
	
}
