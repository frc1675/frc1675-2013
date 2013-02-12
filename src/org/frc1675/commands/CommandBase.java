package org.frc1675.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.frc1675.OI;
import org.frc1675.RobotMap;
import org.frc1675.subsystems.CompressorSystem;
import org.frc1675.subsystems.climbassist.ClimbAssist;
import org.frc1675.subsystems.drive.tank.LeftTankDrivePIDSubsystem;
import org.frc1675.subsystems.climber.Climber;
import org.frc1675.subsystems.drive.DriveSideWrapper;
import org.frc1675.subsystems.drive.GyroPID;
import org.frc1675.subsystems.drive.tank.RightTankDrivePIDSubsystem;
import org.frc1675.subsystems.drive.mecanum.SimpleMecanumDrive;
import org.frc1675.subsystems.drive.tank.TankDrivePIDSubsystem;
import org.frc1675.subsystems.dumper.Dumper;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use
 * CommandBase.exampleSubsystem
 *
 * @author Author
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
    public static ClimbAssist climbAssist;
    public static GyroPID gyroPID;
    public static DriveSideWrapper leftSide;
    public static DriveSideWrapper rightSide;
    static {

        leftSide = new DriveSideWrapper(RobotMap.FRONT_LEFT_DRIVE_MOTOR, RobotMap.BACK_LEFT_DRIVE_MOTOR);
        rightSide = new DriveSideWrapper(RobotMap.FRONT_RIGHT_DRIVE_MOTOR, RobotMap.BACK_RIGHT_DRIVE_MOTOR);
        simpleMecanumDrive = new SimpleMecanumDrive(leftSide, rightSide);
        leftDrivePID = new TankDrivePIDSubsystem(1.0, 0.0, 0.0, leftSide,
                RobotMap.FRONT_LEFT_ENCODER_A, RobotMap.FRONT_LEFT_ENCODER_B, 1.0);
        rightDrivePID = new TankDrivePIDSubsystem(1.0, 0.0, 0.0, rightSide, 
                RobotMap.FRONT_RIGHT_ENCODER_A, RobotMap.FRONT_RIGHT_ENCODER_B, 1.0);       
        compressor = new CompressorSystem();
//        climber = new Climber();
//        dumper = new Dumper();
//        climbAssist = new ClimbAssist();        
        gyroPID = new GyroPID(.004, 0, 0, RobotMap.GYRO, -180, 180,
                RobotMap.VOLTS_PER_DEGREES_PER_SECONDS);        
       
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
