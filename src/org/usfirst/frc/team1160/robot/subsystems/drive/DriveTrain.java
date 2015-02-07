package org.usfirst.frc.team1160.robot.subsystems.drive;

import org.usfirst.frc.team1160.robot.OI;
import org.usfirst.frc.team1160.robot.Robot;
import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.commands.drive.MecanumDrive;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem implements RobotMap{
    
    private static DriveTrain instance;
    protected final Talon fl, fr, bl, br;
    protected final Encoder flEnc, frEnc, blEnc, brEnc;
    private double maxV, maxE, flT, frT, blT, brT;
    public PID flP, frP, brP, blP;
    

    //Assigning each talon a port
    private DriveTrain() {
        fl = new Talon(DT_MOTOR_FL);
        fr = new Talon(DT_MOTOR_FR);
        bl = new Talon(DT_MOTOR_BL);
        br = new Talon(DT_MOTOR_BR);
        flEnc = new Encoder(PID_ENCODER_FL_A, PID_ENCODER_FL_B, true, EncodingType.k2X);
        frEnc = new Encoder(PID_ENCODER_FR_A, PID_ENCODER_FR_B, true, EncodingType.k2X);
        blEnc = new Encoder(PID_ENCODER_BL_A, PID_ENCODER_BL_B, false, EncodingType.k2X);
        brEnc = new Encoder(PID_ENCODER_BR_A, PID_ENCODER_BR_B, true, EncodingType.k2X);
        flP = new PID("FrontLeft", P, I, D, fl, flEnc);
        frP = new PID("FrontRight", P, I, D, fr, frEnc);
        blP = new PID("BackLeft", P, I, D, bl, blEnc);
        brP = new PID("BackRight", P, I, D, br, brEnc);
    }

    //Ensures the port assignment above happens only once
    public static DriveTrain getInstance() {
        if (instance == null) {
            instance = new DriveTrain();
        }
        return instance;
    }

    //Drive Code for mecanum wheels
    //http://thinktank.wpi.edu/resources/346/ControllingMecanumDrive.pdf
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
        //System.out.println("frontleft set to: " + -flT + " \nfrontright set to: " + frT + " \nbackleft set to: " + -blT + " \nbackright set to: " + brT);
        fl.set(-flT);
        fr.set(frT);
        bl.set(-blT);
        br.set(brT);
        
        System.out.println(flP.getName() + ": reads: " + flP.enc.pidGet());
        System.out.println(frP.getName() + ": reads: " + frP.enc.pidGet());
        System.out.println(blP.getName() + ": reads: " + blP.enc.pidGet());
        System.out.println(brP.getName() + ": reads: " + brP.enc.pidGet());
        
    }
    
    public boolean itDone(){
    	return flP.finished();
    }
    
    public void reset(){
    	flP.getPIDController().disable();
    	frP.getPIDController().disable();
    	blP.getPIDController().disable();
    	brP.getPIDController().disable();
    }
    
    public void enable(){
    	blP.enable();
    	System.out.println(blP.getName() + ": ENABLED");
    	brP.enable();
    	System.out.println(brP.getName() + ": ENABLED");
    	flP.enable();
    	System.out.println(flP.getName() + ": ENABLED");
    	frP.enable();
    	System.out.println(frP.getName() + ": ENABLED");
    }
    
    public void forward(double distance){
    	flP.setSetpoint(-distance);
    	frP.setSetpoint(distance);
    	blP.setSetpoint(-distance);
    	brP.setSetpoint(distance);
    }

    //Sets the default command
    protected void initDefaultCommand() {
        setDefaultCommand(new MecanumDrive());
    }
}

