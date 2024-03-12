package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Subsystems.Drive;
import org.firstinspires.ftc.teamcode.Subsystems.Gearbox;
import org.firstinspires.ftc.teamcode.Subsystems.HubManager;
import org.firstinspires.ftc.teamcode.Subsystems.InputController;

@TeleOp()
public class MainOp extends OpMode {
    public FtcDashboard dashboard;

    public Gamepad gamepad;

    public HubManager hubs;
    public InputController inputs;
    public Drive drive;
    public Gearbox gearbox;

    @Override
    public void init() {
        this.dashboard = FtcDashboard.getInstance();

        this.gamepad = gamepad1;

        try {
            this.hubs = new HubManager(hardwareMap);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        hubs.useManualCaching();
        hubs.updateCache();

        this.inputs = new InputController(gamepad);

        this.drive = new Drive(this);
        this.gearbox = new Gearbox(this);
    }

    @Override
    public void init_loop() {
        hubs.updateCache();
    }

    @Override
    public void start() {
        hubs.updateCache();
    }

    @Override
    public void loop() {
        hubs.updateCache();

        inputs.update();

        if (inputs.shiftUp) gearbox.shiftUp();
        if (inputs.shiftDown) gearbox.shiftDown();

        gearbox.update();

        drive.update(inputs.throttle);
    }
}
