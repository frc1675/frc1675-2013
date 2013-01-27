/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.frc1675.RobotMap;
import org.frc1675.commands.mecanum.MecanumDrive;

/**
 *
 * @author ericmiller
 */
public class SimpleMecanumDrive extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private SpeedController motorBL;
    private SpeedController motorFL;
    private SpeedController motorFR;
    private SpeedController motorBR;
    
    public SimpleMecanumDrive(){
        motorBL = new Victor(RobotMap.BACK_LEFT_DRIVE_MOTOR);
        motorFL = new Victor(RobotMap.FRONT_LEFT_DRIVE_MOTOR);
        motorFR = new Victor(RobotMap.FRONT_RIGHT_DRIVE_MOTOR);
        motorBR = new Victor(RobotMap.BACK_RIGHT_DRIVE_MOTOR);
        
        
    }
    
    public void drive(double magnitude, double direction, double rotation){
        double dirInRad = direction + (Math.PI/4);
        
        double sinD = Math.sin(dirInRad);
        double cosD = Math.cos(dirInRad);
        
        double frWheelSpeed = cosD * magnitude - rotation;
        double brWheelSpeed = sinD * magnitude - rotation;
        double flWheelSpeed = cosD * magnitude + rotation;
        double blWheelSpeed = sinD * magnitude + rotation;
        
        motorBL.set(blWheelSpeed);
        motorFL.set(flWheelSpeed);
        motorFR.set(frWheelSpeed * -1.0);
        motorBR.set(brWheelSpeed * -1.0); //flips may change to other side
        /*f = front
        * b = back
        * l = left
        * r = right */
        
        System.out.println("Mecanum.drive: motor1:"+motorBL.get()+", motor2: "+motorFL.get()+", motor3: "+motorFR.get()+", motor4: "+motorBR.get());
        
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new MecanumDrive());
    }
}
