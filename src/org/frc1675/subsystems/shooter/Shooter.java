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
    private SpeedController motor;
    public Shooter(){
        motor = new Victor(RobotMap.SHOOTER_MOTOR);
    }    
    public void initDefaultCommand() {
        
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void setFull(){
        motor.set(1);
    }
    public void setToVoltage(double voltage){
        motor.set(voltage);
    }
    public void setOff(){
        motor.set(0);
    }
}
