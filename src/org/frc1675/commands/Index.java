/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands;

import edu.wpi.first.wpilibj.Timer;
import org.frc1675.RobotMap;

/**
 *
 * @author jstano
 */
public class Index extends CommandBase {
    Timer timer;
    public Index() {
        requires(indexer);
        timer = new Timer();
        
        
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        timer.start();
        indexer.extend();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get() >= (RobotMap.INDEX_TIME);
    }

    // Called once after isFinished returns true
    protected void end() {
        indexer.retract();
        timer.reset();
        timer.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
        indexer.retract();
    }
}
