/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems.climber;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.frc1675.RobotMap;
   
/**
 *
 * @author team1675
 */
public class Climber extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private Solenoid extend;
    private Solenoid retract;
    
    
    public Climber(){
        extend = new Solenoid(RobotMap.CLIMBER_EXTEND);
        retract = new Solenoid(RobotMap.CLIMBER_RETRACT);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void extend(){
        extend.set(true);
        retract.set(false);
    }
    public void retract(){
        extend.set(false);
        retract.set(true);
        
    }
    public void doNothing(){
        extend.set(false);
        extend.set(false);
    }

}
