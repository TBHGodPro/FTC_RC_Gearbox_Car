package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.MainOp;

public class Drive extends Subsystem {
    public final DcMotorEx motor1;
//    public final DcMotorEx motor2;

    public Drive(MainOp op) {
        super(op);

        motor1 = hwMap.get(DcMotorEx.class, "motor1");
//        motor2 = hwMap.get(DcMotorEx.class, "motor2");
    }
}
