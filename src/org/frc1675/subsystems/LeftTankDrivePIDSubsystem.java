/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.frc1675.RobotMap;

/**
 *
 * @author team1675
 */
public class LeftTankDrivePIDSubsystem extends PIDSubsystem {

    private static final double Kp = 1.0;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;
    
    private SpeedController frontLeftMotor;
    private SpeedController backLeftMotor;
    
    private Encoder leftEncoder;


    // Initialize your subsystem here
    public LeftTankDrivePIDSubsystem() {
        super("LeftTankDrivePIDSubsystem", Kp, Ki, Kd);

        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.

        frontLeftMotor = new Victor(RobotMap.FRONT_LEFT_DRIVE_MOTOR);
        backLeftMotor = new Victor(RobotMap.BACK_LEFT_DRIVE_MOTOR);
        
        leftEncoder = new Encoder(RobotMap.FRONT_LEFT_ENCODER_A, RobotMap.FRONT_LEFT_ENCODER_B);
        
        double inputRangeMinimum=0;
        double inputRangeMaximum=0;
        
        setInputRange(inputRangeMinimum, inputRangeMaximum);
        enable();
        
        
    }
    
    public double turnInchesIntoTicks(double distanceInches, int encoderTicks){
        return (distanceInches*(encoderTicks/(6*(Math.PI))));
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        
        
        
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;        
        return leftEncoder.get();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
        frontLeftMotor.set(output);
        backLeftMotor.set(output);
    }
    
}
