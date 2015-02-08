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
	
    public static final int DT_MOTOR_BL = 1;
    public static final int DT_MOTOR_FL = 2;
    public static final int DT_MOTOR_BR = 3;
    public static final int DT_MOTOR_FR = 4;
    
    /*****************
     ***DIGITAL I/O*** 
     *****************/
    
    public static final int PID_ENCODER_BL_A = 2;
    public static final int PID_ENCODER_BL_B = 3;
    public static final int PID_ENCODER_FL_A = 4;
    public static final int PID_ENCODER_FL_B = 5;
    public static final int PID_ENCODER_BR_A = 6;
    public static final int PID_ENCODER_BR_B = 7;
    public static final int PID_ENCODER_FR_A = 8;
    public static final int PID_ENCODER_FR_B = 9;
    
    /*****************
     ***PNEUMATICS**** 
     *****************/    
    
    public static final int MIDDLE_A = 1;
    public static final int MIDDLE_B = 2;
    public static final int UPPER_A_A = 3;
    public static final int UPPER_A_B = 4;
    public static final int UPPER_B_A = 5;
    public static final int UPPER_B_B = 6;
    public static final int GRABBER_A = 3;
    public static final int GRABBER_B = 3;
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
    public static final int T_UP = 2;
    public static final int T_DOWN = 3;
    public static final int M_UP = 4;
    public static final int M_DOWN = 5;
    public static final int GRAB = 6;
    public static final int LEGGO = 7;
    public static final int AUTO_TEST = 6;

    /******************
     **PID CONTROLLER** 
     ******************/    

    public static final double ABS_TOL = 0.5;
    public static final double DISTANCE_PER_PULSE = 0.1;
    public static final double P = 1.0;
    public static final double I = 0.0;
    public static final double D = 1.5;
    
    
    /******************
     **AUTO DISTANCES** 
     ******************/
    public static final double FORWARD_INIT = 20;
    public static final double SIDE = 20;
    public static final double FORWARD_SEC = 20;
    
}
