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
public class CU extends CommandGroup implements RobotMap{
    
    public  CU() {
    	addSequential(new Grab());
    	addSequential(new Pause(T_GRAB));
    	
    	addSequential(new MidUp());
    	addSequential(new Pause(T_MID));
    	
    	addSequential(new DriveForward(BTT));
    
    	addSequential(new Release());
    	addSequential(new Pause(T_GRAB));
    	
    	addSequential(new MidDown());
    	addSequential(new Pause(T_MID));
    	
    	addSequential(new Grab());
    	addSequential(new Pause(T_GRAB));
    	
    	addSequential(new MidUp());
    	addSequential(new Pause(T_MID));
    	
    	
    	addSequential(new RotateFrame(false, 1));
    	
    	addSequential(new DriveForward(STA));
    
    	addSequential(new MidDown());
    	addSequential(new Pause(T_MID));
    	
    	addSequential(new Release());
    	addSequential(new Pause(T_GRAB));
    	
    	addSequential(new DriveForward(-CLEAR));
    }
}
