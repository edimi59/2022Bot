package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
public class IntakeSubsystem extends SubsystemBase {
  TalonFX intake1 = new TalonFX(8);
  TalonFX intake2  = new TalonFX(9);
  public IntakeSubsystem() {}
  public void IntakeBalls() {
      intake1.set(ControlMode.PercentOutput, Constants.intakeSpeed);
      intake2.set(ControlMode.PercentOutput, -Constants.intakeSpeed);      
  }
  public void StopIntake() {
    intake1.set(ControlMode.PercentOutput, 0);
    intake2.set(ControlMode.PercentOutput, 0);      
}
  public void ToggleMiddle(boolean isOn){
    if (isOn){
      intake2.set(ControlMode.PercentOutput, -Constants.intakeSpeed);
    }
    else {
      intake2.set(ControlMode.PercentOutput, 0);
    }

  }
  public void Reverse(){
    intake1.set(ControlMode.PercentOutput, -Constants.intakeSpeed);
    intake2.set(ControlMode.PercentOutput, Constants.intakeSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
}