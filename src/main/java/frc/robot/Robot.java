/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

/*
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private DifferentialDrive m_myRobot;
  private Joystick joy;
  private VictorSPX leftDriver; 
  private VictorSPX leftSlave;
  private VictorSPX rightDriver;
  private VictorSPX rightSlave;
  private VictorSPX intake;

  @Override
  public void robotInit() {
    leftDriver = new VictorSPX(7);
    leftSlave = new VictorSPX(8);
    rightDriver = new VictorSPX(2);
    rightSlave = new VictorSPX(5);
    joy = new Joystick(0);

    intake = new VictorSPX(1);
  }

  @Override
  public void teleopPeriodic() {
    
    leftDriver.set(ControlMode.PercentOutput, joy.getRawAxis(1)*-0.5);
    leftSlave.set(ControlMode.PercentOutput, joy.getRawAxis(1)*-0.5);
    rightDriver.set(ControlMode.PercentOutput, joy.getRawAxis(3)*0.5);
    rightSlave.set(ControlMode.PercentOutput, joy.getRawAxis(3)*0.5);

    if(joy.getRawButton(1)){
      //intake.set(1);
      intake.set(ControlMode.PercentOutput, 0.75);
    }
    else{
      //intake.set(0);
      intake.set(ControlMode.PercentOutput, 0);
    }

  }
}