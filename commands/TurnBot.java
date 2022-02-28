// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.ADIS16470_IMU;
/** An example command that uses an example subsystem. */
public class TurnBot extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveSubsystem m_DriveSubsystem;
  private ADIS16470_IMU gyro;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public TurnBot(DriveSubsystem subsystem) {
    m_DriveSubsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    gyro.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (gyro.getAngle() > 180){
     m_DriveSubsystem.driveBot(.1, .1);
  }
  else{
     m_DriveSubsystem.driveBot(0, 0);
  }
}
@Override
public boolean isFinished() {
    if (gyro.getAngle() > 180){
      return true;
    }
    else {return false;}
  }
  public void end(boolean interrupted){
    System.out.println("turn stop");
    m_DriveSubsystem.driveBot(0, 0);
  }


  // Called once the command ends or is interrupted.
}

