/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.frc1675.commands.drive.mecanum.MecanumDrivePolarForTime;
import org.frc1675.commands.shooter.GoToIdleSpeed;
import org.frc1675.commands.shooter.GoToShootingSpeed;

/**
 * Drive forward at 75% speed for 3 seconds.
 * @author josh
 */
public class BackCornerAuton extends CommandGroup {
    
    private static final double INITIAL_WIND_UP = 6.0;
    private static final double AFTER_FIRST_SHOT = 3.0;
    private static final double AFTER_SECOND_SHOT = 3.0;
    private static final double DRIVE_DURATION = 1.0;

    public BackCornerAuton() {
        addSequential(new GoToShootingSpeed());
        addSequential(new Wait(INITIAL_WIND_UP));
        addSequential(new Index());
        addSequential(new Wait(AFTER_FIRST_SHOT));
        addSequential(new Index());
        addSequential(new Wait(AFTER_SECOND_SHOT));
        addSequential(new Index());
        addSequential(new MecanumDrivePolarForTime(0.5, 0.0, 0.0, DRIVE_DURATION));
    }
}
