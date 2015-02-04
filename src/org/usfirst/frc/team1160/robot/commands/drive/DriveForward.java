package org.usfirst.frc.team1160.robot.commands.drive;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForward extends Command {

	private double distance;
	
    public DriveForward(double distance) {
        requires(Robot.pbl);
        requires(Robot.pbr);
        requires(Robot.pfl);
        requires(Robot.pfr);
        this.distance = distance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
   	 Robot.pbl.getPIDController().reset();
   	 Robot.pfl.getPIDController().reset();
   	 Robot.pfr.getPIDController().reset();
   	 Robot.pbr.getPIDController().reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
   	 Robot.pbl.forward(distance);
   	 Robot.pfl.forward(distance);
   	 Robot.pfr.forward(distance);
   	 Robot.pbr.forward(distance);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.pbl.finished();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
