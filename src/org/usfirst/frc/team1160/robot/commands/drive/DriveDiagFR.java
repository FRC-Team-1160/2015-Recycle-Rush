package org.usfirst.frc.team1160.robot.commands.drive;

import org.usfirst.frc.team1160.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveDiagFR extends Command {

	private double distance;
	
    public DriveDiagFR(double distance) {
    	requires(Robot.dt);
        this.distance = distance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.dt.reset();
    	Robot.dt.enable();
    	System.out.println("moving diagonally forward right : " + distance + " meters");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.dt.diagFR(distance);
//    	System.out.println(Robot.dt.blP.getPosition());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.dt.itDone();
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("finsihes");
    	Robot.dt.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.dt.blP.disable();
    	Robot.dt.brP.disable();
    	Robot.dt.flP.disable();
    	Robot.dt.frP.disable();
    }
}
