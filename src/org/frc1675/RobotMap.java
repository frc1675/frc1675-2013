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
    
    //outputs
    public static final int FRONT_LEFT_DRIVE_MOTOR = 1;
    public static final int FRONT_RIGHT_DRIVE_MOTOR = 3;
    public static final int BACK_LEFT_DRIVE_MOTOR = 2;
    public static final int BACK_RIGHT_DRIVE_MOTOR = 4;
    public static final int BACK_SHOOTER_MOTOR = 5;
    public static final int FRONT_SHOOTER_MOTOR = 6;
    
    public static final int LIGHTS_BIT_ONE = 8;
    public static final int LIGHTS_BIT_TWO = 9;
    public static final int LIGHTS_BIT_THREE = 10;

    
    public static final double FRONT_LEFT_DRIVE_POLARITY = 1.0;
    public static final double FRONT_RIGHT_DRIVE_POLARITY = -1.0;
    public static final double BACK_LEFT_DRIVE_POLARITY = 1.0;
    public static final double BACK_RIGHT_DRIVE_POLARITY = -1.0;

       
    //relays
    public static final int DUMPER_SPIKE = 3;
    public static final int COMPRESSOR_SPIKE = 2; 
    
    // digital sensors
    public static final int SHOOTER_ENCODER = 2;
    public static final int FRONT_LEFT_ENCODER_A = 7;
    public static final int FRONT_LEFT_ENCODER_B = 12;
    public static final int FRONT_RIGHT_ENCODER_A = 11;
    public static final int FRONT_RIGHT_ENCODER_B = 4;
    public static final int COMPRESSOR_SWITCH = 1; //5

    
       
    //solenoids
    public static final int CLIMBER_EXTEND = 5;    
    public static final int CLIMBER_RETRACT = 1;
    
    public static final int DUMPER_EXTEND = 6;    
    public static final int DUMPER_RETRACT = 2;
    
    public static final int FOOT_EXTEND = 7;    
    public static final int FOOT_RETRACT = 3;
    
    public static final int INDEXER_EXTEND = 4;  //4 
    public static final int INDEXER_RETRACT = 8; //8
    
    public static final double SOLENOID_ACTIVE_TIME = 0.1; //seconds
    public static final double DUMP_TIME = 1.7;   //seconds
    public static final double INDEX_TIME = .5;
    
    //controllers and other stuff
    public static final int DRIVER_CONTROLLER = 1;
    public static final int OPERATOR_CONTROLLER = 2;
    public static final double DEADZONE_RADIUS = 0.15;
    public static final double BUMP = .05;
    public static final double BUTTON_COOLDOWN = .25;
    public static final double IDLE_SPEED = .3;
    
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

            
    
    
    //light routines
    public static final int LIGHTS_OFF = 0;
    public static final int LIGHTS_EXTENDING = 1;
    public static final int LIGHTS_RETRACTING = 2;
    public static final int LIGHTS_SPAZZ_OUT = 3;
    
    
    //shooting stuff
    public static final double DEFAULT_SETPOINT = 2700;  //2700
    public static final double STEP = 100;
    public static final double IDLE_RPM = 1000;
    
    
    public static final double DEFAULT_VOLTAGE = 12.0;
    public static double BACK_SHOOTING_SPEED = 0.6;
    public static double FRONT_SHOOTING_SPEED = 1.0;
}
