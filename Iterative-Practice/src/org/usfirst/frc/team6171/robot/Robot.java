
package org.usfirst.frc.team6171.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	
	VictorSP leftFront, leftRear, rightFront, rightRear;
	RobotDrive drive;
	
	OI oi;
	
    public void robotInit() {
    	leftFront = new VictorSP(RobotMap.KleftFront);
    	leftRear = new VictorSP(RobotMap.KleftRear);
    	rightFront = new VictorSP(RobotMap.KrightFront);
    	rightRear = new VictorSP(RobotMap.KrightRear);
    	
    	drive = new RobotDrive(leftFront, leftRear, rightFront, rightRear);
    	
    	oi = new OI();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	leftFront.set(1);
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	SmartDashboard.putDouble("Joystick", oi.joy.getRawAxis(1));
    	SmartDashboard.putData("Motor", leftFront);
    	
    	if(oi.LB.get() && oi.RB.get()){
    		drive.setMaxOutput(.75);
    	}
    	else
    		drive.setMaxOutput(.5);
    	
    	drive.arcadeDrive(oi.joy.getRawAxis(1), oi.joy.getRawAxis(5));
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	LiveWindow.addActuator("LeftFront", 0, leftFront);
    }
    
}
