package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class PhneumaticsSubsystem extends SubsystemBase{

    private final Compressor comp = new Compressor();
    private final DoubleSolenoid solenoid= new DoubleSolenoid(0,1); //not sure if it is double or single
 
    public void release()
    {
        solenoid.set(DoubleSolenoid.Value.kForward);
    }
    public void pull()
    {
        solenoid.set(DoubleSolenoid.Value.kResverse);
    }
}
