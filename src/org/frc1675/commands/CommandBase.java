package org.frc1675.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.frc1675.OI;
import org.frc1675.RobotMap;
import org.frc1675.commands.drive.edrive.EDriveWithJoysticks;
import org.frc1675.subsystems.CompressorSystem;
import org.frc1675.subsystems.Indexer;
import org.frc1675.subsystems.Lights;
import org.frc1675.subsystems.shooter.Shooter;
import org.frc1675.subsystems.foot.Foot;
import org.frc1675.subsystems.climber.Climber;
import org.frc1675.subsystems.drive.DriveSideWrapper;
import org.frc1675.subsystems.drive.GyroPID;
import org.frc1675.subsystems.drive.mecanum.SimpleMecanumDrive;
import org.frc1675.subsystems.drive.tank.TankDrivePIDSubsystem;
import org.frc1675.subsystems.dumper.Dumper;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use
 * CommandBase.exampleSubsystem
 *
 * @author Tony
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    
    
    // Create a single static instance of all of your subsystems
    public static SimpleMecanumDrive simpleMecanumDrive;
    public static CompressorSystem compressor;
    public static Climber climber;
//    public static LeftTankDrivePIDSubsystem leftDrivePID;
//    public static RightTankDrivePIDSubsystem rightDrivePID;
    public static TankDrivePIDSubsystem leftDrivePID;
    public static TankDrivePIDSubsystem rightDrivePID;
    public static Dumper dumper;
    public static Foot climbAssist;
    public static GyroPID gyroPID;
    public static DriveSideWrapper leftSide;
    public static DriveSideWrapper rightSide;
    public static Shooter shooter;
    public static Lights lights;
    public static Indexer indexer;
    public static EDriveWithJoysticks edrive;
    static {
        shooter = new Shooter();
        leftSide = new DriveSideWrapper(RobotMap.FRONT_LEFT_DRIVE_MOTOR, RobotMap.BACK_LEFT_DRIVE_MOTOR);
        rightSide = new DriveSideWrapper(RobotMap.FRONT_RIGHT_DRIVE_MOTOR, RobotMap.BACK_RIGHT_DRIVE_MOTOR);
//        simpleMecanumDrive = new SimpleMecanumDrive(leftSide, rightSide);
        leftDrivePID = new TankDrivePIDSubsystem(RobotMap.ENCODER_P, RobotMap.ENCODER_I, RobotMap.ENCODER_D, leftSide,
                RobotMap.FRONT_LEFT_ENCODER_A, RobotMap.FRONT_LEFT_ENCODER_B, .05236);
        rightDrivePID = new TankDrivePIDSubsystem(RobotMap.ENCODER_P, RobotMap.ENCODER_I, RobotMap.ENCODER_D, rightSide, 
                RobotMap.FRONT_RIGHT_ENCODER_A, RobotMap.FRONT_RIGHT_ENCODER_B, .05236);       
        compressor = new CompressorSystem();
        climber = new Climber();
        dumper = new Dumper();
        climbAssist = new Foot();        
        gyroPID = new GyroPID(RobotMap.GYRO_P, RobotMap.GYRO_I, RobotMap.GYRO_D, RobotMap.DRIVE_GYRO, -180, 180,
                RobotMap.VOLTS_PER_DEGREES_PER_SECONDS);        
        lights = new Lights();
        indexer = new Indexer();
    }

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();        
            
       
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
