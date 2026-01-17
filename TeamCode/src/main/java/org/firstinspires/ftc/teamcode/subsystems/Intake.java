package org.firstinspires.ftc.teamcode.subsystems;
import dev.nextftc.core.commands.Command;
import dev.nextftc.core.subsystems.Subsystem;
import dev.nextftc.hardware.impl.MotorEx;
import dev.nextftc.hardware.powerable.SetPower;

public class Intake implements Subsystem {
    // put hardware, commands, etc here
    public static double in = 1;
    private static double out = .5;

    private MotorEx intake = new MotorEx("intake");
    public Command suckBalls = new SetPower(intake,in);
    public Command spitBalls = new SetPower(intake,out);

    @Override
    public void initialize() {
        // initialization logic (runs on init)
    }

    @Override
    public void periodic() {
        // periodic logic (runs every loop)
    }
}