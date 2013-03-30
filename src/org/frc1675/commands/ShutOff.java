/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author josh
 */
public class ShutOff extends CommandBase {
    
    private Timer timer;
    
    public ShutOff() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(shooter);
        timer = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        shooter.shutOff();
        timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(timer.get() > 0.25){
            return true;
        } else {
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
