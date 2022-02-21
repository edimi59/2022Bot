// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.Aim;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.DriveForward;
import frc.robot.commands.FrontIntakeDown;
import frc.robot.commands.FrontIntakeUp;
import frc.robot.commands.IntakeOff;
import frc.robot.commands.IntakeOn;
import frc.robot.commands.Reverse;
import frc.robot.commands.Shoot;
import frc.robot.commands.ToggleMidOff;
import frc.robot.commands.ToggleMidOn;
import frc.robot.commands.TurnBot;
import frc.robot.commands.intakeBallsCommand;
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

  private final FrontIntakeUp m_FrontIntakeUp = new FrontIntakeUp(m_FrontintakeSubsystem);

  private final FrontIntakeDown m_FrontIntakeDown = new FrontIntakeDown(m_FrontintakeSubsystem);

  private final IntakeOn m_IntakeOn = new IntakeOn(m_FrontintakeSubsystem);
  private final Shoot m_shoot = new Shoot(m_ShootingSubsystem);
  private final IntakeOff m_IntakeOff = new IntakeOff(m_FrontintakeSubsystem);
  private final Aim m_aim = new Aim(m_ShootingSubsystem);
  private final Reverse m_Reverse = new Reverse(m_intakeSubsystem,m_FrontintakeSubsystem);
  private final ToggleMidOn m_ToggleMidOn = new ToggleMidOn(m_intakeSubsystem);
  private final ToggleMidOff m_ToggleMidOff = new ToggleMidOff(m_intakeSubsystem);
  private final SequentialCommandGroup AutoCommand = new SequentialCommandGroup(new FrontIntakeDown(m_FrontintakeSubsystem), new IntakeOn(m_FrontintakeSubsystem),new DriveForward(m_driveSubsystem), new TurnBot(m_driveSubsystem), new Aim(m_ShootingSubsystem), new Shoot(m_ShootingSubsystem));
  private Joystick xbox = new Joystick(0);
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
    m_intakeSubsystem.setDefaultCommand(m_intakeballscommand);
    POVButton dpadUp = new POVButton(xbox, 0);
    POVButton dpadDown = new POVButton(xbox, 180);
    JoystickButton buttonA = new JoystickButton(xbox, 1);
    JoystickButton buttonB = new JoystickButton(xbox, 2);
    JoystickButton buttonY = new JoystickButton(xbox, 3);
    JoystickButton buttonRB = new JoystickButton(xbox, 6);
    JoystickButton buttonLB = new JoystickButton(xbox, 5);
    JoystickButton buttonSelect = new JoystickButton(xbox, 7);
    JoystickButton buttonStart = new JoystickButton(xbox, 8);

    dpadUp
      .whenHeld(m_FrontIntakeUp);
    dpadDown
      .whenHeld(m_FrontIntakeDown);
    buttonA
      .whenHeld(m_IntakeOn);
    buttonB
      .whenHeld(m_IntakeOff);
    buttonY
      .whenHeld(m_Reverse);
    buttonRB
      .whenHeld(m_shoot);
    buttonLB
      .whenHeld(m_aim);
    buttonSelect
      .whenHeld(m_ToggleMidOff);
    buttonStart
      .whenHeld(m_ToggleMidOn);
    
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
