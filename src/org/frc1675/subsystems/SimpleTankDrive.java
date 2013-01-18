/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.frc1675.RobotMap;
import org.frc1675.commands.tank.TankDrive;

/**
 *
 * @author team1675
 */
public class SimpleTankDrive extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private SpeedController frontLeftMotor;
    private SpeedController frontRightMotor;
    private SpeedController backLeftMotor;
    private SpeedController backRightMotor;

    public SimpleTankDrive() {
        frontLeftMotor = new Victor(RobotMap.FRONT_LEFT_DRIVE_MOTOR);
        frontRightMotor = new Victor(RobotMap.FRONT_RIGHT_DRIVE_MOTOR);
        backLeftMotor = new Victor(RobotMap.BACK_LEFT_DRIVE_MOTOR);
        backRightMotor = new Victor(RobotMap.BACK_RIGHT_DRIVE_MOTOR);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new TankDrive());
    }

    public void setRightSpeed(double rightStick) {
        frontRightMotor.set(-rightStick);
        backRightMotor.set(-rightStick);


    }

    public void setLeftSpeed(double leftStick) {
        frontLeftMotor.set(-leftStick);
        backLeftMotor.set(-leftStick);
    }

    public double getRightSpeed() {
        return frontRightMotor.get();
    }

    public double getLeftSpeed() {
        return frontLeftMotor.get();
    }
}
