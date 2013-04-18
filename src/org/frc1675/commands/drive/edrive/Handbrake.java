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
public class Handbrake extends CommandBase {
    
    public Handbrake() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        EDriveWithJoysticks.compensationIndex = 1.5;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        EDriveWithJoysticks.compensationIndex = EDriveWithJoysticks.COMPENSATION_INDEX;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        EDriveWithJoysticks.compensationIndex = EDriveWithJoysticks.COMPENSATION_INDEX;
    }
}
