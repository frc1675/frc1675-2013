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
    public BackCornerAuton() {
        addSequential(new GoToShootingSpeed());
        addSequential(new Wait(6.0));
        addSequential(new Index());
        addSequential(new Wait(3.0));
        addSequential(new Index());
        addSequential(new Wait(3.0));
        addSequential(new Index());
        addSequential(new MecanumDrivePolarForTime(0.5, 0.0, 0.0, 1.0));
    }
}
