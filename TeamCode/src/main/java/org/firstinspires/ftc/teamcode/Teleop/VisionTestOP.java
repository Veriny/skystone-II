package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Subsystems.SkystoneContour;
import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvInternalCamera;

import javax.crypto.spec.OAEPParameterSpec;

public class VisionTestOP extends OpMode {
    public Drivetrain robot;
    public SkystoneContour vision;
    public OpenCvCamera phoneCam;
    @Override
    public void init() {
        robot = new Drivetrain(hardwareMap.dcMotor.get("topRight"), hardwareMap.dcMotor.get("bottomRight"), hardwareMap.dcMotor.get("topLeft"), hardwareMap.dcMotor.get("bottomRight"), false, telemetry);
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        phoneCam = OpenCvCameraFactory.getInstance().createInternalCamera(OpenCvInternalCamera.CameraDirection.BACK, cameraMonitorViewId);

    }

    @Override
    public void start() {
        phoneCam.openCameraDevice();
        phoneCam.setPipeline(vision);

    }

    @Override
    public void loop() {
        phoneCam.startStreaming(320, 240, OpenCvCameraRotation.UPRIGHT);
        telemetry.addData("Frame Count", phoneCam.getFrameCount());
        telemetry.addData("FPS", String.format("%.2f", phoneCam.getFps()));
        telemetry.addData("Total frame time ms", phoneCam.getTotalFrameTimeMs());
        telemetry.addData("Pipeline time ms", phoneCam.getPipelineTimeMs());
        telemetry.addData("Overhead time ms", phoneCam.getOverheadTimeMs());
        telemetry.addData("Theoretical max FPS", phoneCam.getCurrentPipelineMaxFps());
        telemetry.update();
    }

    @Override
    public void stop() {

    }
}
