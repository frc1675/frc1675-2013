/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems.drive.mecanum;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.frc1675.RobotMap;
import org.frc1675.commands.drive.mecanum.MecanumDrive;

/**
 *
 * @author ericmiller
 */
public class SimpleMecanumDrive extends Subsystem {

    private SpeedController motorBL;
    private SpeedController motorFL;
    private SpeedController motorFR;
    private SpeedController motorBR;
    private Timer rampTimer;
    
    public SimpleMecanumDrive(){
        motorBL = new Victor(RobotMap.BACK_LEFT_DRIVE_MOTOR);
        motorFL = new Victor(RobotMap.FRONT_LEFT_DRIVE_MOTOR);
        motorFR = new Victor(RobotMap.FRONT_RIGHT_DRIVE_MOTOR);
        motorBR = new Victor(RobotMap.BACK_RIGHT_DRIVE_MOTOR);
        rampTimer = new Timer();
        rampTimer.start();
    }
    
    public void drive(double magnitude, double direction, double rotation){
        if(magnitude == 0.0){
            rampTimer.reset(); //get ready to ramp
        } else if (rampTimer.get() < RobotMap.TANK_RAMP_TIME) {
            magnitude = magnitude * (rampTimer.get() / RobotMap.TANK_RAMP_TIME);
        }
        
        
        
        double dirInRad = direction + (Math.PI/4);
        
        double sinD = Math.sin(dirInRad);
        double cosD = Math.cos(dirInRad);
        
        double frWheelSpeed = cosD * magnitude + rotation;
        double brWheelSpeed = sinD * magnitude + rotation;
        double flWheelSpeed = sinD * magnitude - rotation;
        double blWheelSpeed = cosD * magnitude - rotation;
        
        motorBL.set(blWheelSpeed * -1.0);
        motorFL.set(flWheelSpeed * -1.0);
        motorFR.set(frWheelSpeed * -1.0);
        motorBR.set(brWheelSpeed * -1.0);
        /*f = front
        * b = back
        * l = left
        * r = right */
        
        System.out.println("Mecanum.drive: motor1:"+motorBL.get()+", motor2: "+motorFL.get()+", motor3: "+motorFR.get()+", motor4: "+motorBR.get());
    }

    public void initDefaultCommand() {
        setDefaultCommand(new MecanumDrive());
    }
}
