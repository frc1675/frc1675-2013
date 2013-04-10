/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems.drive.tank;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.frc1675.RobotMap;
import org.frc1675.commands.drive.edrive.EDriveWithJoysticks;

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
    private Timer rampTimer;
    
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
        leftEncoder.start();
        leftEncoder.setDistancePerPulse(1.0);
        
        rampTimer = new Timer();
        rampTimer.start();
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new EDriveWithJoysticks());
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
    
    public void set(double velocity){
        if(velocity == 0.0){
            rampTimer.reset(); //get ready to ramp
        } else if (rampTimer.get() < RobotMap.TANK_RAMP_TIME) {
            velocity = velocity * (rampTimer.get() / RobotMap.TANK_RAMP_TIME);
        }
        frontLeftMotor.set(velocity);
        backLeftMotor.set(velocity);
    }
    
    public double get(){
        return frontLeftMotor.get();
    }
    
    public void resetEncoder(){
        leftEncoder.reset();
    }
}
