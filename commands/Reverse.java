package frc.robot.commands;

import frc.robot.subsystems.FrontIntakeSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
/** An example command that uses an example subsystem. */
public class Reverse extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final IntakeSubsystem m_IntakeSubsystem;
  private final FrontIntakeSubsystem m_FrontIntakeSubsystem;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public Reverse(IntakeSubsystem subsystem, FrontIntakeSubsystem subsystem2) {
    m_IntakeSubsystem = subsystem;
    m_FrontIntakeSubsystem = subsystem2;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
    addRequirements(subsystem2);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println("Intake reverse");
    m_IntakeSubsystem.Reverse();
    m_FrontIntakeSubsystem.Reverse();
  }
    @Override
  public void end(boolean interrupted){
    System.out.println("Intake reverse end");
      m_FrontIntakeSubsystem.setIntake(true);
      m_IntakeSubsystem.IntakeBalls();
  }

  // Called once the command ends or is interrupted.
}
