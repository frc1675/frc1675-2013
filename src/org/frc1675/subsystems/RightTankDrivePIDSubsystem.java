/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.frc1675.RobotMap;
import org.frc1675.commands.TankDriveWithJoysticks;

/**
 *
 * @author team1675
 */
public class RightTankDrivePIDSubsystem extends Subsystem {

    private static final double Kp = 1.0;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;
    
    private SpeedController frontRightMotor;
            
    private Encoder rightEncoder;     
    
    
    // Initialize your subsystem here
    public RightTankDrivePIDSubsystem() {
//        super("RightTankDrivePIDSubsystem", Kp, Ki, Kd);

        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
        frontRightMotor = new Talon(RobotMap.FRONT_RIGHT_DRIVE_MOTOR);
        
        rightEncoder = new Encoder(RobotMap.FRONT_RIGHT_ENCODER_A, RobotMap.FRONT_RIGHT_ENCODER_B);
        
//        double inputRangeMinimum=0;
//        double inputRangeMaximum=0;
//        
//        setInputRange(inputRangeMinimum, inputRangeMaximum);
        
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new TankDriveWithJoysticks());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return rightEncoder.get();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
        
        frontRightMotor.set(output);
    }
    public double turnInchesIntoTicks(double distanceInches, int encoderTicks){
        return (distanceInches*(encoderTicks/(6*(Math.PI))));
    }
    
    public void set(double velocity){
        frontRightMotor.set(velocity);
    }
}
