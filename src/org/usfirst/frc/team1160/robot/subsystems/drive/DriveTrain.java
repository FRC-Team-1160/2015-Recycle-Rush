package org.usfirst.frc.team1160.robot.subsystems.drive;

import org.usfirst.frc.team1160.robot.OI;
import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.commands.MecanumDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;


/**
 *
 */
public abstract class DriveTrain extends PIDSubsystem implements RobotMap{
    
    protected Encoder ebl, ebr, efl, efr;
    private double maxV, flT, frT, blT, brT;
    protected Talon fl, fr, bl, br;
    protected PID_BL pbl;
    protected PID_BR pbr;
    protected PID_FL pfl;
    protected PID_FR pfr;

    protected DriveTrain(String name, double p, double i, double d) {
        super(name, p, i, d);
        pbl = new PID_BL();
        pbr = new PID_BR();
        pfl = new PID_FL();
        pfr = new PID_FR();
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
        
        fl.set(-flT);
        fr.set(frT);
        bl.set(-blT);
        br.set(brT);
    }

    //Sets the default command
  	 public void initDefaultCommand(){	
  		 setDefaultCommand(new MecanumDrive());
  	 }
  	 
  	 public void forward(double distance){
  		pbl.setSetpoint(distance);
  		pbr.setSetpoint(distance);
  		pfl.setSetpoint(distance);
  		pfr.setSetpoint(distance);
  	 }
  	 
  	 public void right(double distance){
   		pbl.setSetpoint(-distance);
   		pbr.setSetpoint(distance);
   		pfl.setSetpoint(distance);
   		pfr.setSetpoint(-distance);
  	 }
  	 
  	 public void left(double distance){
   		pbl.setSetpoint(distance);
   		pbr.setSetpoint(-distance);
   		pfl.setSetpoint(-distance);
   		pfr.setSetpoint(distance);
  	 }
  	 
  	 public void backward(double distance){
   		pbl.setSetpoint(-distance);
   		pbr.setSetpoint(-distance);
   		pfl.setSetpoint(-distance);
   		pfr.setSetpoint(-distance);
  	 }
     
}

