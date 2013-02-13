/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.frc1675.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.frc1675.RobotMap;
import org.frc1675.commands.drive.tank.GoToAngle;
import org.frc1675.commands.drive.tank.GoToDistance;
import org.frc1675.commands.dumper.DumperReset;

/**
 *
 * @author team1675
 */
public class AutonB extends CommandGroup {
    
    public AutonB() {
        Timer timer;
        timer = new Timer();
        addSequential(new GoToDistance(235));
        timer.start();
        while (timer.get() < RobotMap.DUMP_TIME){
        }
        timer.reset();
        timer.stop();
        addParallel(new DumperReset());
        addSequential(new GoToDistance(-12));
        addSequential(new GoToAngle(180));
        addSequential(new GoToDistance(200));
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
