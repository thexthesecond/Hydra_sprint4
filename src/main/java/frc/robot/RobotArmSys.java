package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RobotArmSys extends SubsystemBase {

    public Joystick joy = new Joystick(Constants.JoystickPort);

    private VictorSPX arm_Motor = new VictorSPX(Constants.arm_MotorPort);
    private VictorSPX claw_Motor = new VictorSPX(Constants.claw_MotorPort);

    public double armEncoder2Deg;
    public double clawEncoder2Deg;
    public int armNumber = 0;
    public int clawNumber = 0;
    public int pov;
    
    //Initializer
    public RobotArmSys() {
        arm_Motor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
        claw_Motor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 10);
        resetEncoders();
    }

    public void setArm(double Speed) {
        arm_Motor.set(ControlMode.PercentOutput, Speed);
    }

    public void setClaw(double Speed) {
        claw_Motor.set(ControlMode.PercentOutput, Speed);
    }

    public void stopArm() {
        armNumber = 0;
        arm_Motor.set(ControlMode.PercentOutput, 0);
    }

    public void stopClaw() {
        clawNumber = 0;
        claw_Motor.set(ControlMode.PercentOutput, 0);
    }

    public void resetEncoders() {
        arm_Motor.setSelectedSensorPosition(0);
        claw_Motor.setSelectedSensorPosition(0);
    }

    public void periodic() {   
        pov = joy.getPOV();
        
        SmartDashboard.putNumber("POV", pov);
        SmartDashboard.putNumber("armNum", armNumber);
        SmartDashboard.putNumber("clawNum", clawNumber);
    }

}
