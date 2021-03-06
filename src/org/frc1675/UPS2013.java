/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package org.frc1675;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.frc1675.commands.BackCornerAuton;
import org.frc1675.commands.CommandBase;
import org.frc1675.commands.EncoderShooter.EncoderShooterTurnOff;
import org.frc1675.commands.FrontCornerAuton;
import org.frc1675.commands.drive.mecanum.MecanumDrivePolarForTime;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class UPS2013 extends IterativeRobot {
    Command autonomousCommand;
    Command teleCommand;
    private Command Command;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        CommandBase.init();
        // instantiate the command used for the autonomous period   



        //set insight display strategy
//       InsightController.setDisplayStrategy(new DefaultInsightDisplayStrategy());        

    }

    public void autonomousInit() {
        autonomousCommand = new BackCornerAuton();
        autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();

//        InsightController.updateInsightDisplay();

    }


    public void disabledInit(){

    }
    

    public void disabledPeriodic() {
//        InsightController.updateInsightDisplay();

    }
    

   
    public void teleopInit() {
        teleCommand = new EncoderShooterTurnOff();
        teleCommand.start();        
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
//        autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {

         Scheduler.getInstance().run();
//        InsightController.updateInsightDisplay();
        

    }
    /**
     * This function is called periodically during test mode
     */
         
    public void testPeriodic() {
    //    LiveWindow.run();
    }
}
