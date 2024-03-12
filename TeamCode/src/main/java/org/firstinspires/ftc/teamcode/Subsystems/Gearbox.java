package org.firstinspires.ftc.teamcode.Subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.MainOp;

@Config
public class Gearbox extends Subsystem {
    // --- CONSTANTS ---

    public static int startWaitTime = 500;
    public static int endWaitTime = 500;

    public static double gear1 = 0;
    public static double gear2 = 0;
    public static double gear3 = 0;

    // -----------------

    public final Servo shifter;
    public ShiftingState state;

    public ElapsedTime timer = new ElapsedTime();

    public int currentGear;
    public int targetGear;

    public enum ShiftingState {
        STOPPED, WAIT_START, SHIFT, WAIT_END,
    }

    public Gearbox(MainOp op) {
        super(op);

        this.shifter = hwMap.get(Servo.class, "shifter");
        this.state = ShiftingState.STOPPED;

        this.currentGear = 1;
        this.targetGear = 1;

        this.shifter.setPosition(gear1);
    }

    public boolean isShifting() {
        return state != ShiftingState.STOPPED;
    }

    public void shiftUp() {
        if (isShifting() || currentGear == 3) return;
        timer.reset();
        this.targetGear += 1;
        this.state = ShiftingState.WAIT_START;
    }

    public void shiftDown() {
        if (isShifting() || currentGear == 1) return;
        timer.reset();
        this.targetGear -= 1;
        this.state = ShiftingState.WAIT_START;
    }

    public void update() {
        switch (state) {
            case STOPPED: {
                break;
            }

            case WAIT_START: {
                if (timer.milliseconds() >= startWaitTime) {
                    state = ShiftingState.SHIFT;
                    timer.reset();
                }
                break;
            }

            case SHIFT: {
                double pos = 0;
                if (targetGear == 1) pos = gear1;
                else if (targetGear == 2) pos = gear2;
                else if (targetGear == 3) pos = gear3;

                shifter.setPosition(pos);
                this.currentGear = targetGear;

                state = ShiftingState.WAIT_END;
                timer.reset();
                break;
            }

            case WAIT_END: {
                if (timer.milliseconds() >= endWaitTime) {
                    state = ShiftingState.STOPPED;
                    timer.reset();
                }
                break;
            }
        }
    }
}
