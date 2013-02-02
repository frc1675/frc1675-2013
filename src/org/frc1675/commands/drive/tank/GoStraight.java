/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.drive.tank;

import org.frc1675.commands.CommandBase;

/**
 *
 * @author team1675
 */
public class GoStraight extends CommandBase {
    double setpoint = 0;
    
    
    public GoStraight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires (rightDrivePID);
        requires (leftDrivePID);
        
        setpoint = rightDrivePID.turnInchesIntoTicks(12, 360);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
        rightDrivePID.setSetpoint(3600);
        leftDrivePID.setSetpoint(3600);
        
        rightDrivePID.enable();
        leftDrivePID.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("PID'ing: left = " + leftDrivePID.getPIDController().get() + " right = " + rightDrivePID.getPIDController().get());
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        double rightPosition = rightDrivePID.getPosition();
        double leftPosition = leftDrivePID.getPosition();
        
        double changeInPosition = rightPosition + leftPosition - (2 * setpoint);
        
        
        return (changeInPosition == 0 * setpoint);

    }

    // Called once after isFinished returns true
    protected void end() {
        rightDrivePID.disable();
        leftDrivePID.disable();
        rightDrivePID.resetEncoder();
        leftDrivePID.resetEncoder();

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
