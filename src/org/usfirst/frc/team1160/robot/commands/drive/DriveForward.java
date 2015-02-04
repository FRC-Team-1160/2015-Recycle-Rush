package org.usfirst.frc.team1160.robot.commands.drive;

import org.usfirst.frc.team1160.robot.subsystems.drive.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForward extends Command {

	private double distance;
	
    public DriveForward(double distance) {
        requires(null);
        this.distance = distance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	DriveTrain.resetPID();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	DriveTrain.forward(distance);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return DriveTrain.finished(); 
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
