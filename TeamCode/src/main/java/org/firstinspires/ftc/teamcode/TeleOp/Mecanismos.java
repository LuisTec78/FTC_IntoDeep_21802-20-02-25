package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Subsystems.ClawSubsystem2;
import org.firstinspires.ftc.teamcode.Subsystems.ViperSubsystem2;

import kotlinx.coroutines.selects.WhileSelectKt;

@TeleOp
public class Mecanismos extends LinearOpMode {
    @Override
    public void runOpMode() {
        ViperSubsystem2 viper = new ViperSubsystem2(hardwareMap, 0.001, 0, 0.0001, 0.01, 0, 0);
        ClawSubsystem2 claw = new ClawSubsystem2(hardwareMap, gamepad2);

        waitForStart();
        while (opModeIsActive()) {
            viper.periodic(gamepad2);
            claw.periodic(gamepad2);

            telemetry.addData("targetExt", gamepad2.left_stick_y * 50);
            telemetry.addData("extension", viper.getExtension());
            telemetry.update();
        }
    }
}
