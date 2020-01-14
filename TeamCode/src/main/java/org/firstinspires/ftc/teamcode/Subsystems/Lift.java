package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

public class Lift {
    private DcMotor motor;
    public Lift(DcMotor motor) {
        this.motor = motor;
    }

    public void controls(Gamepad gp) {
        if (gp.y) {
            runMotor(-1);
        }
        else if (gp.x) {
            runMotor(1);
        }
        else  {
            runMotor(0);
        }

    }

    public synchronized void runMotor(int power) {
        motor.setPower(power);
    }

}
