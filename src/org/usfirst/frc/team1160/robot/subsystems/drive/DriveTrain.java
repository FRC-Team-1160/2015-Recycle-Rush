package org.usfirst.frc.team1160.robot.subsystems.drive;

import org.usfirst.frc.team1160.robot.OI;
import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.commands.drive.MecanumDrive;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;


/**
 *
 */
public abstract class DriveTrain extends PIDSubsystem implements RobotMap{
    
    protected Encoder ebl, ebr, efl, efr;
    private double maxV, maxE, flT, frT, blT, brT;
    protected Talon fl, fr, bl, br;

    protected DriveTrain(String name, double p, double i, double d) {
        super(name, p, i, d);
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
        
        PID_FL.getInstance().fl.set(-flT);
        PID_FR.getInstance().fr.set(frT);
        PID_BL.getInstance().bl.set(-blT);
        PID_BR.getInstance().br.set(brT);
        
        System.out.println("FR is : " + PID_FR.getInstance().getPosition());
        System.out.println("FL is : " + PID_FL.getInstance().getPosition());
        System.out.println("BR is : " + PID_BR.getInstance().getPosition());
        System.out.println("BL is : " + PID_BL.getInstance().getPosition());
        System.out.println();
    }

    //Sets the default command
  	 public void initDefaultCommand(){	
  		 setDefaultCommand(new MecanumDrive());
  	 }
  	 
  	 public boolean finished(){
  		maxE = Math.max(
        		Math.max(Math.abs(PID_FL.getInstance().getPIDController().getError()), Math.abs(PID_BL.getInstance().getPIDController().getError())), 
        		Math.max(Math.abs(PID_FR.getInstance().getPIDController().getError()), Math.abs(PID_BR.getInstance().getPIDController().getError())));
  		return maxE < 5;
  	 }
  	 
  	 public void resetPID(){
  		PID_FL.getInstance().getPIDController().reset();
  		PID_BL.getInstance().getPIDController().reset();
  		PID_FR.getInstance().getPIDController().reset();
  		PID_BR.getInstance().getPIDController().reset();
  	 }
  	 
  	 public void forward(double distance){
  		PID_BL.getInstance().setSetpoint(distance);
  		PID_BR.getInstance().setSetpoint(distance);
  		PID_FL.getInstance().setSetpoint(distance);
  		PID_FR.getInstance().setSetpoint(distance);
  	 }
  	 
  	 public void right(double distance){
   		PID_BL.getInstance().setSetpoint(-distance);
   		PID_BR.getInstance().setSetpoint(distance);
   		PID_FL.getInstance().setSetpoint(distance);
   		PID_FR.getInstance().setSetpoint(-distance);
  	 }
  	 
  	 public void left(double distance){
   		PID_BL.getInstance().setSetpoint(distance);
   		PID_BR.getInstance().setSetpoint(-distance);
   		PID_FL.getInstance().setSetpoint(-distance);
   		PID_FR.getInstance().setSetpoint(distance);
  	 }
  	 
  	 public void backward(double distance){
   		PID_BL.getInstance().setSetpoint(-distance);
   		PID_BR.getInstance().setSetpoint(-distance);
   		PID_FL.getInstance().setSetpoint(-distance);
   		PID_FR.getInstance().setSetpoint(-distance);
  	 }
     
}

