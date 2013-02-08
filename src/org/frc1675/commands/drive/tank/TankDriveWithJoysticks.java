    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.drive.tank;

import edu.wpi.first.wpilibj.command.Command;
import org.frc1675.RobotMap;
import org.frc1675.commands.CommandBase;

/**
 *
 * @author ericmiller
 */
public class TankDriveWithJoysticks extends CommandBase {
    
    public TankDriveWithJoysticks() {
        requires(leftDrivePID);
        requires(rightDrivePID);
        
    }
   
    // Called just before this Command runs the first time
    protected void initialize() {        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {        
        leftDrivePID.set(oi.getLeftTankCommand());
        rightDrivePID.set(oi.getRightTankCommand());
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
