/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.subsystems;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import java.io.OutputStream;
import org.frc1675.RobotMap;

/**
 *
 * @author josh
 */
public class Lights extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    private DigitalOutput bitOne;
    private DigitalOutput bitTwo;
    private DigitalOutput bitThree;
    public Lights(){
        bitOne = new DigitalOutput(RobotMap.LIGHTS_BIT_ONE);
        bitTwo = new DigitalOutput(RobotMap.LIGHTS_BIT_TWO);
        bitThree = new DigitalOutput(RobotMap.LIGHTS_BIT_THREE);
    }
    
    public void sendVal(int value){
        switch(value){
            case 0:
                bitOne.set(false);
                bitTwo.set(false);
                bitThree.set(false);
                break;
            case 1:
                bitOne.set(true);
                bitTwo.set(false);
                bitThree.set(false);
            case 2:
                bitOne.set(false);
                bitTwo.set(true);
                bitThree.set(false);
                break;
            case 3:
                bitOne.set(true);
                bitTwo.set(true);
                bitThree.set(false);
            case 4:
                bitOne.set(false);
                bitTwo.set(false);
                bitThree.set(true);
                break;
            case 5:
                bitOne.set(true);
                bitTwo.set(false);
                bitThree.set(true);
            case 6:
                bitOne.set(false);
                bitTwo.set(true);
                bitThree.set(true);
                break;
            case 7:
                bitOne.set(true);
                bitTwo.set(true);
                bitThree.set(true);
        }
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
