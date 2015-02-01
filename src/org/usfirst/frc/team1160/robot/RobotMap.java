package org.usfirst.frc.team1160.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public interface RobotMap {
	
	
    //Ports
    public final static int DT_MOTOR_FR = 1;
    public final static int DT_MOTOR_BR = 2;
    public final static int DT_MOTOR_BL = 3;
    public final static int DT_MOTOR_FL = 4;
    public final static int PN_SOL_A = 1;
    public final static int PN_SOL_B = 2;
    public final static int PN_PRESSURE_SWITCH = 1;
    public final static int PN_RELAY = 1;
    
    //Joysticks
    public final static int JOY_DRIVE = 1;
    public final static int JOY_ROTATE = 2;
    
    //PID
    public final static int PID_ENCODER_FL_A = 1;
    public final static int PID_ENCODER_FL_B = 2;
    public final static int PID_ENCODER_BL_A = 3;
    public final static int PID_ENCODER_BL_B = 4;
    public final static int PID_ENCODER_FR_A = 5;
    public final static int PID_ENCODER_FR_B = 6;
    public final static int PID_ENCODER_BR_A = 7;
    public final static int PID_ENCODER_BR_B = 8;
    
    //Camera
    public final static String CAM_ADDRESS = "10.11.60.2";
    public final static int R_LOW = 96;
    public final static int R_HIGH = 224;    
    public final static int G_LOW = 96;
    public final static int G_HIGH = 224;
    public final static int B_LOW = 96;
    public final static int B_HIGH = 224;
	
	
	
}
