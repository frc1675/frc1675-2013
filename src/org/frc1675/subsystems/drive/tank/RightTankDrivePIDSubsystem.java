/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems.drive.tank;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.frc1675.RobotMap;
import org.frc1675.commands.drive.tank.TankDriveWithJoysticks;

/**
 *
 * @author team1675
 */
public class RightTankDrivePIDSubsystem extends PIDSubsystem {

    private static final double Kp = 1.0;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;
    
    private SpeedController frontRightMotor;
    private SpeedController backRightMotor;
    private Encoder rightEncoder;
    private Timer rampTimer;
    
    
    // Initialize your subsystem here
    public RightTankDrivePIDSubsystem() {
        super("LeftTankDrivePIDSubsystem", Kp, Ki, Kd);

        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
        frontRightMotor = new Victor(RobotMap.FRONT_RIGHT_DRIVE_MOTOR);
        backRightMotor = new Victor(RobotMap.BACK_RIGHT_DRIVE_MOTOR);
        
        rightEncoder = new Encoder(RobotMap.FRONT_RIGHT_ENCODER_A, RobotMap.FRONT_RIGHT_ENCODER_B);
        rightEncoder.start();
        rightEncoder.setDistancePerPulse(1.0);
        
        rampTimer = new Timer();
        rampTimer.start();
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
        backRightMotor.set(output);
    }
    
    public void set(double velocity){
        if(velocity == 0.0){
            rampTimer.reset(); //get ready to ramp
        } else if (rampTimer.get() < RobotMap.TANK_RAMP_TIME) {
            velocity = velocity * (rampTimer.get() / RobotMap.TANK_RAMP_TIME);
        }
        frontRightMotor.set(velocity);
        backRightMotor.set(velocity);
    }
    public double get(){
        return frontRightMotor.get();
    }
    
    public void resetEncoder(){
        rightEncoder.reset();
    }
}
