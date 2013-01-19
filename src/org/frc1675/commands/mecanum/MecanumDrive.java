/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.mecanum;

import org.frc1675.commands.CommandBase;

/**
 *
 * @author ericmiller
 */
public class MecanumDrive extends CommandBase {

    public MecanumDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
   //     requires(simpleMecanumDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    //    simpleMecanumDrive.drive(oi.getMecanumMagnitude(), oi.getMecanumDirection(), oi.getMecanumRotation());
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
