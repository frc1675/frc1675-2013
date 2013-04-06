/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands;

/**
 *
 * @author Tony Stano
 */
public class CompressorWork extends CommandBase {
    
    public CompressorWork() {
        requires(compressor);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
        compressor.init();

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        compressor.work();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        compressor.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        compressor.stop();
    }
}
