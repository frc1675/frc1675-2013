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
    private Solenoid superExtend;
    private Solenoid superRetract;
    
    public Dumper(){
        extend = new Solenoid(RobotMap.DUMPER_EXTEND);
        retract = new Solenoid(RobotMap.DUMPER_RETRACT);
        superExtend = new Solenoid(RobotMap.DUMPER_ANGLE_EXTEND);
        superRetract = new Solenoid(RobotMap.DUMPER_ANGLE_RETRACT);
    }

    public void initDefaultCommand() {
        //no default command
    }
    
    public void dump(){
        extend.set(true);
        retract.set(false);
    }
    public void setAngle(){
        superExtend.set(true);
        superRetract.set(false);
    }
    public void resetAngle(){
        superRetract.set(true);
        superExtend.set(false);
    }
    public void extendAll(){
        extend.set(true);
        retract.set(false);
        superExtend.set(true);
        superRetract.set(false);
    }
    
    public void resetAll(){
        extend.set(false);
        retract.set(true);
        superExtend.set(false);
        superRetract.set(true);
    }
    
            
    public void resetDump(){
        extend.set(false);
        retract.set(true);
    }
    
    public void doNothing(){
        extend.set(false);
        retract.set(false);
        superExtend.set(false);
        superRetract.set(false);
    }
}
