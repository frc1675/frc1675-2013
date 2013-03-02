/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems.shooter;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.frc1675.RobotMap;

/**
 *
 * @author TonyStano
 */
public class Shooter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private SpeedController motorOne;
    private SpeedController motorTwo;
    public Shooter(){
        motorOne = new Victor(RobotMap.SHOOTER_MOTOR_ONE);
        motorTwo = new Victor(RobotMap.SHOOTER_MOTOR_TWO);
    }    
    public void initDefaultCommand() {
        
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void setFull(){
        motorOne.set(1);
        motorTwo.set(1);
    }
    public void setToVoltage(double voltage){
        motorOne.set(voltage);
        motorTwo.set(voltage);
    }
    public void setOff(){
        motorOne.set(0);
        motorTwo.set(0);
    }
}
