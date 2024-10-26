package frc.robot;

public final class Constants {

  public static final int arm_MotorPort = 0;
  public static final int claw_MotorPort = 0;
  public static final int JoystickPort = 0;

  // Conversão dos ticks do encoder para graus
  public static final double kTick2Deg = 360 / 512 * 26 / 48 * 18 / 60 * 18 / 84;
  
  public static final double kTestSpeed = 0.5;
}
