/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.drive.mecanum;

import edu.wpi.first.wpilibj.Timer;
import org.frc1675.commands.CommandBase;

/**
 *
 * @author josh
 */
public class MecanumDrivePolarForTime extends CommandBase {
    
    private double magnitude;
    private double direction;
    private double rotation;
    private double time;
    private Timer timer;
    
    public MecanumDrivePolarForTime(double magnitude, double direction, double rotation, double time) {
        requires(simpleMecanumDrive);
        this.magnitude = magnitude;
        this.direction = direction;
        this.rotation = rotation;
        this.time = time;
        timer = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        timer.reset();
        timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        simpleMecanumDrive.drive(magnitude, direction, rotation);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get() > time;
    }

    // Called once after isFinished returns true
    protected void end() {
        simpleMecanumDrive.drive(0.0, 0.0, 0.0);
        timer.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        simpleMecanumDrive.drive(0.0, 0.0, 0.0);
        timer.stop();
    }
}
