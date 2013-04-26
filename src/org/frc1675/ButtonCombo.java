/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.Button;

/**
 * Acts as a JoystickButton if and only if all buttons given in the constructor are pressed.
 * @author josh
 */
public class ButtonCombo extends Button{
    
    GenericHID joystick;
    int button1;
    int button2;

    public ButtonCombo(GenericHID joystick, int button1, int button2){
        this.joystick = joystick;
        this.button1 = button1;
        this.button2 = button2;
    }
    
    public boolean get() {
        return joystick.getRawButton(button1) && joystick.getRawButton(button2);
    }
}
