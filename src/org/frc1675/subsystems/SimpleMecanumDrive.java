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

    private SpeedController motor1;
    private SpeedController motor2;
    private SpeedController motor3;
    private SpeedController motor4;
    
    public SimpleMecanumDrive(){
        motor1 = new Victor(RobotMap.BACK_LEFT_DRIVE_MOTOR);
        motor2 = new Victor(RobotMap.FRONT_LEFT_DRIVE_MOTOR);
        motor3 = new Victor(RobotMap.FRONT_RIGHT_DRIVE_MOTOR);
        motor4 = new Victor(RobotMap.BACK_RIGHT_DRIVE_MOTOR);
        
        
    }
    
    public void drive(double magnitude, double direction, double rotation){
        double dirInRad = direction + (Math.PI/4);
        
        double sinD = Math.sin(dirInRad);
        double cosD = Math.cos(dirInRad);
        
        double frWheelSpeed = cosD * magnitude - rotation;
        double rrWheelSpeed = sinD * magnitude - rotation;
        double flWheelSpeed = cosD * magnitude + rotation;
        double rlWheelSpeed = sinD * magnitude + rotation;
        
        motor1.set(frWheelSpeed * -1);
        motor2.set(rrWheelSpeed * -1);
        motor3.set(flWheelSpeed);
        motor4.set(rlWheelSpeed);
        /*f = front
        * r = rear
        * l = left
        * r = right */
        
        System.out.println("Mecanum.drive: motor1:"+motor1.get()+", motor2: "+motor2.get()+", motor3: "+motor3.get()+", motor4: "+motor4.get());
        
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new MecanumDrive());
    }
}
