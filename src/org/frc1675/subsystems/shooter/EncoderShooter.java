/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems.shooter;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.frc1675.RobotMap;
import org.frc1675.commands.EncoderShooter.EncoderShooterDefaultExecute;

/**
 *
 * @author Tony
 */
public class EncoderShooter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    SpeedController backMotor;
    SpeedController frontMotor;
    Counter counter;
    double setpoint;
    int numberOfSteps = 0;
    boolean isSetOnControls = false;
    
    public void EncoderShooter(){
        backMotor = new Victor(RobotMap.BACK_SHOOTER_MOTOR);
        frontMotor = new Victor(RobotMap.FRONT_SHOOTER_MOTOR);
        counter = new Counter(RobotMap.SHOOTER_ENCODER); 
        counter.setUpDownCounterMode();
        setpoint = RobotMap.DEFAULT_SETPOINT;
        backMotor.set(.5);
        
        
    }
    public void turnOff(){
        backMotor.set(0);
        frontMotor.set(0);
        setpoint = 0;
        
        
    }
    
    public void turnOn(){
        isSetOnControls = true;
        backMotor.set(RobotMap.BACK_SHOOTING_SPEED);
    }
    
    public void simpleGoTo(double frontValue, double backValue){
        frontMotor.set(frontValue);
        backMotor.set(backValue);
    }
    public void goToRPM(double setpoint){
        this.setpoint= setpoint;
        backMotor.set(RobotMap.BACK_SHOOTING_SPEED);
    }
    
    public void increaseSetpoint(){
        numberOfSteps ++;
        isSetOnControls = true;
        backMotor.set(RobotMap.BACK_SHOOTING_SPEED);
    }
    public void decreaseSetpoint(){
        numberOfSteps --;
        isSetOnControls = true;
        backMotor.set(RobotMap.BACK_SHOOTING_SPEED);
    }
    
    public void execute(){
        if (isSetOnControls){
        setpoint = ((RobotMap.DEFAULT_SETPOINT) + ((RobotMap.STEP) * numberOfSteps));
        }
        double period = counter.getPeriod();
        double rpm = 60.0 / (period * 2.0);

        SmartDashboard.putNumber("RPM", rpm);

        
        if (rpm<setpoint){
           frontMotor.set(1);
        }else{
           frontMotor.set(0);
        }

    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new EncoderShooterDefaultExecute());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
