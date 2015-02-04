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
    private static double maxV, maxE, flT, frT, blT, brT;
    protected static Talon fl, fr, bl, br;
    protected static PID_BL pbl;
    protected static PID_BR pbr;
    protected static PID_FL pfl;
    protected static PID_FR pfr;

    protected DriveTrain(String name, double p, double i, double d) {
        super(name, p, i, d);
    }
    
    public static void startAll(){
        if (pbl == null)
        	pbl = new PID_BL();
        if (pbr == null)
        	pbr = new PID_BR();
        if (pfl == null)	
        	pfl = new PID_FL();
        if(pfr == null)
        	pfr = new PID_FR();
    }

    //Drive Code for mecanum wheels
    //http://thinktank.wpi.edu/resources/346/ControllingMecanumDrive.pdf
    @SuppressWarnings("static-access")
	public static void mecanumDrive() {
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
        
        pfl.fl.set(-flT);
        pfr.fr.set(frT);
        pbl.bl.set(-blT);
        pbr.br.set(brT);
        
        System.out.println("FR is : " + pfr.getPIDController().get());
        System.out.println("FL is : " + pfl.getPIDController().get());
        System.out.println("BR is : " + pbr.getPIDController().get());
        System.out.println("BL is : " + pbl.getPIDController().get());
        System.out.println();
    }

    //Sets the default command
  	 public void initDefaultCommand(){	
  		 setDefaultCommand(new MecanumDrive());
  	 }
  	 
  	 public static boolean finished(){
  		maxE = Math.max(
        		Math.max(Math.abs(pfl.getPIDController().getError()), Math.abs(pfr.getPIDController().getError())), 
        		Math.max(Math.abs(pbl.getPIDController().getError()), Math.abs(pbr.getPIDController().getError())));
  		return maxE < 10;
  	 }
  	 
  	 public static void resetPID(){
  		pbl.getPIDController().reset();
  		pfl.getPIDController().reset();
  		pbr.getPIDController().reset();
  		pfr.getPIDController().reset();
  	 }
  	 
  	 public static void forward(double distance){
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

