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
    
    //this decides how much compensation is made for turning at high speeds.
    //The higher it is, the wider the turns. Should never be <= 1. 2 is good.
    public static final double COMPENSATION_INDEX = 2.0;
    //This one allows the handbrake to be used.
    public static double compensationIndex = COMPENSATION_INDEX;
    
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
        double forward = oi.getLeftVectorY();
        double turn = -oi.getRightVectorX();
        
        double left;
        double right;
        if(forward <= 0.0){
            left = forward + turn;
            right = forward - turn;
        }
        else{
            left = forward - turn;
            right = forward + turn;
        }
        
        //Compensation for overflow of forward + turn: Some sent to other side.
        if(left > 1.0){
            right -= (left - 1.0) / compensationIndex;
        } else if (left < -1.0) {
            right -= (left + 1.0) / compensationIndex;
        }

        if (right > 1.0) {
            left -= (right - 1.0) / compensationIndex;
        } else if (right < -1.0) {
            left -= (right + 1.0) / compensationIndex;
        }
        
        //Corrects for being over |1.0|
        if(Math.abs(left) > 1.0){
            left /= Math.abs(left);
        }
        if(Math.abs(right) > 1.0){
            right /= Math.abs(right);
        }
        
        
        leftDrivePID.set(left);
        rightDrivePID.set(-right);
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