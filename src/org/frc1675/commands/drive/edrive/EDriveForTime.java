/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.drive.edrive;

import edu.wpi.first.wpilibj.Timer;
import org.frc1675.commands.CommandBase;

/**
 *
 * @author josh
 */
public class EDriveForTime extends CommandBase {
    
    public static final double COMPENSATION_INDEX = 2.0;
    //This one allows the handbrake to be used.
    public static double compensationIndex = COMPENSATION_INDEX;
    
    private double time;
    private Timer timer;
    
    private double forward;
    private double turn;
    
    public EDriveForTime(double forward, double turn, double time) {
        requires(leftDrivePID);
        requires(rightDrivePID);
        this.forward = forward;
        this.turn = turn;
        this.time = time;
        timer = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        timer.reset();
        timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//        double forward = oi.getLeftVectorY();
//        double turn = -oi.getRightVectorX();
        
        double left;
        double right;
//        if(forward <= 0.0){
            left = forward + turn;
            right = forward - turn;
//        }
//        else{
//            left = forward - turn;
//            right = forward + turn;
//        }
        
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
        return timer.get() > time;
    }

    // Called once after isFinished returns true
    protected void end() {
        leftDrivePID.set(0);
        rightDrivePID.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
