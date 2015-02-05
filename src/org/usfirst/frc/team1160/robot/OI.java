package org.usfirst.frc.team1160.robot;

import org.usfirst.frc.team1160.robot.commands.drive.DriveForward;
import org.usfirst.frc.team1160.robot.commands.drive.MecanumDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI implements RobotMap{
	
	
    private static Joystick d_stick, r_stick;
    private static JoystickButton f, m;

    public OI() {
        d_stick = new Joystick(JOY_DRIVE);
        r_stick = new Joystick(JOY_ROTATE);
        
        m = new JoystickButton(d_stick, 1);
        f = new JoystickButton(d_stick, 3);
        m.whenPressed(new MecanumDrive());
        f.whenPressed(new DriveForward(20));
    }
    
    
    public static Joystick getDriveStick(){
        return d_stick;
    }
    
    public static Joystick getRotateStick(){
        return r_stick;
    }
	
	
}

