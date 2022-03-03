package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FrontIntakeSubsystem;
/** An example command that uses an example subsystem. */
public class IntakeOff extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final FrontIntakeSubsystem m_FrontIntakeSubsystem;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public IntakeOff(FrontIntakeSubsystem subsystem) {
    m_FrontIntakeSubsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println("Intake Off");
    m_FrontIntakeSubsystem.setIntake(false);
  }
  public boolean isFinished() {
    return true;
  }
}