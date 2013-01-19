package org.frc1675;

import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.frc1675.commands.tank.GoStraight;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public Joystick driverController = new Joystick(RobotMap.DRIVER_CONTROLLER); 
    private Button driverXButton = new JoystickButton(driverController, XBoxControllerMap.X_BUTTON);
    private Button driverYButton = new JoystickButton(driverController, XBoxControllerMap.Y_BUTTON);
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.Attempted to add PID controllers.  
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    // Once you have a button, it's trivial to bind it to a button in one of
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

    //HOLY COMMENT holy shit
    public OI() {
        driverXButton.whenPressed(new GoStraight());
//        driverYButton.whenPressed(new DriveForTime(2));
        
        
    }

    public double getMecanumMagnitude() {
        double x = driverController.getRawAxis(XBoxControllerMap.LEFT_X_AXIS);
        double y = driverController.getRawAxis(XBoxControllerMap.LEFT_Y_AXIS);
        double magnitude = Math.sqrt(MathUtils.pow(x, 2.0) + MathUtils.pow(y, 2.0));

        if (magnitude < RobotMap.DEADZONE_RADIUS) {
            magnitude = 0;
        }


        return magnitude;
    }

    public double getMecanumRotation() {
        double x = driverController.getRawAxis(XBoxControllerMap.RIGHT_X_AXIS);
        double rotation = x;
        if (Math.abs(rotation) < RobotMap.DEADZONE_RADIUS) {
            rotation = 0;
        }

        return rotation;
    }

    public double getMecanumDirection() {
        double direction;
        double x = driverController.getRawAxis(XBoxControllerMap.LEFT_X_AXIS);
        double y = driverController.getRawAxis(XBoxControllerMap.LEFT_Y_AXIS);
        //y *= -1.0; <-- Created a flip problem
        double magnitude = getMecanumMagnitude();

        if (magnitude < RobotMap.DEADZONE_RADIUS) {
            direction = 0.0;
        } else {
            direction = MathUtils.atan2(y, x);
        }
        direction -= Math.PI / 2;
        System.out.println(direction);

        return direction;
    }

    public double getLeftY() {
        return driverController.getRawAxis(XBoxControllerMap.LEFT_Y_AXIS);
    }

    public double getRightY() {
        return driverController.getRawAxis(XBoxControllerMap.RIGHT_Y_AXIS);
    }
}
