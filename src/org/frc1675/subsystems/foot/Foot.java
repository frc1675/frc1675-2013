/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems.foot;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.frc1675.RobotMap;

/**
 *
 * @author josh
 */
public class Foot extends Subsystem {
    private Solenoid extend;
    private Solenoid retract;
    
    public Foot(){
        extend = new Solenoid(RobotMap.FOOT_EXTEND);
        retract = new Solenoid(RobotMap.FOOT_RETRACT);
    }

    public void initDefaultCommand() {
        //no default command
    }
    
    public void extend(){
        extend.set(false);
        retract.set(true);
    }
    
    public void retract(){
        extend.set(true);
        retract.set(false);
    }
    public void doNothing(){
        extend.set(false);
        retract.set(false);
    }
}
