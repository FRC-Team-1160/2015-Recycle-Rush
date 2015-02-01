package org.usfirst.frc.team1160.robot.subsystems.drive;

import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;


public class PID_FR extends DriveTrain implements RobotMap{
	
	//set ports
	Talon motor;
	Encoder encode = new Encoder(PID_ENCODER_FR_A, PID_ENCODER_FR_B, true, EncodingType.k4X);
	
	 public PID_FR(){
		 //Setting things
		 super("PID_FR", 1.0, 0.0, 0.0);
		 motor = new Talon(DT_MOTOR_FR);
		 getPIDController().enable();
		 //Set PID error tolerance
		 setAbsoluteTolerance(0.05);
		 
		 //Set PID to consider the Input as continuous
		 getPIDController().setContinuous(true);	       
	 }
	
	 	 
	 //Set PID value return method
	 protected double returnPIDInput(){
		 return encode.get();
	 }
	 
	 //Write the motor's PID Output
	 protected void usePIDOutput(double output){
		 motor.pidWrite(output);
		 
	 }
}
