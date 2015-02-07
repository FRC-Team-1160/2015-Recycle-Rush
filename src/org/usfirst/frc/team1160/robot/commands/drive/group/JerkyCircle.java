package org.usfirst.frc.team1160.robot.commands.drive.group;

import org.usfirst.frc.team1160.robot.commands.drive.DriveBackwards;
import org.usfirst.frc.team1160.robot.commands.drive.DriveDiagBL;
import org.usfirst.frc.team1160.robot.commands.drive.DriveDiagBR;
import org.usfirst.frc.team1160.robot.commands.drive.DriveDiagFL;
import org.usfirst.frc.team1160.robot.commands.drive.DriveDiagFR;
import org.usfirst.frc.team1160.robot.commands.drive.DriveForward;
import org.usfirst.frc.team1160.robot.commands.drive.DriveLeft;
import org.usfirst.frc.team1160.robot.commands.drive.DriveRight;

import edu.wpi.first.wpilibj.command.CommandGroup;


public class JerkyCircle extends CommandGroup{

	public JerkyCircle(int distance){
		
		addSequential(new DriveForward(distance));
		addSequential(new DriveDiagFL(distance));
		addSequential(new DriveLeft(distance));
		addSequential(new DriveDiagBL(distance));
		addSequential(new DriveBackwards(distance));
		addSequential(new DriveDiagBR(distance));
		addSequential(new DriveRight(distance));
		addSequential(new DriveDiagFR(distance));

	}
}
