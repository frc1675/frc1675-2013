/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.drive.tank;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.frc1675.commands.CommandBase;

/**
 * Goes to an angle relative to where the robot is when command was called
 * @author TonyStano
 */
public class GoToAngle extends CommandBase {
    public double angle;    
    public GoToAngle(double angle) {
        requires(gyroPID);
        requires(leftDrivePID);
        requires(rightDrivePID);
        this.angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        gyroPID.reset();
        gyroPID.setSetpoint(angle);
        gyroPID.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double pidOutput = gyroPID.getPIDOutput();
        leftDrivePID.set(pidOutput);
        rightDrivePID.set(-pidOutput); //there is a negative there
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//        return this.isTimedOut();
        double rightPosition = gyroPID.getPosition();      
        double changeInPosition = rightPosition - angle;        
        return (Math.abs(changeInPosition) <= .025 * angle);
    }

    // Called once after isFinished returns true
    protected void end() {
        gyroPID.disable();
        leftDrivePID.set(0.0);
        rightDrivePID.set(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
