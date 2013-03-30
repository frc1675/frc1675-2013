/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.frc1675.RobotMap;

/**
 *
 * @author josh
 */
public class Shooter extends Subsystem {
    private double frontSpeed = 0.0;
    private double backSpeed = 0.0;
    
    private SpeedController frontMotor;
    private SpeedController backMotor;
    
    public Shooter(){
        frontMotor = new Victor(RobotMap.SHOOTER_MOTOR_ONE);
        backMotor = new Victor(RobotMap.SHOOTER_MOTOR_TWO);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void shutOff(){
        frontMotor.set(0.0);
        backMotor.set(0.0);
    }
    
    public void updateSpeed(){
        double currentVoltage = DriverStation.getInstance().getBatteryVoltage();
        double scaleFactor = 12.0 / currentVoltage;
        
        SmartDashboard.putNumber("unscaledFront", frontSpeed);
        SmartDashboard.putNumber("scaledFront", frontSpeed * scaleFactor);
        SmartDashboard.putNumber("unscaledBack", backSpeed);
        SmartDashboard.putNumber("scaledBack", backSpeed * scaleFactor);
        
        frontMotor.set(frontSpeed * scaleFactor);
        backMotor.set(backSpeed * scaleFactor);
    }
    
    public void goToBaseline(){
        frontSpeed = RobotMap.FRONT_BASELINE;
        backSpeed = RobotMap.BACK_BASELINE;
    }
    
    public void bumpUpFront(){
        frontSpeed += RobotMap.FRONT_BUMP;
    }
    
    public void bumpDownFront(){
        frontSpeed -= RobotMap.FRONT_BUMP;
    }
    
    public void bumpUpBack(){
        backSpeed += RobotMap.BACK_BUMP;
    }
    
    public void bumpDownBack(){
        backSpeed -= RobotMap.BACK_BUMP;
    }
}
