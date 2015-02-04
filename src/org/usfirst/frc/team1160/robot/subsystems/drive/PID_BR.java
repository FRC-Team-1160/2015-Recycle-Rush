package org.usfirst.frc.team1160.robot.subsystems.drive;

import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;


public class PID_BR extends DriveTrain implements RobotMap{
	
	private static PID_BR instance;
	
	public static PID_BR getInstance(){
		if(instance == null)
			instance = new PID_BR();
		return instance;
	}	
	
	 private PID_BR(){
		 //Setting things
		 super("PID_BR", 1.0, 0.0, 0.0);
		 br = new Talon(DT_MOTOR_BR);
		 ebr = new Encoder(PID_ENCODER_BR_A, PID_ENCODER_BR_B, false, EncodingType.k4X);
		 ebr.setDistancePerPulse(DISTANCE_PER_PULSE);
		 getPIDController().enable();
		 //Set PID error tolerance
		 setAbsoluteTolerance(0.05);
		 //Set PID to consider the Input as continuous
		 getPIDController().setContinuous(true);	       
	 }
	
	 	 
	 //Set PID value return method
	 protected double returnPIDInput(){
		 return ebr.pidGet();
	 }
	 
	 //Write the motor's PID Output
	 protected void usePIDOutput(double output){
		 br.pidWrite(output);
		 
	 }
}
