package org.usfirst.frc.team1160.robot.subsystems;

import org.usfirst.frc.team1160.robot.OI;
import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pistons extends Subsystem implements RobotMap{

    private static Pistons instance;
    private DoubleSolenoid middle, upperA, grabberA;
    private Compressor comp;
    
    
    /******************************************************************
     * Constructor for the DriveTrain Subsystem
     * -Compressor/Solenoids are assigned ports and initialized
     ******************************************************************/
    private Pistons(){
    	comp = new Compressor();
    	comp.start();
        middle = new DoubleSolenoid(MIDDLE_A, MIDDLE_B);
        upperA = new DoubleSolenoid(UPPER_A_A, UPPER_A_B);
        grabberA = new DoubleSolenoid(GRABBER_A, GRABBER_B);
    }
    
    
    /******************************************************************
     * Singleton for Pistons constructor
     * -Prevents constructor from running more than once
     * ->If constructor runs more than once, ports are assigned that 
     *   already have a spot, which results in an error upon building
     ******************************************************************/
    public static Pistons getInstance(){
        if(instance == null){
            instance = new Pistons();
        }
        return instance;
    }
    
    
    /******************************************************************
     * Each Subsystem is required to have a method that designates
     * the default command when the subsystem is created
     * The default command is what the subsystem refers back to in case
     * of an unexpected error with a different command, and is also
     * the first command called
     * Pistons are always single actuation, so there is no need for
     * a command to default back to/start with
     ******************************************************************/
    protected void initDefaultCommand() {
    	setDefaultCommand(null);
    }
    
    
    /******************************************************************
     * The following methods are used in commands
     * Solenoids are either set to EXT or RET (extend or retract)
     * these values correspond to RobotMap variables
     ******************************************************************/
    public void midUp(){
    	middle.set(RET);
    	OI.getLaunchpad().setOutput(M_INDICATOR, false);
    }
    
    public void midDown(){
    	middle.set(EXT);
    	OI.getLaunchpad().setOutput(M_INDICATOR, true);
    }
    
    public void topUp(){
    	upperA.set(RET);
    	OI.getLaunchpad().setOutput(T_INDICATOR, false);
    }
    
    public void topDown(){
    	upperA.set(EXT);
    	OI.getLaunchpad().setOutput(T_INDICATOR, true);
    }
    
    public void grab(){
    	grabberA.set(EXT);
    	OI.getLaunchpad().setOutput(G_INDICATOR, false);
    }
    
    public void release(){
    	grabberA.set(RET);
    	OI.getLaunchpad().setOutput(G_INDICATOR, true);
    }
    
    public void toggler(DoubleSolenoid sol, int light){
    	if(sol.get() == EXT){
    		sol.set(RET);
    		OI.getLaunchpad().setOutput(light, true);
    	}
    	else{
    		sol.set(EXT);
        	OI.getLaunchpad().setOutput(light, false);
    	}
    }
    
    public DoubleSolenoid getTop(){
    	return upperA;
    }
    
    public DoubleSolenoid getMid(){
    	return middle;
    }
    
    public DoubleSolenoid getGrab(){
    	return grabberA;
    }


}
