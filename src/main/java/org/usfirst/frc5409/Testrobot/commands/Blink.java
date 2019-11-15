package org.usfirst.frc5409.Testrobot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5409.Testrobot.Robot;
import org.usfirst.frc5409.Testrobot.limelight.lltype;

public class Blink extends Command {
    public static long c_blink_period_ms = 1000;

    public Blink() {
        super("Blink");

        requires(Robot.limelight);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        Robot.limelight.setLedMode(lltype.LedMode.LED_ON);
        sleep();
        Robot.limelight.setLedMode(lltype.LedMode.LED_OFF);
        sleep();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
 
    }

    @Override
    protected void interrupted() {

    }

    private void sleep() {
        try {
            Thread.sleep(c_blink_period_ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
