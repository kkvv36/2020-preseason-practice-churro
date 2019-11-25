package org.usfirst.frc5409.Testrobot.limelight.lltype;

/**
 * Camera Mode on Limelight.
 */
public enum CameraMode {
    /**
     * Vision Camera Mode.
     */
    MODE_VISION (0),

    /**
     * Driver Camera Mode.
     */
    MODE_DRIVER (1);

    CameraMode(double value) {
        this.value = value;
    }

    public double get() {
        return value;
    }

    /**
     * Internal Camera Mode value.
     */
    private final double value;
}