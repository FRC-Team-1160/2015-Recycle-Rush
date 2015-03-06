package org.usfirst.frc.team1160.robot.subsystems.drive;

import org.usfirst.frc.team1160.robot.OI;
import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.commands.drive.MecanumDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem implements RobotMap{
    
    private static DriveTrain instance;
    protected final Talon fl, fr, bl, br;
    protected final Encoder flEnc, frEnc, blEnc, brEnc;
    private double maxV, flT, frT, blT, brT;
    public PID flP, frP, brP, blP;
    private Timer timer;
    
    
    /******************************************************************
     * Constructor for the DriveTrain Subsystem
     * -Talons/Encoders are assigned ports and initialized
     * -New instances of the PID class are created
     * -Values for Proportional and Derivative are given to SmartDash
     ******************************************************************/
    private DriveTrain() {
    	SmartDashboard.putNumber("kP", P);
    	SmartDashboard.putNumber("kD", D);
        fl = new Talon(DT_MOTOR_FL);
        fr = new Talon(DT_MOTOR_FR);
        bl = new Talon(DT_MOTOR_BL);
        br = new Talon(DT_MOTOR_BR);
        flEnc = new Encoder(PID_ENCODER_FL_A, PID_ENCODER_FL_B, true);
        frEnc = new Encoder(PID_ENCODER_FR_A, PID_ENCODER_FR_B, true);
        blEnc = new Encoder(PID_ENCODER_BL_A, PID_ENCODER_BL_B, true);
        brEnc = new Encoder(PID_ENCODER_BR_A, PID_ENCODER_BR_B, true);
        flP = new PID("FrontLeft", fl, flEnc);
        frP = new PID("FrontRight", fr, frEnc);
        blP = new PID("BackLeft", bl, blEnc);
        brP = new PID("BackRight", br, brEnc);
        brP.setOutputRange(OUT_RANGE_L, OUT_RANGE_H);
        blP.setOutputRange(OUT_RANGE_L, OUT_RANGE_H);
        flP.setOutputRange(OUT_RANGE_L, OUT_RANGE_H);
        frP.setOutputRange(OUT_RANGE_L, OUT_RANGE_H);
        timer = new Timer();
    }

    
    /******************************************************************
     * Singleton for DriveTrain constructor
     * -Prevents constructor from running more than once
     * ->If constructor runs more than once, ports are assigned that 
     *   already have a spot, which results in an error upon building
     ******************************************************************/
    public static DriveTrain getInstance() {
        if (instance == null) {
            instance = new DriveTrain();
        }
        return instance;
    }

    
    /******************************************************************
     * Drive Code for mecanum wheels
     * Calculates direction wheels need to turn from joystick input
     * See documentation for explanation on math
     * http://thinktank.wpi.edu/resources/346/ControllingMecanumDrive.pdf
     ******************************************************************/
    public void mecanumDrive() {
        flT = OI.getDriveStick().getMagnitude() * Math.sin(OI.getDriveStick().getDirectionRadians() + (Math.PI / 4)) + OI.getRotateStick().getX();
        frT = OI.getDriveStick().getMagnitude() * Math.cos(OI.getDriveStick().getDirectionRadians() + (Math.PI / 4)) - OI.getRotateStick().getX();
        blT = OI.getDriveStick().getMagnitude() * Math.cos(OI.getDriveStick().getDirectionRadians() + (Math.PI / 4)) + OI.getRotateStick().getX();
        brT = OI.getDriveStick().getMagnitude() * Math.sin(OI.getDriveStick().getDirectionRadians() + (Math.PI / 4)) - OI.getRotateStick().getX();
        
        maxV = Math.max(
        		Math.max(Math.abs(flT), Math.abs(frT)), 
        		Math.max(Math.abs(blT), Math.abs(brT)));
        
        if(maxV>1){
        	flT = flT / maxV;
        	frT = frT / maxV;
        	blT = blT / maxV;
        	brT = brT / maxV;
        }
        
        fl.set(-flT);
        fr.set(frT);
        bl.set(-blT);
        br.set(brT);
        
        flP.logEncoder();
        frP.logEncoder();
        blP.logEncoder();
        brP.logEncoder();
    }
    
    
    /******************************************************************
     * Used with drive commands
     * When all 4 wheels have reached the set distance, it returns true
     * Important for the isFinished() method in commands
     ******************************************************************/
    public boolean itDone(){
    	return (flP.finished() && frP.finished() && blP.finished() && brP.finished());
    }
    
    
    /******************************************************************
     * Resets the PID Subsystems for the wheels
     * -First by calling getPIDSubsystem().reset(), which eliminates
     *  P, I, D, and Error values associated with the system
     * -Then by reassigning the P, I, and D values to the system
     * -This ensures that whenever a setpoint is assigned, the wheel
     *  starts from position 0, rather than the last position
     ******************************************************************/
    public void reset(){
    	flP.reInit();
    	frP.reInit();
    	blP.reInit();
    	brP.reInit();
    }
    
    
    /******************************************************************
     * Enables the PID Subsystem again
     * -When enabled, the system moves the wheels to desired setpoint
     * -If always on, the system constantly tries to move to desired
     *  spot, leading to jittering of the wheels
     ******************************************************************/
    public void enable(){
    	blP.enable();
    	brP.enable();
    	flP.enable();
    	frP.enable();
    }
    
    public boolean waitForComplete(double milli){
    	timer.start();
    	timer.reset();
    	while(timer.get() <= milli)
    		return false;
    	return true;
    }
    
    
    /******************************************************************
     * Each Subsystem is required to have a method that designates
     * the default command when the subsystem is created
     * The default command is what the subsystem refers back to in case
     * of an unexpected error with a different command, and is also
     * the first command called
     ******************************************************************/
    protected void initDefaultCommand() {
        setDefaultCommand(new MecanumDrive());
    }
    
    
    /******************************************************************
     * The following methods are used in movement commands
     * -setSetpoint(distance) informs the PIDSubystem how far it needs
     *  to move
     * -negated values are to change direction of motor spin
     ******************************************************************/
    public void rotateFrame(boolean half, int direction){
    	if(half){
    		flP.setSetpoint(FL_180 * direction);
    		frP.setSetpoint(FR_180 * direction);
    		blP.setSetpoint(BL_180 * direction);
    		brP.setSetpoint(BR_180 * direction);
    	}else{
    		flP.setSetpoint((FL_180/2) * direction);
    		frP.setSetpoint((FR_180/2) * direction);
    		blP.setSetpoint((BL_180/2) * direction);
    		brP.setSetpoint((BR_180/2) * direction);
    	}
    }
    
    public void forward(double distance){
    	flP.setSetpoint(-distance);
    	frP.setSetpoint(distance);
    	blP.setSetpoint(-distance);
    	brP.setSetpoint(distance);
    }
    
    public void right(double distance){
    	flP.setSetpoint(-distance);
    	frP.setSetpoint(-distance);
    	blP.setSetpoint(distance);
    	brP.setSetpoint(distance);
    }
    
    public void diagFL(double distance){
    	frP.setSetpoint(distance);
    	blP.setSetpoint(-distance);
    }
    
    public void diagFR(double distance){
    	flP.setSetpoint(-distance);
    	brP.setSetpoint(distance);
    }
    
}

