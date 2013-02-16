/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.frc1675.RobotMap;
import org.frc1675.commands.CompressorWork;

/**
 *
 * @author team1675
 */
public class CompressorSystem extends Subsystem {
    
    private Compressor compressor;
    private AnalogChannel pressureSensor;
    
    public CompressorSystem(){
        compressor = new Compressor(RobotMap.HIGH_PRESSURE_SWITCH, RobotMap.COMPRESSOR_SPIKE);
        pressureSensor = new AnalogChannel(RobotMap.PRESSURE_SENSOR);
        pressureSensor.setAverageBits(5);
    }
    
    public void work(){
        if (!compressor.getPressureSwitchValue()){
            compressor.setRelayValue(Relay.Value.kForward);
        }else{
            compressor.setRelayValue(Relay.Value.kOff);
        }
        SmartDashboard.putNumber("Working Pressure", (pressureSensor.getAverageValue()*20));
    }
    public void init(){
        compressor.start();
    }
    
    public void stop(){
        compressor.stop();
    }
    public void initDefaultCommand() {
        setDefaultCommand(new CompressorWork());
    }
}

