package org.usfirst.frc.team1160.robot.subsystems;

import org.usfirst.frc.team1160.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.vision.AxisCamera;

public class Vision extends Subsystem implements RobotMap{

    private static Vision instance;
    private static AxisCamera cam;
    private ColorImage image;
    private BinaryImage bImage;
    
    private Vision(){
        cam = new AxisCamera(CAM_ADDRESS);
    }
    
    public static Vision getInstance(){
        if(instance == null){
            instance = new Vision();
        }
        return instance;
    }
    
    protected void initDefaultCommand() {
        setDefaultCommand(null);
    }
    
    public boolean checkPos() throws NIVisionException{
        if(!cam.isFreshImage())
            image = cam.getImage();
        bImage = image.thresholdRGB(R_LOW, R_HIGH, G_LOW, G_HIGH, B_LOW, B_HIGH);
        
        return false;
    }
    
    
}
