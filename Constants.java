// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static double aimErrorTolerance = 1;
    public static double autoDistance = -12500;
    public static double turretSpeed = .5;
    public static double shortShooterSpeed = -.475;
    public static double normalShooterSpeed = -.835;
    public static double shooterIntakeSpeed = -.5;
    public static double frontIntakeSpeed = -.5;
    public static double climberSpeed = .8;
    public static double intakeSpeed = .5;
    public static double intakeMoverSpeed = .17;
    public static double turnAngle = 160;
    public static double velocityThreshold = -6500;
    public static double shortVelocityThreshold = -5000;
    // dont edit
    public static double frontIntakePosStop = 28600;

    
}
