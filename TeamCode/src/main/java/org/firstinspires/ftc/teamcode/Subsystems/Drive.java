package org.firstinspires.ftc.teamcode.Subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.MainOp;

@Config
public class Drive extends Subsystem {
    // --- Constants ---

    public static double maxVelo;

    // -----------------

    public final DcMotorEx motor1;
//    public final DcMotorEx motor2;

    public Drive(MainOp op) {
        super(op);

        motor1 = hwMap.get(DcMotorEx.class, "motor1");
//        motor2 = hwMap.get(DcMotorEx.class, "motor2");

        motor1.setDirection(DcMotorSimple.Direction.FORWARD);
        motor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        motor1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    // TODO: Use throttle to actually control power, and use float (set power 0) to clutch

    public void update(double throttle) {
        if (op.gearbox.isShifting()) {
            // Do Nothing
        } else {
            motor1.setVelocity(maxVelo * throttle);
//            motor2.setVelocity(maxVelo * throttle);
        }
    }
}
