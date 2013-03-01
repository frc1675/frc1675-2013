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
    public static final int FRONT_RIGHT_DRIVE_MOTOR = 3;
    public static final int BACK_LEFT_DRIVE_MOTOR = 2;
    public static final int BACK_RIGHT_DRIVE_MOTOR = 4;
    
    public static final double FRONT_LEFT_DRIVE_POLARITY = 1.0;
    public static final double FRONT_RIGHT_DRIVE_POLARITY = -1.0;
    public static final double BACK_LEFT_DRIVE_POLARITY = 1.0;
    public static final double BACK_RIGHT_DRIVE_POLARITY = -1.0;
    
    public static final int SHOOTER_MOTOR = 5;
    
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
    public static final int CLIMBER_EXTEND = 5;    
    public static final int CLIMBER_RETRACT = 1;
    
    public static final int DUMPER_EXTEND = 6;    
    public static final int DUMPER_RETRACT = 2;
    
    public static final int FOOT_EXTEND = 7;    
    public static final int FOOT_RETRACT = 3;
    
    public static final int DUMPER_ANGLE_EXTEND = 8;
    public static final int DUMPER_ANGLE_RETRACT = 4;
    
    public static final double SOLENOID_ACTIVE_TIME = 0.1; //seconds
    public static final double DUMP_TIME = 1.7;   //seconds
    
    //controllers and other stuff
    public static final int DRIVER_CONTROLLER = 1;
    public static final int OPERATOR_CONTROLLER = 2;
    public static final double DEADZONE_RADIUS = 0.15;
    
    
    //analog card
    public static final int PRESSURE_SENSOR = 4;
    
    public static final int DRIVE_GYRO = 2;
    public static final double VOLTS_PER_DEGREES_PER_SECONDS = 0.007;
    
    
    public static final double DRIVE_WHEEL_DIAMETER = 6;
    public static final double TANK_RAMP_TIME = .25;
    public static final double DRIVE_ENCODER_TICKS_PER_REV = 360.0;
    
    //PIDs
    public static final double GYRO_P = .004;
    public static final double GYRO_I = 0.0;
    public static final double GYRO_D = 0.0;
    
    public static final double ENCODER_P = .01;
    public static final double ENCODER_I = 0.0;
    public static final double ENCODER_D = 0.0;       
            
    
}
