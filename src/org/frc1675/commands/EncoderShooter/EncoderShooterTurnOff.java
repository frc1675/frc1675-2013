/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.EncoderShooter;

import edu.wpi.first.wpilibj.Timer;
import org.frc1675.RobotMap;
import org.frc1675.commands.CommandBase;

/**
 *
 * @author Tony
 */
public class EncoderShooterTurnOff extends CommandBase {

    public EncoderShooterTurnOff() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(encoderShooter);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
        encoderShooter.turnOff();

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

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
