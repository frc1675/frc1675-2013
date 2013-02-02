/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems.climbassist;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.frc1675.RobotMap;

/**
 *
 * @author josh
 */
public class ClimbAssist extends Subsystem {
    private Solenoid extend;
    private Solenoid retract;
    
    public ClimbAssist(){
        extend = new Solenoid(RobotMap.CLIMB_ASSIST_EXTEND);
        retract = new Solenoid(RobotMap.CLIMB_ASSIST_RETRACT);
    }

    public void initDefaultCommand() {
        //no default command
    }
    
    public void dump(){
        extend.set(true);
        retract.set(false);
    }
    
    public void reset(){
        extend.set(false);
        retract.set(true);
    }
    public void doNothing(){
        extend.set(false);
        retract.set(false);
    }
}
