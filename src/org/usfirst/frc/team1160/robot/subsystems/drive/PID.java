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
	
	private String name;
	private Talon motor;
	private Encoder enc;
	
	
    /******************************************************************
     * Constructor for the PID Subsystem, used with each wheel
     * -super() is required to initialize the subsystem with the given
     *  values
     * -this.variable = variable; allows the entire class to use the
     *  variables passed into PID() as arguments
     ******************************************************************/
    public PID(String name, Talon motor, Encoder enc) {
    	super(name, P, I, D);
    	this.motor = motor;
    	this.enc = enc;
    	enc.setDistancePerPulse(RobotMap.DISTANCE_PER_PULSE);
    	this.getPIDController().setContinuous();
    	this.getPIDController().setAbsoluteTolerance(RobotMap.ABS_TOL);
    }
    
    
    /******************************************************************
     * @see DriveTrain#reset() 
     * for information
     ******************************************************************/
    public void reInit(){
    	getPIDController().reset();
    	getPIDController().setPID(P, I, D);
    }
    
    
    /******************************************************************
     * returnPIDInput() is a method that is required by PIDSubsystem
     * -Allows monitoring of the PID values in SmartDashboard
     * -enc.pidGet() passes the value of the encoder into the
     *  PIDSubystem, allowing for motor feedback
     ******************************************************************/
    protected double returnPIDInput() {
    	SmartDashboard.putNumber(this.getName() + ": PID: ", enc.pidGet());
    	return enc.pidGet();
    }
    
    
    /******************************************************************
     * @see DriveTrain#itDone()
     * for information
     ******************************************************************/
    public boolean finished(){
    	SmartDashboard.putNumber(this.name + " error: ", this.getPIDController().getError());
    	return this.getPIDController().onTarget();
    }
    
    
    /******************************************************************
     * usePIDOutput() is required by PIDSubsystem
     * -takes the calculations done by the system and passes them
     *  into the motor
     *  -output is reduced by half so motors don't run at full speed
     ******************************************************************/
    protected void usePIDOutput(double output) {
    	SmartDashboard.putNumber(this.getName() + ": MOTOR: ", output/2);
    	motor.pidWrite(output/2);
    }
    
    public void initDefaultCommand() {}
}
