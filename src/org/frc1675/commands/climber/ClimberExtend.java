/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.climber;

import edu.wpi.first.wpilibj.Timer;
import org.frc1675.RobotMap;
import org.frc1675.commands.CommandBase;

/**
 *
 * @author Tony Stano
 */
public class ClimberExtend extends CommandBase {
    
    Timer timer;
    
    public ClimberExtend() {
        requires(climber);
        timer = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        climber.extend();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(timer.get() > RobotMap.SOLENOID_ACTIVE_TIME){
            return true;
        }
        return false;
    }
    
    // Called once after isFinished returns true
    protected void end() {
        climber.doNothing();
        timer.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
