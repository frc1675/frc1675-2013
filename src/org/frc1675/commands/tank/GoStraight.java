/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands.tank;

import org.frc1675.commands.CommandBase;

/**
 *
 * @author team1675
 */
public class GoStraight extends CommandBase {
    double setpoint = 0;
    
    
    public GoStraight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    //    requires (rightEncoderPID);
    //    requires (leftEncoderPID);
        
   ///     rightEncoderPID.turnInchesIntoTicks(12, 360);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
    //    rightEncoderPID.setSetpoint(setpoint);
   //     leftEncoderPID.setSetpoint(setpoint);
        
   //     rightEncoderPID.enable();
  //      leftEncoderPID.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("PID'ing");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
   //     double rightPosition = rightEncoderPID.getPosition();
  //      double leftPosition = leftEncoderPID.getPosition();
        
  //      double changeInPosition = rightPosition + leftPosition - 2 * setpoint;
        
        
    //    return changeInPosition < .1 * setpoint;
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
 //       rightEncoderPID.disable();
 //       leftEncoderPID.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
   //     rightEncoderPID.disable();
  //      leftEncoderPID.disable();
    }
}
