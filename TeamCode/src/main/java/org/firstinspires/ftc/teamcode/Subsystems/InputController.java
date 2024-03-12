package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.Gamepad;

public class InputController {
    public final Gamepad gamepad;

    public boolean shiftUp = false;
    public boolean shiftDown = false;
    public double throttle = 0;
    public double turn = 0;

    public InputController(Gamepad gamepad) {
        this.gamepad = gamepad;
    }

    public void update() {
        // Shifting
        shiftUp = gamepad.a;
        shiftDown = gamepad.x || gamepad.b;

        // Throttle
        throttle = gamepad.right_trigger - gamepad.left_trigger;

        // Turning
        turn = gamepad.left_stick_x + gamepad.right_stick_x;
    }
}
