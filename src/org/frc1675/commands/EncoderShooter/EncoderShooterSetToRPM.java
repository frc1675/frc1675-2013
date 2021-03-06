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
public class EncoderShooterSetToRPM extends CommandBase {
     Timer timer;
     double rpm;
    public EncoderShooterSetToRPM(double rpm) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(encoderShooter);
        timer = new Timer();
        this.rpm = rpm; 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        encoderShooter.goToRPM(rpm);
        timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        encoderShooter.execute();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (timer.get()>RobotMap.BUTTON_COOLDOWN){
        return true;
        }
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
