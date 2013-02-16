/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems.drive.mecanum;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
        
        if (anyOutsideMax(frWheelSpeed, brWheelSpeed, flWheelSpeed, blWheelSpeed)){
            double coefficient = getScaleCoefficient(frWheelSpeed, brWheelSpeed, flWheelSpeed, blWheelSpeed);
            frWheelSpeed *= coefficient;
            brWheelSpeed *= coefficient;
            flWheelSpeed *= coefficient;
            blWheelSpeed *= coefficient;
        }
        
        SmartDashboard.putNumber("Front Right Wheel Speed", frWheelSpeed * -1.0);
        SmartDashboard.putNumber("Front Left Wheel Speed", flWheelSpeed * -1.0);
        SmartDashboard.putNumber("Back Right Wheel Speed", brWheelSpeed * -1.0);
        SmartDashboard.putNumber("Back Left Wheel Speed", blWheelSpeed * -1.0);
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

    private boolean anyOutsideMax(double frWheelSpeed, double brWheelSpeed, double flWheelSpeed, double blWheelSpeed) {
        return Math.abs(frWheelSpeed) > 1.0 || 
                Math.abs(brWheelSpeed) > 1.0 || 
                Math.abs(flWheelSpeed) > 1.0 || 
                Math.abs(blWheelSpeed) > 1.0;
    }

    private double getScaleCoefficient(double frWheelSpeed, double brWheelSpeed, double flWheelSpeed, double blWheelSpeed) {
        double maxRight = Math.max(Math.abs(frWheelSpeed), Math.abs(brWheelSpeed));
        double maxLeft = Math.max(Math.abs(flWheelSpeed), Math.abs(blWheelSpeed));
        double max = Math.max(maxRight, maxLeft);
        
        return 1.0 / max;
    }
}
