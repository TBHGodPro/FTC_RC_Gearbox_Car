package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Subsystems.Drive;
import org.firstinspires.ftc.teamcode.Subsystems.Gearbox;
import org.firstinspires.ftc.teamcode.Subsystems.HubManager;

@TeleOp()
public class MainOp extends OpMode {
    public Gamepad gamepad;

    public HubManager hubs;
    public Drive drive;
    public Gearbox gearbox;

    @Override
    public void init() {
        this.gamepad = gamepad1;

        try {
            this.hubs = new HubManager(hardwareMap);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        hubs.useManualCaching();
        hubs.updateCache();

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


    }
}
