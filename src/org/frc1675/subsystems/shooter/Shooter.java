/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems.shooter;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.frc1675.RobotMap;

/**
 *
 * @author TonyStano
 */
public class Shooter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private double bumps = 0.0;
    private SpeedController motorOne;
    private SpeedController motorTwo;
    public Shooter(){
        motorOne = new Victor(RobotMap.SHOOTER_MOTOR_ONE);
        motorTwo = new Victor(RobotMap.SHOOTER_MOTOR_TWO);
        SmartDashboard.putNumber("bumps", bumps);
        
        SmartDashboard.putNumber("shooterSpeed", motorOne.get());


    }    
    public void initDefaultCommand() {
        
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void goToShootSpeed(){
        double coefficient = (RobotMap.DEFAULT_VOLTAGE / DriverStation.getInstance().getBatteryVoltage());
        double backSpeed = RobotMap.BACK_SHOOTING_SPEED * coefficient;
        double frontSpeed = RobotMap.FRONT_SHOOTING_SPEED * coefficient + (bumps * RobotMap.BUMP);
        motorOne.set(backSpeed);
        motorTwo.set(frontSpeed);
        SmartDashboard.putNumber("shooterSpeed", motorTwo.get());

    }
    
    public void goToIdleSpeed(){
        motorOne.set(RobotMap.IDLE_SPEED);
        motorTwo.set(RobotMap.IDLE_SPEED);
        SmartDashboard.putNumber("shooterSpeed", motorOne.get());
    }
    
    public void stopShooter(){
        motorOne.set(0.0);
        motorTwo.set(0.0);
        SmartDashboard.putNumber("shooterSpeed", motorOne.get());

    }
    
    public void BumpUp(){
        bumps += 1.0;
        SmartDashboard.putNumber("bumps", bumps);

    }
    public void BumpDown(){
        bumps -= 1.0;
        SmartDashboard.putNumber("bumps", bumps);

    }

}

