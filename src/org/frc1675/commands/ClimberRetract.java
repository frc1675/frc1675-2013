/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Tony Stano
 */
public class ClimberRetract extends CommandBase {
    
    Timer timer;
    
    public ClimberRetract() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(pneumaticPistons);
        timer = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//        pneumaticPistons.retract();
        timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        pneumaticPistons.retract();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//        if (oi.pneumaticsRetractedSwitch.get()){
//            return true;
//        }
        
        if(timer.get() > 0.25){
            return true;
        }
        
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        pneumaticPistons.doNothing();
        timer.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
