package org.usfirst.frc.team1160.robot.subsystems;

import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pistons extends Subsystem implements RobotMap{

    private static Pistons instance;
    private DoubleSolenoid middle, upperA, upperB, grabberA, grabberB;
    private Compressor comp;
    
    private Pistons(){
    	comp = new Compressor();
    	comp.start();
        middle = new DoubleSolenoid(MIDDLE_A, MIDDLE_B);
        upperA = new DoubleSolenoid(UPPER_A_A, UPPER_A_B);
        upperB = new DoubleSolenoid(UPPER_B_A, UPPER_B_B);
        grabberA = new DoubleSolenoid(GRABBER_A, GRABBER_B);
        grabberB = new DoubleSolenoid(GRABBER_A, GRABBER_B);
    }
    
    public static Pistons getInstance(){
        if(instance == null){
            instance = new Pistons();
        }
        return instance;
    }
    
    public void midUp(){
    	middle.set(RET);
    }
    
    public void midDown(){
    	middle.set(EXT);
    }
    
    public void topUp(){
    	upperA.set(RET);
    	upperB.set(RET);
    }
    
    public void topDown(){
    	upperA.set(EXT);
    	upperB.set(EXT);
    }
    
    public void grab(){
    	grabberA.set(EXT);
    	grabberB.set(EXT);
    }
    
    public void release(){
    	grabberA.set(RET);
    	grabberB.set(RET);
    }
    
    protected void initDefaultCommand() {
    	setDefaultCommand(null);
    }

}
