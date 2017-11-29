/*
 * Copyright 2017 "TeamBlitz Robotics Club"
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/

package org.usfirst.frc.team2083.robot.commands.auto;

import org.usfirst.frc.team2083.robot.commands.CommandBase;

/**
 *
 */
public class AutoCommandDrive extends CommandBase
{
	long duration;
	long startTime;
	double voltage;
	
    public AutoCommandDrive(long duration, double voltage)
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(leftDriveSubsystem);
    	requires(rightDriveSubsystem);
    	
    	this.voltage = voltage;
    	this.duration = duration;
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    	startTime = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
    	if(System.currentTimeMillis() - startTime < duration )
    	{
    		leftDriveSubsystem.setVoltage(voltage);
    		rightDriveSubsystem.setVoltage(voltage*.9);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return System.currentTimeMillis() - startTime > duration;
    }

    // Called once after isFinished returns true
    protected void end()
    {
    	leftDriveSubsystem.setVoltage(0);
    	rightDriveSubsystem.setVoltage(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
    }
}
