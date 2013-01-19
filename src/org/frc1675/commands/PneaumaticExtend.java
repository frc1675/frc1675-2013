/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands;

/**
 *
 * @author team1675
 */
public class PneaumaticExtend extends CommandBase {
    
    public PneaumaticExtend() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(pneaumaticPistons);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        pneaumaticPistons.extend();
        
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
