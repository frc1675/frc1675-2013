/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands;

/**
 *
 * @author team1675
 */
public class CompressorWork extends CommandBase {
    
    public CompressorWork() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(compressor);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("compressor work initialized");
        compressor.init();

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        compressor.work();
//        System.out.println("working");
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
