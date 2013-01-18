/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.tank;

import org.frc1675.commands.CommandBase;

/**
 *
 * @author team1675
 */
public class GoStraight extends CommandBase {
    double setpoint = rightEncoderPID.turnInchesIntoTicks(12, 360);
    
    
    public GoStraight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires (rightEncoderPID);
        requires (leftEncoderPID);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
        rightEncoderPID.setSetpoint(setpoint);
        leftEncoderPID.setSetpoint(setpoint);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
