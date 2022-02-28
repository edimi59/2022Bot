package frc.robot.commands;

import frc.robot.subsystems.ShootingSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
/** An example command that uses an example subsystem. */
public class turnTurretLeft extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ShootingSubsystem m_ShootingSubsystem;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public turnTurretLeft(ShootingSubsystem subsystem) {
    m_ShootingSubsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_ShootingSubsystem.turnMan("left");
  }
//@Override
//public boolean isFinished() {
//    return true;
//  }
@Override
public void end(boolean interrupted) {
    m_ShootingSubsystem.turnMan("stop");
  }


  // Called once the command ends or is interrupted.
}
