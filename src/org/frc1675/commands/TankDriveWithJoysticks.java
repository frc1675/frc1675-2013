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
        double absoluteLeftStick = Math.abs(leftStick);
        double absoluteRightStick = Math.abs(rightStick);
        double absoluteLeftMotor = Math.abs(leftDrivePID.get());
        double absoluteRightMotor = Math.abs(rightDrivePID.get());
        double leftSetting;
        double rightSetting;
        boolean rightIsOutsideDeadZone;
        boolean leftIsOutsideDeadZone;
        
        if (absoluteLeftStick < RobotMap.DEADZONE_RADIUS){
            leftIsOutsideDeadZone = false;
        }else{
            leftIsOutsideDeadZone = true;
        }
        
        if (leftIsOutsideDeadZone){
            if(leftStick > absoluteLeftMotor && absoluteLeftMotor > RobotMap.DEADZONE_RADIUS + .05){
                leftSetting = absoluteLeftMotor + RobotMap.ACCELERATION_INCREMENT;
            }else{
                leftSetting = leftStick;
            }
        }else{
            leftSetting = 0;
        }        
        if (leftStick <= -RobotMap.DEADZONE_RADIUS){
            leftSetting = -leftSetting;
        }
        leftDrivePID.set(leftSetting);
        
        
        if (absoluteRightStick < RobotMap.DEADZONE_RADIUS){
            rightIsOutsideDeadZone = false;
        }else{
            rightIsOutsideDeadZone = true;
        }     
        if (rightIsOutsideDeadZone && absoluteRightMotor > RobotMap.DEADZONE_RADIUS + .05){
            if(rightStick > absoluteRightMotor){
                rightSetting = absoluteRightMotor + RobotMap.ACCELERATION_INCREMENT;
            }else{
                rightSetting = rightStick;
            }
        }else{
            rightSetting = 0;
        }
        if (rightStick<= -RobotMap.DEADZONE_RADIUS){
            rightSetting = -rightSetting;
        }
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
