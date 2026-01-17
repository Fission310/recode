package org.firstinspires.ftc.teamcode.subsystems;

import dev.nextftc.control.ControlSystem;
import dev.nextftc.control.KineticState;
import dev.nextftc.core.commands.Command;
import dev.nextftc.core.commands.utility.InstantCommand;
import dev.nextftc.core.subsystems.Subsystem;
import dev.nextftc.hardware.controllable.MotorGroup;
import dev.nextftc.hardware.impl.MotorEx;

public class Shooter implements Subsystem {
    // put hardware, commands, etc here
    private MotorGroup shooter = new MotorGroup(
            new MotorEx("leftShoot").reversed(),
            new MotorEx("rightShoot")
    );
    private ControlSystem sC = ControlSystem.builder()
            .velPid(0.001,0.0,0.0)
            .build();
    public static double close = 1960;
    public static double far = 3920;
    private Command shootClose = new InstantCommand(() -> sC.setGoal(new KineticState(close)));
    private Command shootFar = new InstantCommand(() -> sC.setGoal(new KineticState(far)));
    public Command unshoot = new InstantCommand(() -> sC.setGoal(new KineticState(-close/4.0)));
    public Command stop = new InstantCommand(() -> sC.setGoal(new KineticState(0)));

    @Override
    public void initialize() {
        // initialization logic (runs on init)
        sC.setGoal(new KineticState(0));
    }

    @Override
    public void periodic() {
        // periodic logic (runs every loop)
        shooter.setPower(sC.calculate(new KineticState(
                shooter.getCurrentPosition(),
                shooter.getVelocity()
        )));
    }
}