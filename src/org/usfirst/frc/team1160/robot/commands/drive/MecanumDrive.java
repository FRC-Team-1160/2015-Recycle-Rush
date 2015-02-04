package org.usfirst.frc.team1160.robot.commands.drive;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class MecanumDrive extends Command {

    public MecanumDrive() {
        requires(Robot.pbl);
        requires(Robot.pbr);
        requires(Robot.pfl);
        requires(Robot.pfr);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.pbl.mecanumDrive();
    	Robot.pfl.mecanumDrive();
    	Robot.pbr.mecanumDrive();
    	Robot.pfr.mecanumDrive();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
