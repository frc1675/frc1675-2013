/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.dumper;

import edu.wpi.first.wpilibj.Timer;
import org.frc1675.RobotMap;
import org.frc1675.commands.CommandBase;

/**
 *
 * @author josh
 */
public class DumperDump extends CommandBase {
    
    Timer timer;
    
    public DumperDump() {
        requires(dumper);
        timer = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        dumper.dump();
        lights.sendVal(RobotMap.LIGHTS_SPAZZ_OUT);
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
        dumper.doNothing();
        timer.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
