package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.Subsystems.Intake;

@Autonomous(name="Red(Stoneside)_Collect_Deposit_FoundationDrag_Park", group = "test")
public class Auto_Red_Stoneside extends LinearOpMode {
    public Drivetrain robot;
    public Intake intake;
    private ElapsedTime time;

    @Override
    public void runOpMode() throws InterruptedException {
        robot = new Drivetrain(hardwareMap.dcMotor.get("topLeftMotor"), hardwareMap.dcMotor.get("bottomLeftMotor"), hardwareMap.dcMotor.get("topRightMotor"), hardwareMap.dcMotor.get("bottomRightMotor"), true, telemetry);
        intake = new Intake(hardwareMap.dcMotor.get("leftIntake"), hardwareMap.dcMotor.get("rightIntake"));
        time = new ElapsedTime();

        waitForStart();
        robot.strafe(24, 1.0);

        boolean hasSkystone = false;
        for(int i = 0; i < 3; i++) {
            if (!robot.skystoneIsCentered()) {
                robot.drive(8, 0.5);
            }
            else {
                robot.turn(90, 0.5);
                intake.succ(0.69420);
                robot.drive(12, 0.8);
                intake.noSucc();
                robot.drive(-12, 1.0);
                hasSkystone = true;
                return;
            }
        }

        if(!hasSkystone) {
            robot.turn(90, 0.5);
            intake.succ(0.69420);
            robot.drive(12, 0.8);
            intake.noSucc();
            robot.drive(-12, 1.0);
        }

        robot.strafe(84, 1.0);
        robot.turn(-90, 0.5);
        robot.drive(-12, 0.5);
        //foundation claw
        robot.drive(36, 0.5);
        //drop skystone
        //release foundation
        robot.drive(-1, 0.5);
        robot.strafe(48, 1.0);



    }
}
