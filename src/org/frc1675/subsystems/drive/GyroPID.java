/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems.drive;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.frc1675.commands.drive.GyroCommand;

/**
 *
 * @author team1675
 */
public class GyroPID extends PIDSubsystem {

    private Gyro gyro;
    private double outputPID = 0.0;

    // Initialize your subsystem here
    public GyroPID(double p, double i, double d, int gyroChannel, 
            double inputRangeMinimum, double inputRangeMaximum, double gyroSensitivity) {
        super("Gyro", p, i, d);
        gyro = new Gyro(gyroChannel);       
        this.getPIDController().setContinuous();
        setInputRange(inputRangeMinimum, inputRangeMaximum);

        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
        // 0.007 volts per degree per second
        gyro.setSensitivity(gyroSensitivity);   
        
    }
  
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new GyroCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;                
        return gyro.pidGet();
        
        
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
        outputPID = output;
    }

    public void reset(){
        gyro.reset();
    }
    
    public double getPIDOutput(){
        return outputPID;
    }
    
    public double getAngle(){
        return gyro.getAngle();
    }
    
}
