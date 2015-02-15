package org.usfirst.frc.team1160.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public interface RobotMap {
	
    /*****************
     ***PWMCHANNELS*** 
     *****************/
    public static final int DT_MOTOR_BL = 2;
    public static final int DT_MOTOR_FL = 3;
    public static final int DT_MOTOR_BR = 1;
    public static final int DT_MOTOR_FR = 0;
    
    /*****************
     ***DIGITAL I/O*** 
     *****************/
    public static final int PID_ENCODER_BL_A = 6;
    public static final int PID_ENCODER_BL_B = 7;
    public static final int PID_ENCODER_FL_A = 4;
    public static final int PID_ENCODER_FL_B = 5;
    public static final int PID_ENCODER_BR_A = 0;
    public static final int PID_ENCODER_BR_B = 1;
    public static final int PID_ENCODER_FR_A = 2;
    public static final int PID_ENCODER_FR_B = 3;
    
    /*****************
     ***PNEUMATICS**** 
     *****************/    
    public static final int MIDDLE_A = 5;
    public static final int MIDDLE_B = 6;
    public static final int UPPER_A_A = 2;
    public static final int UPPER_A_B = 1;
    public static final int GRABBER_A = 3;
    public static final int GRABBER_B = 4;
    public static final Value EXT = DoubleSolenoid.Value.kForward;
    public static final Value RET = DoubleSolenoid.Value.kReverse;
    
    /*****************
     **JOYSTICKPORTS** 
     *****************/
    public static final int JOY_DRIVE = 1;
    public static final int JOY_ROTATE = 2;
    
    /*****************
     *****BUTTONS***** 
     *****************/
    public static final int MEC_DRIVE = 1;
    public static final int T_UP = 4;
    public static final int T_DOWN = 5;
    public static final int M_UP = 4;
    public static final int M_DOWN = 5;
    public static final int GRAB = 1;
    public static final int LEGGO = 2;
    public static final int AUTO_A= 6;
    public static final int AUTO_B = 7;
    public static final int AUTO_C = 8;
    public static final int ROTATE = 11;

    /******************
     **PID CONTROLLER** 
     ******************/    
    public static final double ABS_TOL = 0.5;
    public static final double DISTANCE_PER_PULSE = 0.005;
    public static final double P = 1.5;
    public static final double I = 0.0;
    public static final double D = 4.5;
    
    
    /******************
     **AUTO DISTANCES**
     *DISTANCE IN FEET* 
     ******************/
    public static final double BTT = 2;         	// - Bin to Tote
    public static final double STE = 4.5;       	// - Starting to Edge (Of Score)
    public static final double STA = 9.5;			// - Starting to Auto Zone
    public static final double ATC = 17;			// - Position A to Clear Scoring
    public static final double BTC = 17;			// - Position B to Clear Scoring
    public static final double ETA = 5;				// - Edge to Auto Zone
    public static final double HALF = 1;			// - Distance needed to rotate frame 180
    public static final double QUAR = .5;			// - Distance needed to rotate frame 90
    public static final double BL_180 = 6.576;
    public static final double FR_180 = 5.13;
    public static final double BR_180 = 7.416;
    public static final double FL_180 = 6.576;
    
    
}
