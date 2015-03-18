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
    public static final int PID_ENCODER_BR_A = 2;
    public static final int PID_ENCODER_BR_B = 3;
    public static final int PID_ENCODER_FR_A = 0;
    public static final int PID_ENCODER_FR_B = 1;
    
    public static final int P_MOTOR_BL = 13;
    public static final int P_MOTOR_BR = 14;
    public static final int P_MOTOR_FL = 12;
    public static final int P_MOTOR_FR = 15;
    
    /*****************
     ***PNEUMATICS**** 
     *****************/    
    public static final int MIDDLE_A = 0;
    public static final int MIDDLE_B = 7;
    public static final int UPPER_A_A = 1;
    public static final int UPPER_A_B = 6;
    public static final int GRABBER_A = 2;
    public static final int GRABBER_B = 5;
    public static final Value EXT = DoubleSolenoid.Value.kForward;
    public static final Value RET = DoubleSolenoid.Value.kReverse;
    
    /*****************
     **JOYSTICKPORTS** 
     *****************/
    public static final int LAUNCHPAD = 0;
    public static final int JOY_DRIVE = 1;
    public static final int JOY_ROTATE = 2;
    
    /*****************
     *****BUTTONS***** 
     *****************/
    //DRIVE STICK
    public static final int MEC_DRIVE = 1;
    public static final int AUTO_A= 6;
    public static final int AUTO_B = 7;
    public static final int AUTO_C = 10;
    public static final int LIGHT_Z = 8;
    public static final int LIGHT_STROBE = 9;
    public static final int LIGHT_OFF = 3;
    public static final int ROTATE = 11;
    //ROTATE STICK
    public static final int T_UP = 4;
    public static final int T_DOWN = 5;
    public static final int M_UP = 4;
    public static final int M_DOWN = 5;
    public static final int GRAB = 1;
    public static final int LEGGO = 2;
    //LAUNCHPAD BUTTONS
    public static final int M_TOGGLE = 4;
    public static final int T_TOGGLE = 3;
    public static final int G_TOGGLE = 2;//mid grab / top mid / bot top

    /******************
     **PID CONTROLLER** 
     ******************/    
    public static final double ABS_TOL = 1;
    public static final double DISTANCE_PER_PULSE = 0.005;
    public static final double P = .4;
    public static final double I = .1;
    public static final double D = 9;
    public static final double OUT_RANGE_L = -0.8;
    public static final double OUT_RANGE_H = 0.8;
    
    
    /******************
     **AUTO DISTANCES**
     *DISTANCE IN FEET*                             // - Distance in ft
     ******************/
    public static final double BTT = 2;         	// - Bin to Tote
    public static final double STE = 4.5;       	// - Starting to Edge (Of Score)
    public static final double STA = 9.5;			// - Starting to Auto Zone
    public static final double ATC = 15;			// - Position A to Clear Scoring
    public static final double BTC = 7.25;			// - Position B to Clear Scoring
    public static final double ETA = 5;				// - Edge to Auto Zone
    public static final double BL_180 = 6;			
    public static final double FR_180 = 6;			
    public static final double BR_180 = 6;			
    public static final double FL_180 = 6;			
    public static final double T_GRAB = .400;
    public static final double T_MID =  1.2;
    public static final double CLEAR = 2.25;
    
    /******************
     ****LED Lights**** 
     ******************/
    public static final int LIGHT_PORT = 5;
    public static final int M_INDICATOR = 3;
    public static final int T_INDICATOR = 1;
    public static final int G_INDICATOR = 2;
}
