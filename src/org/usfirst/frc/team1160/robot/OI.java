package org.usfirst.frc.team1160.robot;

import org.usfirst.frc.team1160.robot.commands.air.*;
import org.usfirst.frc.team1160.robot.commands.drive.MecanumDrive;
import org.usfirst.frc.team1160.robot.commands.groups.JerkyCircle;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI implements RobotMap{
	
	
    private static Joystick d_stick, r_stick;
    private JoystickButton autoTest, mecDrive, upUp, upDown, midUp, midDown, grab, leggo;

    
    /******************************************************************
     * OI
     * Assigns joysticks to a port
     * Calls tie() method
     ******************************************************************/
    public OI() {
        d_stick = new Joystick(JOY_DRIVE);
        r_stick = new Joystick(JOY_ROTATE);
        tie();
    }
    
    
    /******************************************************************
     * Initializes JoystickButtons and assigns button on joystick
     * Calls check() method
     ******************************************************************/
    private void tie(){
        upUp = new JoystickButton(d_stick, T_UP);
        upDown = new JoystickButton(d_stick, T_DOWN);
        grab = new JoystickButton(d_stick, GRAB);
        leggo = new JoystickButton(d_stick, LEGGO);
        midUp = new JoystickButton(d_stick, M_UP);
        midDown = new JoystickButton(d_stick, M_DOWN);
        mecDrive = new JoystickButton(d_stick, MEC_DRIVE);
        autoTest = new JoystickButton(d_stick, AUTO_TEST);
        check();
    }
    
    
    /******************************************************************
     * Listens to the joystick to determine when a button is pressed
     * if a button is pressed, call the respective command
     ******************************************************************/
    private void check(){   
        mecDrive.whenPressed(new MecanumDrive());
        autoTest.whenPressed(new JerkyCircle(35));
        upUp.whenPressed(new UpperUp());
        upDown.whenPressed(new UpperDown());
        midUp.whenPressed(new MidUp());
        midDown.whenPressed(new MidDown());
        grab.whenPressed(new Grab());
        leggo.whenPressed(new Release());
    }
    
    
    /******************************************************************
     * Getter methods for the joysticks
     * Allows other classes to use value of joystick input
     ******************************************************************/
    public static Joystick getDriveStick(){
        return d_stick;
    }
    
    public static Joystick getRotateStick(){
        return r_stick;
    }
	
}