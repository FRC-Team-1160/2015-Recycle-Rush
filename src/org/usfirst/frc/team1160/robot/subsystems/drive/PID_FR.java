package org.usfirst.frc.team1160.robot.subsystems.drive;

import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;


public class PID_FR extends DriveTrain implements RobotMap{
	
	
	private static PID_FR instance;
	
	public static PID_FR getInstance(){
		if(instance == null)
			instance = new PID_FR();
		return instance;
	}
	
	 private PID_FR(){
		 //Setting things
		 super("PID_FR", 1.0, 0.0, 0.0);
		 fr = new Talon(DT_MOTOR_FR);
		 efr = new Encoder(PID_ENCODER_FR_A, PID_ENCODER_FR_B, false, EncodingType.k4X);
		 efr.setDistancePerPulse(DISTANCE_PER_PULSE);
		 getPIDController().enable();
		 //Set PID error tolerance
		 setAbsoluteTolerance(0.05);
		 //Set PID to consider the Input as continuous
		 getPIDController().setContinuous(true);	       
	 }
	
	 	 
	 //Set PID value return method
	 protected double returnPIDInput(){
		 return efr.get();
	 }
	 
	 //Write the motor's PID Output
	 protected void usePIDOutput(double output){
		 fr.pidWrite(output);
		 
	 }
}
