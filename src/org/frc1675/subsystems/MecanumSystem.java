/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.frc1675.RobotMap;
import org.frc1675.commands.MecanumDrive;

/**
 *
 * @author ericmiller
 */
public class MecanumSystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private SpeedController motor1;
    private SpeedController motor2;
    private SpeedController motor3;
    private SpeedController motor4;
    
    public MecanumSystem(){
        motor1 = new Jaguar(RobotMap.DSC_SLOT, RobotMap.DRIVE_MOTOR_1);
        motor2 = new Jaguar(RobotMap.DSC_SLOT, RobotMap.DRIVE_MOTOR_2);
        motor3 = new Jaguar(RobotMap.DSC_SLOT, RobotMap.DRIVE_MOTOR_3);
        motor4 = new Jaguar(RobotMap.DSC_SLOT, RobotMap.DRIVE_MOTOR_4);
        
        
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
        
        //sSystem.out.println("Mecanum.drive: motor1:"+motor1.get()+", motor2: "+motor2.get()+", motor3: "+motor3.get()+", motor4: "+motor4.get());
        
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new MecanumDrive());
    }
}
