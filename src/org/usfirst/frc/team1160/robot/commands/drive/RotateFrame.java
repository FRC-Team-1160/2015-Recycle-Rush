package org.usfirst.frc.team1160.robot.commands.drive;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RotateFrame extends Command {

	boolean half;
	int dir;
	
    public RotateFrame(boolean half, int dir) {
    	requires(Robot.dt);
    	this.half = half;
    	this.dir = dir;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.dt.reset();
    	Robot.dt.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.dt.rotateFrame(half, dir);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.dt.itDone();
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
