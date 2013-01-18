/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.tank;

import edu.wpi.first.wpilibj.Timer;
import org.frc1675.commands.CommandBase;

/**
 *
 * @author team1675
 */
public class DriveForTime extends CommandBase {

    private Timer driveTimer;
    private double stopTime;

    public DriveForTime(double time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(simpleTankDrive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        driveTimer = new Timer();
        driveTimer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        simpleTankDrive.setLeftSpeed(0.5);
        simpleTankDrive.setRightSpeed(0.5);

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (driveTimer.get() < stopTime) {
            return false;
        } else {
            return true;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        driveTimer.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        driveTimer.stop();
    }
}
