/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.drive.tank;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.frc1675.commands.CommandBase;

/**
 *
 * @author TonyStano
 */
public class GoToAngle extends CommandBase {
    //goes to an angle relative to where the robot is when command was called
    public double angle;    
    public GoToAngle(double angle) {
        // Use requires() here to declare subsystem dependenci es
        // eg. requires(chassis); 
        requires(gyroPID);
        requires(leftDrivePID);
        requires(rightDrivePID);
        this.angle = angle;
//        this.setTimeout();
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
        SmartDashboard.putNumber("Gyro PID output", pidOutput);
        SmartDashboard.putNumber("Gyroscope angle", gyroPID.getAngle());
        
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
