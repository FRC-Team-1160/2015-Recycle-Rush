package org.usfirst.frc.team1160.robot.commands.groups;

import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.commands.air.*;
import org.usfirst.frc.team1160.robot.commands.drive.*;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class AutoMiddleStart extends CommandGroup implements RobotMap{
    
    public  AutoMiddleStart() {
    	addSequential(new Grab());
    	addSequential(new UpperUp());
    	addSequential(new DriveForward(FORWARD_INIT));
    	addSequential(new DriveLeft(SIDE/2));
    	addSequential(new DriveForward(FORWARD_SEC));
    	addSequential(new UpperDown());
    	addSequential(new Release());
    }
}


//X = ROBOT START
/******************************************************************
 * |         SCORING PLATFORM         |****************************
 * |         SCORING PLATFORM         |****************************
 * ****************************************************************
 * ****************************************************************
 * ****************************************************************
 * ****************************************************************
 * *****************|^|********************************************
 * *****************|^|********|         SCORING PLATFORM         |
 * *****************|^|********|         SCORING PLATFORM         |
 * *****************|^|\\\\\\\\\\\\\*******************************
 * *****************<<<<<<<<<<<<<<<<*******************************
 * *****************\\\\\\\\\\\\\|^|*******************************
 * ******************************|^|*******************************
 * ************[STAGE1]********[STAGE2]********[STAGE3]************
 * *******************************X********************************
*******************************************************************/