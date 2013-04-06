/*
 * To ch                                                                                                                                        ange this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems.dumper; 

import edu.wpi.first.wpilibj.Relay;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.frc1675.RobotMap;

/**
 *
 * @author Tony
 */
public class Dumper extends Subsystem {
    private Relay motor = new Relay(RobotMap.DUMPER_SPIKE);
    
    public Dumper(){
            
    }

    public void initDefaultCommand() {
        //no default command
    }
    
    public void dump(){
        motor.set(Relay.Value.kForward);
    }            
    public void resetDump(){
        motor.set(Relay.Value.kReverse);
    }
    
    public void doNothing(){
        motor.set(Relay.Value.kOff);
    }
}
