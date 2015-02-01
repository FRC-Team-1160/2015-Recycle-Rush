package org.usfirst.frc.team1160.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI implements RobotMap{
	
	
    private static Joystick d_stick;
    private static Joystick r_stick;

    public OI() {
        d_stick = new Joystick(JOY_DRIVE);
        r_stick = new Joystick(JOY_ROTATE);
    }
    
    
    public static Joystick getDriveStick(){
        return d_stick;
    }
    
    public static Joystick getRotateStick(){
        return r_stick;
    }
	
	
}

