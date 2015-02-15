package org.usfirst.frc.team1160.robot.commands.groups;

import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.commands.air.*;
import org.usfirst.frc.team1160.robot.commands.drive.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CU extends CommandGroup implements RobotMap{
    
    public  CU() {
    	addSequential(new Grab());
    	addSequential(new MidUp());
    	addSequential(new DriveForward(BTT));
    	addSequential(new Release());
    	addSequential(new MidDown());
    	addSequential(new Grab());
    	addSequential(new MidUp());
    	addSequential(new RotateFrame(false, 1));
    	addSequential(new DriveForward(STA));
    }
}
