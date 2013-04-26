/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.frc1675.commands.EncoderShooter.EncoderShooterDefaultExecute;
import org.frc1675.commands.EncoderShooter.EncoderShooterTurnOff;
import org.frc1675.commands.EncoderShooter.EncoderShooterTurnOn;
import org.frc1675.commands.drive.edrive.EDriveForTime;
import org.frc1675.commands.drive.mecanum.MecanumDrivePolarForTime;
import org.frc1675.commands.shooter.GoToIdleSpeed;
import org.frc1675.commands.shooter.GoToShootingSpeed;

/**
 * Drive forward at 75% speed for 3 seconds.
 * @author josh
 */
public class BackCornerAuton extends CommandGroup {
    
    private static final double INITIAL_WIND_UP = 3.0;
    private static final double AFTER_FIRST_SHOT = 0.5;
    private static final double AFTER_SECOND_SHOT = 0.5;
    private static final double RETRY_WAIT = 0.5;
    private static final double DRIVE_DURATION = 1.0;

    public BackCornerAuton() {
        //times are approximate
        addParallel(new EncoderShooterTurnOn());
        addSequential(new Wait(INITIAL_WIND_UP));//3.0
        addSequential(new Index());//3.5
        addSequential(new Wait(AFTER_FIRST_SHOT));//5.5
        addSequential(new Index());//6.0
        addSequential(new Wait(AFTER_SECOND_SHOT));//8.0
        addSequential(new Index());//8.5
        
        addSequential(new Wait(AFTER_SECOND_SHOT));//9.5
        addSequential(new Index());//10.0
        addSequential(new Wait(AFTER_SECOND_SHOT));//11.0
        addSequential(new Index());//11.5
        addSequential(new Wait(AFTER_SECOND_SHOT));//11.0
        addSequential(new Index());//11.5
        addSequential(new Wait(AFTER_SECOND_SHOT));//11.0
        addSequential(new Index());//11.5
        
//        addSequential(new MecanumDrivePolarForTime(0.5, 0.0, 0.0, DRIVE_DURATION));//12.5
//        addSequential(new EDriveForTime(0.5, 0.0, DRIVE_DURATION));
        addSequential(new EncoderShooterTurnOff());
    }
}
