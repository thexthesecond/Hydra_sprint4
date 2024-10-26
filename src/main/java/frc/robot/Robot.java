package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends TimedRobot {

  public RobotArmSys m_RobotArmSys = new RobotArmSys();
  public RobotContainer m_RobotContainer;
  public Joystick joy = m_RobotArmSys.joy;
  
  @Override
  public void robotInit() {
    m_RobotContainer = new RobotContainer();
  }
  
  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }
}
