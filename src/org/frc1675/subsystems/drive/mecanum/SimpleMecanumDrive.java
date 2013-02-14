/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems.drive.mecanum;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.frc1675.RobotMap;
import org.frc1675.commands.drive.mecanum.MecanumDrive;
import org.frc1675.subsystems.drive.DriveSideWrapper;

/**
 *
 * @author ericmiller
 */
public class SimpleMecanumDrive extends Subsystem {

    private DriveSideWrapper motorLeftSide;
    private DriveSideWrapper motorRightSide;   
    
    private Timer rampTimer;
    
    public SimpleMecanumDrive(DriveSideWrapper leftSide, DriveSideWrapper rightSide){
        motorLeftSide = leftSide;
        motorRightSide = rightSide;
        rampTimer = new Timer();
        rampTimer.start();
    }
    
    public void drive(double magnitude, double direction, double rotation){
        if(magnitude == 0.0){
            rampTimer.reset(); //get ready to ramp
        } else if (rampTimer.get() < RobotMap.TANK_RAMP_TIME) {
            magnitude = magnitude * (rampTimer.get() / RobotMap.TANK_RAMP_TIME);
        }
        
        
        
        double dirInRad = direction + (Math.PI/4);
        
        double sinD = Math.sin(dirInRad);
        double cosD = Math.cos(dirInRad);
        
        double frWheelSpeed = cosD * magnitude + rotation;
        double brWheelSpeed = sinD * magnitude + rotation;
        double flWheelSpeed = sinD * magnitude - rotation;
        double blWheelSpeed = cosD * magnitude - rotation;
        
        motorLeftSide.setBack(blWheelSpeed * -1.0);
        motorLeftSide.setFront(flWheelSpeed * -1.0);
        motorRightSide.setFront(frWheelSpeed * -1.0);
        motorRightSide.setBack(brWheelSpeed * -1.0);
        /*f = front
        * b = back
        * l = left
        * r = right */
        

    }

    public void initDefaultCommand() {
        setDefaultCommand(new MecanumDrive());
    }
}
