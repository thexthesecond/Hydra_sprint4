// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotArmSys;

public class RobotArmCmd extends Command {
  private final RobotArmSys m_RobotArmSys;

  public RobotArmCmd(RobotArmSys m_RobotArmSys) {
    this.m_RobotArmSys = m_RobotArmSys;
    
    addRequirements(m_RobotArmSys);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {

    if (m_RobotArmSys.pov == 0) {
      m_RobotArmSys.ArmUp();
    }

    if (m_RobotArmSys.pov == 180) {
      m_RobotArmSys.ArmDown();
    }

    if (m_RobotArmSys.pov == 90) {
      m_RobotArmSys.ClawLeft();
    }

    if (m_RobotArmSys.pov == 270) {
      m_RobotArmSys.ClawRight();
    }

    if (m_RobotArmSys.armEncoder2Deg > 180 || m_RobotArmSys.armEncoder2Deg < -180) {
      m_RobotArmSys.stopArm();
    }

    if (m_RobotArmSys.clawEncoder2Deg > 180 || m_RobotArmSys.clawEncoder2Deg < -180) {
      m_RobotArmSys.stopArm();
    }

    if (m_RobotArmSys.testNumber > 180) {
      m_RobotArmSys.stopArm();
    }
  }

  @Override
  public void end(boolean interrupted) {
    m_RobotArmSys.stopArm();
    m_RobotArmSys.stopClaw();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
