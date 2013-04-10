/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.drive.edrive;

import org.frc1675.commands.CommandBase;

/**
 *
 * @author ericmiller
 */
public class EDriveWithJoysticks extends CommandBase {
    
    public EDriveWithJoysticks() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(leftDrivePID);
        requires(rightDrivePID);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute(){
        double turn = -oi.getLeftVectorY();
        double forward = -oi.getRightVectorX();
        
        double left;
        double right;
        if(forward <= 0.0){
            left = forward - turn;
            right = (forward + turn);
        }
        else{
            left = forward + turn;
            right = (forward - turn);
        }
        
        if(Math.abs(left) > 1.0){
            left /= Math.abs(left);
        }
        if(Math.abs(right) > 1.0){
            right /= Math.abs(right);
        }
        
        
        leftDrivePID.set(left);
        rightDrivePID.set(right);
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

/*
 * public void eDrive(double forward, double turn){
        double left;
        double right;
        if(forward <= 0.0){
            left = forward - turn;
            right = forward + turn;
        }
        else{
            left = forward + turn;
            right = forward - turn;
        }
        
        if(Math.abs(left) > 1.0){
            left /= Math.abs(left);
        }
        if(Math.abs(right) > 1.0){
            right /= Math.abs(right);
        }
        
        
        motorL.set(left);
        motorR.set(right);
    }
 */
