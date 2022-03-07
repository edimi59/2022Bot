// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.ControlMode;
public class DriveSubsystem extends SubsystemBase {
  TalonFX leftFrontMotor = new TalonFX(3);
  TalonFX leftRearMotor = new TalonFX(2);
  TalonFX rightFrontMotor = new TalonFX(5);
  TalonFX rightRearMotor = new TalonFX(1);
  public DriveSubsystem() {}
  private double applyDeadband(double deadBand){
  if (Math.abs(deadBand)<.05){
    return 0;
  }
  else{
    return deadBand;
  }
}
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void driveBot(double left, double right) {
    leftFrontMotor.set(ControlMode.PercentOutput,applyDeadband(left));
    leftRearMotor.follow(leftFrontMotor);
    rightFrontMotor.set(ControlMode.PercentOutput, applyDeadband(right));
    rightRearMotor.follow(rightFrontMotor);

  }
  public double getLeftFrontPos(){
      return leftFrontMotor.getSelectedSensorPosition();
  }
  public void setLeftFrontPos(){
     leftFrontMotor.setSelectedSensorPosition(0);
}
}
