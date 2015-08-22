package org.usfirst.frc.team1160.robot.commands.groups;

import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.commands.Pause;
import org.usfirst.frc.team1160.robot.commands.air.Grab;
import org.usfirst.frc.team1160.robot.commands.air.MidDown;
import org.usfirst.frc.team1160.robot.commands.air.MidUp;
import org.usfirst.frc.team1160.robot.commands.air.Release;
import org.usfirst.frc.team1160.robot.commands.drive.DriveForward;
import org.usfirst.frc.team1160.robot.commands.drive.RotateFrame;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CanU extends CommandGroup implements RobotMap{
    
    public  CanU() {
    	
    	addSequential(new Grab());
    	addSequential(new Pause(T_GRAB));   	
    	
    	addSequential(new MidUp());
    	addSequential(new Pause(T_MID));
    	
    	addSequential(new RotateFrame(false, 1));    	
    	addSequential(new DriveForward(STA));
    	
    	
    	
    }
    
}
