/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.frc1675.RobotMap;

/**
 *
 * @author jstano
 */
public class Indexer extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private Solenoid extend;
    private Solenoid retract;
    private Timer timer;
    
    public Indexer(){
       extend = new Solenoid(RobotMap.INDEXER_EXTEND);
       retract = new Solenoid(RobotMap.INDEXER_RETRACT);

    }    
    
    public void extend(){
        extend.set(false);
        retract.set(true);
    }
    
    public void retract(){
        extend.set(true);
        retract.set(false);
    }
    
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
