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

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCommandCenterTowerLiftWithTracking extends CommandGroup
{    
    public AutoCommandCenterTowerLiftWithTracking()
    {    	
    	requires(CommandBase.leftDriveSubsystem);
    	requires(CommandBase.rightDriveSubsystem);
    	
    	// 1. Drive forward.
       	addSequential(new AutoCommandDriveWhileTracking(.2));

       	// 2. Stall for a short period while the gear doors open.
       	addSequential(new AutoCommandGearDoors(AutoCommandGearDoors.DoorAction.OPEN));
       	
       	// 3. Drive backwards to clear the lift peg.
       	addSequential(new AutoCommandDrive(2000, -.15));
       	
       	// 4. Close the gear doors so they are ready for the next reload.
      	addSequential(new AutoCommandGearDoors(AutoCommandGearDoors.DoorAction.CLOSE));
    }
}
