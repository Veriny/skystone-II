package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

public class Intake {
    private DcMotor left;
    private DcMotor right;
    public Intake(DcMotor left, DcMotor right) {
        this.left = left;
        this.right = right;
    }

    public void controls(Gamepad gp) {
        if (gp.a) succ(1);
        else if (gp.b) dontsucc(1);
    }

    public synchronized void succ(int power) {
        left.setPower(power);
        right.setPower(-power);
    }

    public synchronized void dontsucc(int power) {
        left.setPower(-power);
        right.setPower(power);
    }
}
