/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.frc1675.RobotMap;
   
/**
 *
 * @author team1675
 */
public class PneaumaticPistons extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private Solenoid extend;
    private Solenoid retract;
    
    public PneaumaticPistons(){
        extend = new Solenoid(RobotMap.PNEAUMATIC_EXTEND);
        retract = new Solenoid(RobotMap.PNEAUMATIC_RETRACT);
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
    public void stop(){
        extend.set(false);
        extend.set(false);
    }

}
