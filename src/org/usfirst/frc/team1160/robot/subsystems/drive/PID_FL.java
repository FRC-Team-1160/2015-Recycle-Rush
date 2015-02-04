package org.usfirst.frc.team1160.robot.subsystems.drive;

import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;

public class PID_FL extends DriveTrain implements RobotMap {


	private static PID_FL instance;
	
	public static PID_FL getInstance(){
		if(instance == null)
			instance = new PID_FL();
		return instance;
	}
	
	private PID_FL() {
		// Setting things
		super("PID_FL", 1.0, 0.0, 0.0);
		fl = new Talon(DT_MOTOR_FL);
		efl = new Encoder(PID_ENCODER_FL_A, PID_ENCODER_FL_B, false, EncodingType.k4X);
		efl.setDistancePerPulse(DISTANCE_PER_PULSE);
		getPIDController().enable();
		// Set PID error tolerance
		setAbsoluteTolerance(0.05);
		// Set PID to consider the Input as continuous
		getPIDController().setContinuous(true);
	}

	// Set PID value return method
	protected double returnPIDInput() {
		return efl.get();
	}

	// Write the motor's PID Output
	protected void usePIDOutput(double output) {
		fl.pidWrite(output);

	}
}
