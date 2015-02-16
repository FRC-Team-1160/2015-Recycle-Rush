package org.usfirst.frc.team1160.robot.subsystems;

import org.usfirst.frc.team1160.robot.OI;
import org.usfirst.frc.team1160.robot.RobotMap;
import org.usfirst.frc.team1160.robot.commands.LightOff;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;



public class Lights extends Subsystem implements RobotMap{
    
	private Talon control;
	private double set;
	private static Lights instance;
	
	
	private Lights(){
		control = new Talon(LIGHT_PORT);
		
	}
	
	public static Lights getInstance(){
		if(instance == null){
			instance = new Lights();
		}
		return instance;
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new LightOff());
    }
    
    public void off(){
    	control.set(0);
    }
    
    public void zControl(){
    	set = OI.getDriveStick().getZ();
    	if(set < 0)
    		control.set(-set);
    	else{
    		control.set(set);
    	}
    }
    
}

