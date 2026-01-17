package org.firstinspires.ftc.teamcode.subsystems;

import dev.nextftc.core.commands.Command;
import dev.nextftc.core.subsystems.Subsystem;
import dev.nextftc.hardware.impl.MotorEx;
import dev.nextftc.hardware.powerable.SetPower;

public class Transfer implements Subsystem {
    // put hardware, commands, etc here
    private MotorEx transfer = new MotorEx("transfer");
    public static double tP = 0.8;
    public Command transBall = new SetPower(transfer,tP);
    public Command deTransBall = new SetPower(transfer,-tP);

    @Override
    public void initialize() {
        // initialization logic (runs on init)
    }

    @Override
    public void periodic() {
        // periodic logic (runs every loop)
    }
}