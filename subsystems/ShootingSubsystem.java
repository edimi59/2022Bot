package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
// TalonFX for our motor and ControlMode to use a percent for our motors
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
//import com.ctre.phoenix.motorcontrol.can.TalonFX;
//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class ShootingSubsystem extends SubsystemBase {
 
  public double getXvalue(){
     //get the x value from the limelight
     NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight"); //get all values from the limelight
     NetworkTableEntry tx = table.getEntry("tx"); //get the x cordinate from the table
     double x=tx.getDouble(0); //make a double 'x' variable ; if it doesnt find the value set it to 0
        return x;}
  
  private TalonFX Motor = new TalonFX(11);
  private TalonFX shooter = new TalonFX(14);
  private TalonFX shooterIntake = new TalonFX(15);
  
  public void move(double xvalue){
    Motor.configForwardSoftLimitThreshold(500, 0);
    Motor.configReverseSoftLimitThreshold(-500, 0);
    Motor.configForwardSoftLimitEnable(true, 0);
    Motor.configReverseSoftLimitEnable(true, 0);
    if(Motor.getSelectedSensorPosition()  < 1050) {
        System.out.println("moving right");
        Motor.set(ControlMode.PercentOutput, 0.15);
      }
    else if (xvalue < -Constants.aimErrorTolerance){
      System.out.println("moving left");
      Motor.set(ControlMode.PercentOutput, -0.15);
    }
    else{
      Motor.set(ControlMode.PercentOutput, 0);
    }
  }
  public boolean inShot(double xvalue){
    if (!(xvalue < -Constants.aimErrorTolerance) && !(Motor.getSelectedSensorPosition()  < 1050)) {
      System.out.println("aimed");
      Motor.set(ControlMode.PercentOutput, 0);
      return true;
    }
    else {return false;}
  }
  public void setShooter(boolean isOn){
    if (isOn){
    shooter.set(ControlMode.PercentOutput, 1);
    shooterIntake.set(ControlMode.PercentOutput, .1);
    }
    else{
    shooter.set(ControlMode.PercentOutput, 0);
    shooterIntake.set(ControlMode.PercentOutput, 0);
    }
  }
    // Encoder encoder = new Encoder(0, 1, false, Encoder.EncodingType.k2X);
    /*
    TalonFX shootingMotor = new TalonFX(5);

    

    public double GetEncoderValue(){
        
        return shootingMotor.getSelectedSensorPosition();
    }*/
}