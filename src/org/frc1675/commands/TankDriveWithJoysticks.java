/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands;

import org.frc1675.RobotMap;

/**
 *
 * @author ericmiller
 */
public class TankDriveWithJoysticks extends CommandBase {
    
    public TankDriveWithJoysticks() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(leftDrivePID);
        requires(rightDrivePID);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double leftStick = oi.getLeftY();
        double rightStick = oi.getRightY();
        double leftMotor = leftDrivePID.get();
        double rightMotor = rightDrivePID.get();
        double leftSetting = 0;
        double rightSetting = 0;
        
        
        if(leftStick > leftMotor){
            leftSetting = leftStick + RobotMap.ACCELERATION_INCREMENT;
        }
        else{
            leftSetting = leftStick;
        }
        if(rightStick > rightMotor){
            rightSetting = rightStick + RobotMap.ACCELERATION_INCREMENT;
        }
        else{
            rightSetting = rightStick;
        }
        
        leftDrivePID.set(leftSetting);
        rightDrivePID.set(rightSetting);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
