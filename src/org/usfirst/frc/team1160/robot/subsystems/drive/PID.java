package org.usfirst.frc.team1160.robot.subsystems.drive;

import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PID extends PIDSubsystem implements RobotMap{
	
	String name;
	Talon motor;
	Encoder enc;
	
	
    // Initialize your subsystem here
    public PID(String name, Talon motor, Encoder enc) {
    	super(name, P, I, D);
    	this.motor = motor;
    	this.enc = enc;
    	this.name = name;
    	enc.setDistancePerPulse(RobotMap.DISTANCE_PER_PULSE);
    	this.getPIDController().setContinuous();
    	this.getPIDController().setAbsoluteTolerance(RobotMap.ABS_TOL);
    }
    
    public void reInit(){
    	getPIDController().reset();
    	getPIDController().setPID(P, I, D);
    }
    
    public void initDefaultCommand() {}
    
    protected double returnPIDInput() {
    	SmartDashboard.putNumber(this.getName() + ": PID: ", enc.pidGet());
    	return enc.pidGet();
    }
    
    public boolean finished(){
    	System.out.println(this.name + " pid error: " + this.getPIDController().getError());
    	if(this.getPIDController().onTarget())
    		System.out.println(this.getName() + ": finished.");
    	return this.getPIDController().onTarget();
    }
    
    protected void usePIDOutput(double output) {
    	SmartDashboard.putNumber(this.getName() + ": MOTOR: ", output/2);
    	motor.pidWrite(output/2);
    }
}
