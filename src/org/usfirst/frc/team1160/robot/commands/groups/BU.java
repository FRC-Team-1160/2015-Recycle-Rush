package org.usfirst.frc.team1160.robot.commands.groups;

import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.commands.air.*;
import org.usfirst.frc.team1160.robot.commands.drive.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class BU extends CommandGroup implements RobotMap{
    
    public  BU() {
    	/*addSequential(new Grab());
    	wait(T_GRAB);
    	addSequential(new MidUp());
    	wait(T_MID);
    	addSequential(new DriveForward(BTT));
    	addSequential(new Release());
    	wait(T_GRAB);
    	addSequential(new MidDown());
    	wait(T_MID);
    	addSequential(new Grab());
    	wait(T_GRAB);
    	addSequential(new MidUp());
    	wait(T_MID);*/
    	addSequential(new RotateFrame(false, 1));
    	addSequential(new DriveForward(STE));
    	addSequential(new RotateFrame(false, 1));
    	addSequential(new DriveForward(BTC));
    	addSequential(new RotateFrame(false, -1));
    	addSequential(new DriveForward(ETA));
    }
}
