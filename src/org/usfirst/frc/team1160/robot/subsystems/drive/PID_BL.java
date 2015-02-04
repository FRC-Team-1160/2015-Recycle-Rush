package org.usfirst.frc.team1160.robot.subsystems.drive;

import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;


public class PID_BL extends DriveTrain implements RobotMap{
	
	private static PID_BL instance;
	
	public static PID_BL getInstance(){
		if(instance == null)
			instance = new PID_BL();
		return instance;
	}
	
	 private PID_BL(){
		 //Setting things
		 super("PID_BL", 1.0, 0.0, 0.0);
		 bl = new Talon(DT_MOTOR_BL);
		 ebl = new Encoder(PID_ENCODER_BL_A, PID_ENCODER_BL_B, false, EncodingType.k4X);
		 ebl.setDistancePerPulse(DISTANCE_PER_PULSE);
		 getPIDController().enable();
		 //Set PID error tolerance
		 setAbsoluteTolerance(0.05);
		 //Set PID to consider the Input as continuous
		 getPIDController().setContinuous(true);
	 }
	
	 
	 //Set PID value return method
	 protected double returnPIDInput(){
		 return ebl.get();
	 }
	 
	 //Write the motor's PID Output
	 protected void usePIDOutput(double output){
		 bl.pidWrite(output);
	 }
}
