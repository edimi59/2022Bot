package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
public class FrontIntakeSubsystem extends SubsystemBase {
  TalonFX intakeMover = new TalonFX(9);
  TalonSRX frontIntake  = new TalonSRX(10);
  public FrontIntakeSubsystem() {}
  public void setIntake(boolean on) {
      if (on) {
      frontIntake.set(ControlMode.PercentOutput, .5);

      }
      else {
        frontIntake.set(ControlMode.PercentOutput, 0);          
      }      
  }
  public void moveIntake(String direction) {
    if (direction == "up") {
        intakeMover.set(ControlMode.PercentOutput, .25);
    }
    else if (direction == "down") {
        intakeMover.set(ControlMode.PercentOutput, -.25);
    }
    else if (direction == "stop") {
        intakeMover.set(ControlMode.PercentOutput, 0);
    }
  }
  public void Reverse(){
      frontIntake.set(ControlMode.PercentOutput, -.5);
  }
  public double getFrontIntakePos(){
      double position = intakeMover.getSelectedSensorPosition();
      return position;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
}
