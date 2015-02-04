/*package org.usfirst.frc.team1160.robot.subsystems;

import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Pistons extends Subsystem implements RobotMap{

    private static Pistons instance;
    private DoubleSolenoid one;
    
    private Pistons(){
        one = new DoubleSolenoid(PN_SOL_A, PN_SOL_B);
    }
    
    public static Pistons getInstance(){
        if(instance == null){
            instance = new Pistons();
        }
        return instance;
    }
    
    protected void initDefaultCommand() {
    }
    
    public void out(){
        one.set(DoubleSolenoid.Value.kForward);
    }
    
    public void in(){
        one.set(DoubleSolenoid.Value.kReverse);
    }

}*/
