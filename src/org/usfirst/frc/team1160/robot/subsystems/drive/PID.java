package org.usfirst.frc.team1160.robot.subsystems.drive;

import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class PID extends PIDSubsystem {
	
	Talon motor;
	Encoder enc;
	
    // Initialize your subsystem here
    public PID(String name, double P, double I, double D, Talon motor, Encoder enc) {
    	super(name, P, I, D);
    	this.motor = motor;
    	this.enc = enc;
    	enc.setDistancePerPulse(RobotMap.DISTANCE_PER_PULSE);
    	//this.enable();
    	this.getPIDController().setContinuous();
    	this.getPIDController().setAbsoluteTolerance(RobotMap.ABS_TOL);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
    	return enc.pidGet();
    }
    
    public boolean finished(){
    	return this.getPIDController().onTarget();
    }
    
    protected void usePIDOutput(double output) {
    	motor.pidWrite(output);
    }
}
