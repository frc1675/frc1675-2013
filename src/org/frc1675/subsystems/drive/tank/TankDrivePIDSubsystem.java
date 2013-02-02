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
import org.frc1675.commands.drive.tank.TankDriveWithJoysticks;

/**
 *
 * @author josh
 */
public class TankDrivePIDSubsystem extends PIDSubsystem {
    
    private SpeedController frontMotor;
    private SpeedController backMotor;
    private Encoder encoder;
    private Timer rampTimer;
    
    // Initialize your subsystem here
    public TankDrivePIDSubsystem(double p, double i, double d, 
            int frontMotorChannel, int backMotorChannel, 
            int encoderAChannel, int encoderBChannel, 
            double distancePerPulse) {
        super("LeftTankDrivePIDSubsystem", p, i, d);

        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
        frontMotor = new Victor(frontMotorChannel);
        backMotor = new Victor(backMotorChannel);
        
        encoder = new Encoder(encoderAChannel, encoderBChannel);
        encoder.start();
        encoder.setDistancePerPulse(distancePerPulse);
        
        rampTimer = new Timer();
        rampTimer.start();
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new TankDriveWithJoysticks());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;        
        return encoder.get();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
        frontMotor.set(output);
        backMotor.set(output);
    }
    
    public void set(double velocity){
        if(velocity == 0.0){
            rampTimer.reset(); //get ready to ramp
        } else if (rampTimer.get() < RobotMap.TANK_RAMP_TIME) {
            velocity = velocity * (rampTimer.get() / RobotMap.TANK_RAMP_TIME);
        }
        frontMotor.set(velocity);
        backMotor.set(velocity);
    }
    
    public double get(){
        return frontMotor.get();
    }
    
    public void resetEncoder(){
        encoder.reset();
    }
}
