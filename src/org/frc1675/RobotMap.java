package org.frc1675;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;

    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    
    //motors
    public static final int FRONT_LEFT_DRIVE_MOTOR = 1;
    public static final int FRONT_RIGHT_DRIVE_MOTOR = 2;
    public static final int BACK_LEFT_DRIVE_MOTOR = 3;
    public static final int BACK_RIGHT_DRIVE_MOTOR = 4;
    
    //relays
    public static final int COMPRESSOR_SPIKE = 2;
    
    //sensors
    public static final int FRONT_LEFT_ENCODER_A = 1;
    public static final int FRONT_LEFT_ENCODER_B = 2;
    public static final int FRONT_RIGHT_ENCODER_A = 3;
    public static final int FRONT_RIGHT_ENCODER_B = 4;
    public static final int HIGH_PRESSURE_SWITCH = 5;
    public static final int EXTEND_PNEUMATICS_SWITCH = 6;
    public static final int RETRACT_PNEUMATICS_SWITCH = 7;
    
    //solenoids
    public static final int CLIMBER_RETRACT = 1;    
    public static final int CLIMBER_EXTEND = 3;

    
    //controllers and other stuff
    public static final int DRIVER_CONTROLLER = 1;
    public static final int OPERATOR_CONTROLLER = 2;
    public static final double DEADZONE_RADIUS = 0.15;
    public static final double ACCELERATION_INCREMENT = .001;
    
    //analog card
    public static final int GYRO = 2;
}
