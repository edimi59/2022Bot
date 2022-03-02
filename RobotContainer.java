// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.Aim;
import frc.robot.commands.ClimberDown;
import frc.robot.commands.ClimberStop;
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
import frc.robot.commands.ToggleMidOff;
import frc.robot.commands.ToggleMidOn;
import frc.robot.commands.TurnBot;
import frc.robot.commands.distanceToggle;
import frc.robot.commands.intakeBallsCommand;
import frc.robot.commands.turnTurretLeft;
import frc.robot.commands.turnTurretRight;
import frc.robot.commands.turnTurretStop;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.FrontIntakeSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
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
  private final Aim m_aim = new Aim(m_ShootingSubsystem);
  private final Reverse m_Reverse = new Reverse(m_intakeSubsystem,m_FrontintakeSubsystem);
  private final ToggleMidOn m_ToggleMidOn = new ToggleMidOn(m_intakeSubsystem);
  private final ToggleMidOff m_ToggleMidOff = new ToggleMidOff(m_intakeSubsystem);
  private final turnTurretLeft m_turnTurretLeft = new turnTurretLeft(m_ShootingSubsystem);
  private final turnTurretRight m_turnTurretRight = new turnTurretRight(m_ShootingSubsystem);
  private final turnTurretStop m_turnTurretStop = new turnTurretStop(m_ShootingSubsystem);
  private final StopIntake m_stopintake = new StopIntake(m_intakeSubsystem);
  private final distanceToggle m_distanceToggle = new distanceToggle(m_ShootingSubsystem);
  private final ClimberUp m_ClimberUp = new ClimberUp(m_ClimberSubsystem);
  private final ClimberDown m_ClimberDown = new ClimberDown(m_ClimberSubsystem);
  private final ClimberStop m_ClimberStop = new ClimberStop(m_ClimberSubsystem);

  
  private final SequentialCommandGroup AutoCommand = new SequentialCommandGroup(new FrontIntakeDown(m_FrontintakeSubsystem), new IntakeOn(m_FrontintakeSubsystem),new DriveForward(m_driveSubsystem), new TurnBot(m_driveSubsystem),new Aim(m_ShootingSubsystem), new Shoot(m_ShootingSubsystem));
  
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
    //m_intakeSubsystem.setDefaultCommand(m_intakeballscommand);
    m_ShootingSubsystem.setDefaultCommand(m_turnTurretStop);
    m_ClimberSubsystem.setDefaultCommand(m_ClimberStop);
   // POVButton dpadUp = new POVButton(xbox, 0);
   // POVButton dpadDown = new POVButton(xbox, 180);
   // JoystickButton buttonA = new JoystickButton(xbox, 1);
   // JoystickButton buttonB = new JoystickButton(xbox, 2);
   // JoystickButton buttonY = new JoystickButton(xbox, 3);
    JoystickButton buttonRB = new JoystickButton(xbox, 6);
    JoystickButton buttonLB = new JoystickButton(xbox, 5);
   // JoystickButton buttonSelect = new JoystickButton(xbox, 7);
   // JoystickButton buttonStart = new JoystickButton(xbox, 8);
   // JoystickButton buttonLeft = new JoystickButton(xbox, 9);
   // JoystickButton buttonRight = new JoystickButton(xbox, 10);
    JoystickButton buttonThumb = new JoystickButton(logitech, 2);
    JoystickButton buttonTrigger = new JoystickButton(logitech, 1);
    JoystickButton button3 = new JoystickButton(logitech, 3);
    JoystickButton button4 = new JoystickButton(logitech, 4);
    POVButton logiUp = new POVButton(logitech, 0);
    POVButton LogiDown = new POVButton(logitech, 180);
    JoystickButton button5 = new JoystickButton(logitech, 5);
    JoystickButton button6 = new JoystickButton(logitech, 6);
    JoystickButton button7 = new JoystickButton(logitech, 7);
    JoystickButton button8 = new JoystickButton(logitech, 8);
    JoystickButton button9 = new JoystickButton(logitech, 9);
    JoystickButton button10 = new JoystickButton(logitech, 10);
    JoystickButton button11 = new JoystickButton(logitech, 11);
    JoystickButton button12 = new JoystickButton(logitech, 12);


    logiUp
      .whenHeld(m_FrontIntakeUp);
    LogiDown
      .whenHeld(m_FrontIntakeDown);
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
    buttonThumb
      .whileActiveContinuous(m_aim);
    button5
      .whenHeld(m_ToggleMidOff);
    button6
      .whenHeld(m_ToggleMidOn);
    button8
      .whenHeld(m_turnTurretLeft);
    button7
      .whenHeld(m_turnTurretRight);
    button12
      .whenPressed(m_intakeballscommand);
    button11
      .whenPressed(m_stopintake);
    button4
      .whenPressed(m_distanceToggle);
    buttonLB
      .whenPressed(m_ClimberUp);
    buttonRB
      .whenPressed(m_ClimberDown);
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
