package org.usfirst.frc.team1160.robot;

import org.usfirst.frc.team1160.robot.commands.air.*;
import org.usfirst.frc.team1160.robot.commands.drive.MecanumDrive;
import org.usfirst.frc.team1160.robot.commands.groups.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI implements RobotMap{
	
	
    private static Joystick d_stick, r_stick;
    private JoystickButton autoTest, mecDrive, upUp, upDown, midUp, midDown, grab, leggo;

    public OI() {
        d_stick = new Joystick(JOY_DRIVE);
        r_stick = new Joystick(JOY_ROTATE);
        
        upUp = new JoystickButton(d_stick, T_UP);
        upDown = new JoystickButton(d_stick, T_DOWN);
        grab = new JoystickButton(d_stick, GRAB);
        leggo = new JoystickButton(d_stick, LEGGO);
        midUp = new JoystickButton(d_stick, M_UP);
        midDown = new JoystickButton(d_stick, M_DOWN);
        mecDrive = new JoystickButton(d_stick, MEC_DRIVE);
        autoTest = new JoystickButton(d_stick, AUTO_TEST);
        
        
        mecDrive.whenPressed(new MecanumDrive());
        autoTest.whenPressed(new JerkyCircle(35));
        upUp.whenPressed(new UpperUp());
        upDown.whenPressed(new UpperDown());
        midUp.whenPressed(new MidUp());
        midDown.whenPressed(new MidDown());
        grab.whenPressed(new Grab());
        leggo.whenPressed(new Release());
    }
    
    
    public static Joystick getDriveStick(){
        return d_stick;
    }
    
    public static Joystick getRotateStick(){
        return r_stick;
    }
	
}