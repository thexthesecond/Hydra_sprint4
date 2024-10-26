// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotArmSys;

public class RobotArmCmd extends Command {
  private final RobotArmSys m_RobotArmSys;
  public int pov;
  public int armNumber;
    public int clawNumber;

  public RobotArmCmd(RobotArmSys m_RobotArmSys) {
    this.m_RobotArmSys = m_RobotArmSys;
    
    addRequirements(m_RobotArmSys);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    pov = m_RobotArmSys.pov;

    // Movimentação dos motores
    if (pov == 0) {
      m_RobotArmSys.armNumber++;
      m_RobotArmSys.setArm(Constants.kTestSpeed);
    }

    if (pov == 180) {
      m_RobotArmSys.armNumber--;
      m_RobotArmSys.setArm(-Constants.kTestSpeed);
    }

    if (pov == 270) {
      m_RobotArmSys.clawNumber++;
      m_RobotArmSys.setClaw(Constants.kTestSpeed);
    }

    if (pov == 90) {
      m_RobotArmSys.clawNumber--;
      m_RobotArmSys.setClaw(-Constants.kTestSpeed);
    }

    // Comando de parada com valor de teste
    if (m_RobotArmSys.armNumber > 180 || m_RobotArmSys.armNumber < -180) {
      m_RobotArmSys.stopArm();
    }

    if (m_RobotArmSys.clawNumber > 180 || m_RobotArmSys.clawNumber < -180) {
      m_RobotArmSys.stopClaw();
    }

    // Comando de parada com valor do encoder
    if (m_RobotArmSys.armEncoder2Deg > 180 || m_RobotArmSys.armEncoder2Deg < -180) {
      m_RobotArmSys.stopArm();
    }

    if (m_RobotArmSys.clawEncoder2Deg > 180 || m_RobotArmSys.clawEncoder2Deg < -180) {
      m_RobotArmSys.stopClaw();
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
