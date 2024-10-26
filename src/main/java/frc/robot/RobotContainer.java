package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.RobotArmSys;
import frc.robot.commands.RobotArmCmd;

public class RobotContainer {

  public RobotArmSys m_RobotArmSys = new RobotArmSys();
  public Joystick joy = m_RobotArmSys.joy;
  public final RobotArmCmd m_RobotArmCmd;

  public Trigger POVTrigger;

  public RobotContainer() {
    m_RobotArmCmd = new RobotArmCmd(m_RobotArmSys);
    
    POVTrigger = new Trigger(() -> joy.getPOV() != -1);

    configureBindings();
  }

  private void configureBindings() {
    POVTrigger.onTrue(m_RobotArmCmd);
  }
}
