package org.frc1675.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.frc1675.OI;
import org.frc1675.subsystems.CompressorSystem;
import org.frc1675.subsystems.LeftTankDrivePIDSubsystem;
import org.frc1675.subsystems.PneaumaticPistons;
import org.frc1675.subsystems.RightTankDrivePIDSubsystem;
import org.frc1675.subsystems.SimpleMecanumDrive;

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
//    public static SimpleMecanumDrive simpleMecanumDrive;
//    public static SimpleTankDrive simpleTankDrive = new SimpleTankDrive();
    public static LeftTankDrivePIDSubsystem leftEncoderPID;
    public static RightTankDrivePIDSubsystem rightEncoderPID;
    public static CompressorSystem compressor;
    public static PneaumaticPistons pneaumaticPistons;
    
    static {
//        simpleMecanumDrive = new SimpleMecanumDrive();

//      simpleTankDrive = new SimpleTankDrive();
        compressor = new CompressorSystem();
        pneaumaticPistons = new PneaumaticPistons();
        leftEncoderPID = new LeftTankDrivePIDSubsystem();
        rightEncoderPID = new RightTankDrivePIDSubsystem();        

//        simpleTankDrive = new SimpleTankDrive();

        leftEncoderPID = new LeftTankDrivePIDSubsystem();
        rightEncoderPID = new RightTankDrivePIDSubsystem();        

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
