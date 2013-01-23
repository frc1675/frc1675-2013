/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands;

/**
 *
 * @author team1675
 */
public class PneumaticExtend extends CommandBase {
    
    public PneumaticExtend() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(pneumaticPistons);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        pneumaticPistons.extend();
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        pneumaticPistons.doNothing();
        
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        
        if (oi.pneumaticsExtendedSwitch.get()){
            return true;
            
        }
        
        return true;  //this is here so that in testing without switch it will work, remove once switch is added
    
    }
    // Called once after isFinished returns true
    protected void end() {
        execute();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
