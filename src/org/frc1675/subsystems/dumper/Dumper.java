/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems.dumper;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.frc1675.RobotMap;

/**
 *
 * @author josh
 */
public class Dumper extends Subsystem {
    private Solenoid extend;
    private Solenoid retract;
    
    public Dumper(){
        extend = new Solenoid(RobotMap.DUMPER_EXTEND);
        retract = new Solenoid(RobotMap.DUMPER_RETRACT);
    }

    public void initDefaultCommand() {
        //no default command
    }
    
    public void extend(){
        extend.set(true);
        retract.set(false);
    }
    
    public void retract(){
        extend.set(false);
        retract.set(true);
    }
}
