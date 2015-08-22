package org.usfirst.frc.team1160.robot;

import edu.wpi.first.wpilibj.Joystick;

public class FancyJoystick extends Joystick {

	public FancyJoystick(int port) {
		super(port);
		// TODO Auto-generated constructor stub
	}
	
	public double getFancyX(){
		return Math.pow(super.getX(), 3);
	}
	
	public double getFancyMagnitude(){
		return (Math.pow(super.getMagnitude(), 3)*3);
	}
	
	
}
