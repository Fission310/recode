package org.firstinspires.ftc.teamcode.opmodes;

import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Shooter;
import org.firstinspires.ftc.teamcode.subsystems.Transfer;

import dev.nextftc.core.components.SubsystemComponent;
import dev.nextftc.ftc.Gamepads;
import dev.nextftc.ftc.NextFTCOpMode;
import dev.nextftc.hardware.driving.FieldCentric;
import dev.nextftc.hardware.driving.MecanumDriverControlled;
import dev.nextftc.hardware.impl.Direction;
import dev.nextftc.hardware.impl.IMUEx;
import dev.nextftc.hardware.impl.MotorEx;

public class teleop extends NextFTCOpMode {
    {
        addComponents(
                new SubsystemComponent(new Intake()),
                new SubsystemComponent(new Shooter()),
                new SubsystemComponent(new Transfer())
                //,new SubsystemComponent(new Limelight())

        );
    }
    private MotorEx frontLeftMotor = new MotorEx("leftFront").brakeMode();
    private MotorEx frontRightMotor = new MotorEx("rightFront").brakeMode();
    private MotorEx backLeftMotor = new MotorEx("leftRear").brakeMode().reversed();
    private MotorEx backRightMotor = new MotorEx("rightRear").brakeMode();
    private IMUEx imu = new IMUEx("imu", Direction.LEFT, Direction.BACKWARD).zeroed();
    private MecanumDriverControlled driverControlled;
    @Override public void onInit(){

    }
    public void onWaitForStart(){

    }
    public void onStartButtonPressed(){
        driverControlled = new MecanumDriverControlled(
                frontLeftMotor,
                frontRightMotor,
                backLeftMotor,
                backRightMotor,
                Gamepads.gamepad1().leftStickY().negate(),
                Gamepads.gamepad1().leftStickX(),
                Gamepads.gamepad1().rightStickX(),
                new FieldCentric(imu)
        );
        driverControlled.schedule();
    }
    public void onUpdate(){

    }
    public void onStop(){

    }
}