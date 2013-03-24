/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.frc1675.commands.drive.mecanum.MecanumDrivePolarForTime;

/**
 * Drive forward at 75% speed for 2 seconds.
 * @author josh
 */
public class FrontCornerAuton extends CommandGroup {
    public FrontCornerAuton() {
        addSequential(new MecanumDrivePolarForTime(0.75, 0, 0.0, 2.0));
    }
}
