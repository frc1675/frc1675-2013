/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems.drive.tank;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.frc1675.RobotMap;
import org.frc1675.commands.drive.edrive.EDriveWithJoysticks;
import org.frc1675.subsystems.drive.DriveSideWrapper;

/**
 *
 * @author josh
 */
public class TankDrivePIDSubsystem extends PIDSubsystem {
    
    private DriveSideWrapper motors;
    private Encoder encoder;
    private Timer rampTimer;
    
    // Initialize your subsystem here
    public TankDrivePIDSubsystem(double p, double i, double d, 
            DriveSideWrapper motors, 
            int encoderAChannel, int encoderBChannel, 
            double distancePerPulse) {
        super("LeftTankDrivePIDSubsystem", p, i, d);

        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.

        this.motors = motors;
        encoder = new Encoder(encoderAChannel, encoderBChannel);
        encoder.start();
        encoder.setDistancePerPulse(distancePerPulse);
        
        rampTimer = new Timer();
        rampTimer.start();
    }
    
    public void initDefaultCommand() {        
//        setDefaultCommand(new TankDriveWithJoysticks());
        //setDefaultCommand(new TankDriveDoNothing());
        setDefaultCommand(new EDriveWithJoysticks());
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
        motors.setFront(output);
        motors.setBack(output);
        SmartDashboard.putNumber("Encoder Value", encoder.get());
    }
    
    public void set(double velocity){
        if(velocity == 0.0){
            rampTimer.reset(); //get ready to ramp
        } else if (rampTimer.get() < RobotMap.TANK_RAMP_TIME) {
            velocity = velocity * (rampTimer.get() / RobotMap.TANK_RAMP_TIME);
        }
        motors.setFront(velocity);
        motors.setBack(velocity);
    }
    
//    public double get(){
//        return 0;
//    }
    
    public void resetEncoder(){
        encoder.reset();
    }
}
