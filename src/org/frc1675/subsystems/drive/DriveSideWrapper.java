/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems.drive;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;


/**
 *
 * @author team1675
 */
public class DriveSideWrapper {
    private SpeedController frontMotor;
    private SpeedController backMotor;
    
    public DriveSideWrapper(int frontChannel, int backChannel){
        frontMotor = new Victor(frontChannel);
        backMotor = new Victor(backChannel);
    }
    public void setBack(double motorPower){
        backMotor.set(motorPower);
    }
    public void setFront(double motorPower){
        frontMotor.set(motorPower);
    }
    public void setBoth(double frontMotorPower, double backMotorPower){
        backMotor.set(backMotorPower);
        frontMotor.set(frontMotorPower);
    }
}
