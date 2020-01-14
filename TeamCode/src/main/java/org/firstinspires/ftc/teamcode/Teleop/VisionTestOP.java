package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Subsystems.SkystoneContour;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;

import javax.crypto.spec.OAEPParameterSpec;

public class VisionTestOP extends OpMode {
    public Drivetrain robot;
    public SkystoneContour vision;

    @Override
    public void init() {
        robot = new Drivetrain(hardwareMap.dcMotor.get("topRight"), hardwareMap.dcMotor.get("bottomRight"), hardwareMap.dcMotor.get("topLeft"), hardwareMap.dcMotor.get("bottomRight"), false, telemetry);

    }

    @Override
    public void start() {

    }

    @Override
    public void loop() {

    }

    @Override
    public void stop() {

    }
}
