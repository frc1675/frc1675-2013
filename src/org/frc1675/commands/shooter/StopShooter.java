/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.shooter;

import org.frc1675.commands.CommandBase;

/**
 *
 * @author josh
 */
public class StopShooter extends CommandBase {
    
    public StopShooter() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        shooter.stopShooter();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
