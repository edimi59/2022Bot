package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
public class IntakeSubsystem extends SubsystemBase {
  TalonFX intake1 = new TalonFX(5);
  TalonFX intake2  = new TalonFX(6);
  public IntakeSubsystem() {}
  public void IntakeBalls() {
      intake1.set(ControlMode.PercentOutput, .5);
      intake2.set(ControlMode.PercentOutput, .5);      
  }
  public void ToggleMiddle(boolean isOn){
    if (isOn){
      intake2.set(ControlMode.PercentOutput, .5);
    }
    else {
      intake2.set(ControlMode.PercentOutput, 0);
    }

  }
  public void Reverse(){
    intake1.set(ControlMode.PercentOutput, -.5);
    intake2.set(ControlMode.PercentOutput, -.5);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
}