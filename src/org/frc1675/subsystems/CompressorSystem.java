/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Relay;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.frc1675.RobotMap;
import org.frc1675.commands.CompressorWork;

/**
 *
 * @author team1675
 */
public class CompressorSystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private Compressor compressor;

    
    public CompressorSystem(){
        compressor = new Compressor(RobotMap.HIGH_PRESSURE_SWITCH, RobotMap.COMPRESSOR_SPIKE);
        
    }
    
    public void work(){
        if (!compressor.getPressureSwitchValue()){
            compressor.setRelayValue(Relay.Value.kForward);
        }
        else{
            compressor.setRelayValue(Relay.Value.kOff);
        }
//        System.out.println(compressor.getPressureSwitchValue());
    }
    public void init(){
        compressor.start();
    }
    
    public void stop(){
        compressor.stop();
    }
    public void initDefaultCommand() {
        setDefaultCommand(new CompressorWork());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
    
    
    
}
