package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.ClimberDown;
import frc.robot.commands.ClimberUp;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.DriveForward;
import frc.robot.commands.FrontIntakeDown;
import frc.robot.commands.FrontIntakeUp;
import frc.robot.commands.IntakeOff;
import frc.robot.commands.IntakeOn;
import frc.robot.commands.Reverse;
import frc.robot.commands.Shoot;
import frc.robot.commands.ShooterOff;
import frc.robot.commands.StopIntake;
import frc.robot.commands.TurnBot;
import frc.robot.commands.distanceToggle;
import frc.robot.commands.intakeBallsCommand;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.FrontIntakeSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.subsystems.IntakeSubsystem;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
import frc.robot.subsystems.ShootingSubsystem;
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();

  private final DriveCommand m_driveCommand = new DriveCommand(m_driveSubsystem);

  private final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();

  private final intakeBallsCommand m_intakeballscommand = new intakeBallsCommand(m_intakeSubsystem);

  private final FrontIntakeSubsystem m_FrontintakeSubsystem = new FrontIntakeSubsystem();

  private final ShootingSubsystem m_ShootingSubsystem = new ShootingSubsystem();

  private final ClimberSubsystem m_ClimberSubsystem = new ClimberSubsystem();

  private final FrontIntakeUp m_FrontIntakeUp = new FrontIntakeUp(m_FrontintakeSubsystem);
  private final FrontIntakeDown m_FrontIntakeDown = new FrontIntakeDown(m_FrontintakeSubsystem);
  private final IntakeOn m_IntakeOn = new IntakeOn(m_FrontintakeSubsystem);
  private final Shoot m_shoot = new Shoot(m_ShootingSubsystem);
  private final ShooterOff m_shooterOff = new ShooterOff(m_ShootingSubsystem);
  private final IntakeOff m_IntakeOff = new IntakeOff(m_FrontintakeSubsystem);
  private final Reverse m_Reverse = new Reverse(m_intakeSubsystem,m_FrontintakeSubsystem);
  private final StopIntake m_stopintake = new StopIntake(m_intakeSubsystem);
  private final distanceToggle m_distanceToggle = new distanceToggle(m_ShootingSubsystem);
  private final ClimberUp m_ClimberUp = new ClimberUp(m_ClimberSubsystem);
  private final ClimberDown m_ClimberDown = new ClimberDown(m_ClimberSubsystem);
  
//  private final SequentialCommandGroup AutoCommand = new SequentialCommandGroup(new FrontIntakeDown(m_FrontintakeSubsystem), new IntakeOn(m_FrontintakeSubsystem), new intakeBallsCommand(m_intakeSubsystem), new DriveForward(m_driveSubsystem), new IntakeOff(m_FrontintakeSubsystem),new FrontIntakeUp(m_FrontintakeSubsystem),new TurnBot(m_driveSubsystem),new Aim(m_ShootingSubsystem), new Shoot(m_ShootingSubsystem));
private final SequentialCommandGroup AutoCommand = new SequentialCommandGroup(new intakeBallsCommand(m_intakeSubsystem), new Shoot(m_ShootingSubsystem), new WaitCommand(5), new DriveForward(m_driveSubsystem), new ShooterOff(m_ShootingSubsystem));

  private Joystick xbox = new Joystick(0);
  private Joystick logitech = new Joystick(1);
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    m_driveSubsystem.setDefaultCommand(m_driveCommand);
    JoystickButton buttonRB = new JoystickButton(xbox, 6);
    JoystickButton buttonLB = new JoystickButton(xbox, 5);
    JoystickButton buttonTrigger = new JoystickButton(logitech, 1);
    JoystickButton button3 = new JoystickButton(logitech, 3);
    JoystickButton button4 = new JoystickButton(logitech, 4);
    POVButton logiUp = new POVButton(logitech, 0);
    POVButton LogiDown = new POVButton(logitech, 180);
    JoystickButton button9 = new JoystickButton(logitech, 9);
    JoystickButton button10 = new JoystickButton(logitech, 10);
    JoystickButton button11 = new JoystickButton(logitech, 11);
    JoystickButton button12 = new JoystickButton(logitech, 12);


    logiUp
      .whileActiveContinuous(m_FrontIntakeUp);
    LogiDown
      .whileActiveContinuous(m_FrontIntakeDown);
    button10
      .whenHeld(m_IntakeOn);
    button9
      .whenHeld(m_IntakeOff);
    button3
      .whenHeld(m_Reverse);
    buttonTrigger
      .whileActiveContinuous(m_shoot);
    buttonTrigger
      .whenReleased(m_shooterOff);
    button12
      .whenPressed(m_intakeballscommand);
    button11
      .whenPressed(m_stopintake);
    button4
      .whenPressed(m_distanceToggle);
    buttonLB
      .whenHeld(m_ClimberUp);
    buttonRB
      .whenHeld(m_ClimberDown);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public SequentialCommandGroup getAuto(){
    return AutoCommand;
  }
}