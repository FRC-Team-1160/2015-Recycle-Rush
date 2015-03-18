package org.usfirst.frc.team1160.robot;

import org.usfirst.frc.team1160.robot.commands.air.Grab;
import org.usfirst.frc.team1160.robot.commands.air.MidDown;
import org.usfirst.frc.team1160.robot.commands.air.MidUp;
import org.usfirst.frc.team1160.robot.commands.air.Release;
import org.usfirst.frc.team1160.robot.commands.air.Switch;
import org.usfirst.frc.team1160.robot.commands.air.UpperDown;
import org.usfirst.frc.team1160.robot.commands.air.UpperUp;
import org.usfirst.frc.team1160.robot.commands.drive.DriveForward;
import org.usfirst.frc.team1160.robot.commands.drive.MecanumDrive;
import org.usfirst.frc.team1160.robot.commands.drive.RotateFrame;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI implements RobotMap{
	
	
    private static Joystick launchpad;
    private static FancyJoystick r_stick, d_stick;
    private JoystickButton autoA, autoB, autoC, strobe, zcont, 
    						off, mecDrive, upUp, upDown, midUp,
    						midDown, grab, leggo, rotate, toggleUp,
    						toggleMid, toggleGrab;
    

    
    /******************************************************************
     * OI
     * Assigns joysticks to a port
     * Calls tie() method
     ******************************************************************/
    public OI() {
        d_stick = new FancyJoystick(JOY_DRIVE);
        r_stick = new FancyJoystick(JOY_ROTATE);
        launchpad = new Joystick(LAUNCHPAD);
        tie();
    }
    
    
    /******************************************************************
     * Initializes JoystickButtons and assigns button on joystick
     * Calls check() method
     ******************************************************************/
    private void tie(){
        upUp = new JoystickButton(d_stick, T_UP);
        upDown = new JoystickButton(d_stick, T_DOWN);
        mecDrive = new JoystickButton(d_stick, MEC_DRIVE);
        autoA = new JoystickButton(d_stick, AUTO_A);
        //autoB = new JoystickButton(d_stick, AUTO_B);
        //autoC = new JoystickButton(d_stick, AUTO_C);
        rotate = new JoystickButton(d_stick, ROTATE);
        //off = new JoystickButton(d_stick, LIGHT_OFF);
        //strobe = new JoystickButton(d_stick, LIGHT_STROBE);
        //zcont = new JoystickButton(d_stick, LIGHT_Z);
        
        midUp = new JoystickButton(r_stick, M_UP);
        midDown = new JoystickButton(r_stick, M_DOWN);
        grab = new JoystickButton(r_stick, GRAB);
        leggo = new JoystickButton(r_stick, LEGGO);
        
        toggleUp = new JoystickButton(launchpad, T_TOGGLE);
        toggleMid = new JoystickButton(launchpad, M_TOGGLE);
        toggleGrab = new JoystickButton(launchpad, G_TOGGLE);
        check();
    }
    
    
    /******************************************************************
     * Listens to the joystick to determine when a button is pressed
     * if a button is pressed, call the respective command
     * @throws InterruptedException 
     ******************************************************************/
    private void check() {   
        mecDrive.whenPressed(new MecanumDrive());
        autoA.whenPressed(new DriveForward(10));
        //autoB.whenPressed(new BU());
        //autoC.whenPressed(new CU());
        upUp.whenPressed(new UpperUp());
        upDown.whenPressed(new UpperDown());
        rotate.whenPressed(new RotateFrame(true, 1));
        //off.whenPressed(new LightOff());
        //strobe.whenPressed(new Strobe());
        //zcont.whenPressed(new ZControl());
        
        midUp.whenPressed(new MidUp());
        midDown.whenPressed(new MidDown());
        grab.whenPressed(new Grab());
        leggo.whenPressed(new Release());
        
        toggleUp.whenPressed(new Switch(Robot.air.getTop(), T_INDICATOR));
        toggleMid.whenPressed(new Switch(Robot.air.getMid(), M_INDICATOR));
        toggleGrab.whenPressed(new Switch(Robot.air.getGrab(), G_INDICATOR));
    }
    
    
    /******************************************************************
     * Getter methods for the joysticks
     * Allows other classes to use value of joystick input
     ******************************************************************/
    public static FancyJoystick getDriveStick(){
        return d_stick;
    }
    
    public static FancyJoystick getRotateStick(){
        return r_stick;
    }
    
    public static Joystick getLaunchpad(){
    	return launchpad;
    }
	
}