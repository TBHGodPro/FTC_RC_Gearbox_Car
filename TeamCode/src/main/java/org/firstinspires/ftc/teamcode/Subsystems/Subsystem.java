package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.MainOp;

public abstract class Subsystem {
    public final MainOp op;
    public final HardwareMap hwMap;

    public Subsystem(MainOp op) {
        this.op = op;
        this.hwMap = op.hardwareMap;
    }
}
