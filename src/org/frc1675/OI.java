package org.frc1675;

import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Scheduler;
import org.frc1675.commands.Index;
import org.frc1675.commands.foot.FootDown;
import org.frc1675.commands.foot.FootUp;
import org.frc1675.commands.climber.ClimberExtend;
import org.frc1675.commands.climber.ClimberRetract;
import org.frc1675.commands.drive.tank.GoToDistance;
import org.frc1675.commands.drive.tank.GoToAngle;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public Joystick driverController = new Joystick(RobotMap.DRIVER_CONTROLLER); 
    private Button driverBButton = new JoystickButton(driverController, XBoxControllerMap.B_BUTTON);
    private Button driverXButton = new JoystickButton(driverController, XBoxControllerMap.X_BUTTON);
    private Button driverYButton = new JoystickButton(driverController, XBoxControllerMap.Y_BUTTON); 
    private Button driverAButton = new JoystickButton(driverController, XBoxControllerMap.A_BUTTON);
    private Button driverRightBumper = new JoystickButton(driverController, XBoxControllerMap.RIGHT_BUMPER_BUTTON);
    private Button driverLeftBumper = new JoystickButton(driverController, XBoxControllerMap.LEFT_BUMPER_BUTTON);
    private Button driverLeftJoystickButton = new JoystickButton(driverController, XBoxControllerMap.RIGHT_JOYSTICK_BUTTON);
    private Button driverRightJoystickButton = new JoystickButton(driverController, XBoxControllerMap.LEFT_JOYSTICK_BUTTON);
    
    
    public Joystick operatorController = new Joystick(RobotMap.OPERATOR_CONTROLLER); 
    private Button operatorBButton = new JoystickButton(operatorController, XBoxControllerMap.B_BUTTON);
    private Button operatorXButton = new JoystickButton(operatorController, XBoxControllerMap.X_BUTTON);
    private Button operatorYButton = new JoystickButton(operatorController, XBoxControllerMap.Y_BUTTON); 
    private Button operatorAButton = new JoystickButton(operatorController, XBoxControllerMap.A_BUTTON);
    private Button operatorRightBumper = new JoystickButton(operatorController, XBoxControllerMap.RIGHT_BUMPER_BUTTON);
    private Button operatorLeftBumper = new JoystickButton(operatorController, XBoxControllerMap.LEFT_BUMPER_BUTTON);
    private Button operatorLeftJoystickButton = new JoystickButton(operatorController, XBoxControllerMap.RIGHT_JOYSTICK_BUTTON);
    private Button operatorRightJoystickButton = new JoystickButton(operatorController, XBoxControllerMap.LEFT_JOYSTICK_BUTTON);
    
    public OI() {

        operatorXButton.whenPressed(new FootDown());
        operatorBButton.whenPressed(new FootUp());
        operatorYButton.whenPressed(new ClimberExtend());
        operatorAButton.whenPressed(new ClimberRetract()); 
        
        driverAButton.whenPressed(new Index());

        
    }

    public double getMecanumMagnitude() {
        double x = driverController.getRawAxis(XBoxControllerMap.LEFT_X_AXIS);
        double y = driverController.getRawAxis(XBoxControllerMap.LEFT_Y_AXIS);
        double returnMagnitude = 0.0;
        double squareMagnitude = Math.sqrt(MathUtils.pow(x, 2.0) + MathUtils.pow(y, 2.0));
        if(x != 0.0 && y != 0.0){
            double borderX;
            double borderY;
            if(Math.abs(x) > Math.abs(y)){ //scale x to 1.0
                borderX = x / Math.abs(x);
                borderY = y / Math.abs(x);
            } else { //scale y to 1.0
                borderX = x / Math.abs(y);
                borderY = y / Math.abs(y);
            }
            System.out.println("border x: " + borderX + " y: " + borderY);
            double borderMagnitude = Math.sqrt(MathUtils.pow(borderX, 2.0) + MathUtils.pow(borderY, 2.0));
            returnMagnitude = squareMagnitude / borderMagnitude;
        } else {
            returnMagnitude = squareMagnitude;
        }
        
        if (returnMagnitude < RobotMap.DEADZONE_RADIUS) {
            returnMagnitude = 0.0;
        }
        
        return returnMagnitude;
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

        return direction;
    }

    public double getLeftTankCommand() {
        double leftY = -driverController.getRawAxis(XBoxControllerMap.LEFT_Y_AXIS);
        double returnValue = Math.abs(leftY);        
        if(returnValue <= RobotMap.DEADZONE_RADIUS){
            returnValue = 0.0;
        } else {
            returnValue = leftY;
        }
        return returnValue;
    }

    public double getRightTankCommand() {
        double rightY = -driverController.getRawAxis(XBoxControllerMap.RIGHT_Y_AXIS); 
        double returnValue = Math.abs(rightY);        
        if(returnValue <= RobotMap.DEADZONE_RADIUS){
            returnValue = 0.0;
        } else {
            returnValue = rightY;
        }
        return returnValue;
    }
    

    
}
