/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.drive.edrive;

import org.frc1675.commands.CommandBase;

/**
 *
 * @author josh
 */
public class SlowRight extends CommandBase {
    
    public SlowRight() {
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
        leftDrivePID.set(-1.0/3.0);
        rightDrivePID.set(-1.0/3.0);
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
