package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
// TalonFX for our motor and ControlMode to use a percent for our motors
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import frc.robot.Constants;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
//import com.ctre.phoenix.motorcontrol.can.TalonFX;
//import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class ShootingSubsystem extends SubsystemBase {
 
  public double getXvalue(){
     //get the x value from the limelight
     NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight"); //get all values from the limelight
     NetworkTableEntry tx = table.getEntry("tx"); //get the x cordinate from the table
     double x=tx.getDouble(0); //make a double 'x' variable ; if it doesnt find the value set it to 0
        return x;
      }
  
  private TalonFX Motor = new TalonFX(4);
  private TalonFX shooter = new TalonFX(7);
  private TalonFX shooterIntake = new TalonFX(10);
  public boolean shortDistance = false;
  public void move(double xvalue){
    //Motor.configForwardSoftLimitThreshold(1500, 0);
    //Motor.configReverseSoftLimitThreshold(-1500, 0);
    //Motor.configForwardSoftLimitEnable(true, 0);
    //Motor.configReverseSoftLimitEnable(true, 0);
    if(xvalue > Constants.aimErrorTolerance) {
        System.out.println("moving right");
        Motor.set(ControlMode.PercentOutput, Constants.turretSpeed);
      }
    else if (xvalue < -Constants.aimErrorTolerance){
      System.out.println("moving left");
      Motor.set(ControlMode.PercentOutput, -Constants.turretSpeed);
    }
    //else{
     // Motor.set(ControlMode.PercentOutput, 0);
    //}
  }
  public boolean inShot(double xvalue){
    if (!(xvalue < -Constants.aimErrorTolerance) && !(xvalue > Constants.aimErrorTolerance)) {
      System.out.println("aimed");
      Motor.set(ControlMode.PercentOutput, 0);
      return true;
    }
    else {return false;}
  }
  public double getDistance(){
    if (shortDistance){
      return Constants.shortShooterSpeed;
    }
    else{
      return Constants.normalShooterSpeed;
    }
  }
  public void setShooter(boolean isOn){
    if (isOn){
    shooter.set(ControlMode.PercentOutput,getDistance());
    System.out.println(shooter.getSelectedSensorVelocity());
      if (shooter.getSelectedSensorVelocity() < -10000){
        shooterIntake.set(ControlMode.PercentOutput, Constants.shooterIntakeSpeed);
      }
      else if (shortDistance && shooter.getSelectedSensorVelocity() < -5500){
        shooterIntake.set(ControlMode.PercentOutput, Constants.shooterIntakeSpeed);
      }
      else{
        shooterIntake.set(ControlMode.PercentOutput, 0);
      }
    }
    else{
    shooter.set(ControlMode.PercentOutput, 0);
    shooterIntake.set(ControlMode.PercentOutput, 0);
    }
  }
  public void turnMan(String direction){
    if(direction == "left") {
        System.out.println("moving left");
        Motor.set(ControlMode.PercentOutput, Constants.turretSpeed);
      }
    else if(direction == "right") {
      System.out.println("moving left");
      Motor.set(ControlMode.PercentOutput, -Constants.turretSpeed);
    }
    else if (direction == "stop"){
      Motor.set(ControlMode.PercentOutput, 0);
    }
  }
  public double getLimelightDistance(){
    // gets networktable values from limelight
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry ty = table.getEntry("ty");
    // gets y value from limelight
    double y = ty.getDouble(0);
    // uses equation to estimate distance 
    // d = (h2-h1) / tan(a1+a2)
    double last_part = Math.tan(Math.toRadians(27) + Math.toRadians(y));
    double distance = (104-36)/last_part;
    // prints distance for debugging purposes
    System.out.println(distance);
    //h1 36 inch
    // A1 46 degrees
    // H2 104 inches
    return distance;
  }
    // Encoder encoder = new Encoder(0, 1, false, Encoder.EncodingType.k2X);
    /*
    TalonFX shootingMotor = new TalonFX(5);

    

    public double GetEncoderValue(){
        
        return shootingMotor.getSelectedSensorPosition();
    }*/
}