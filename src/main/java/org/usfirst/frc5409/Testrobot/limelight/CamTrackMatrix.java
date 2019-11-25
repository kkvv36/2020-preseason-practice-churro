package org.usfirst.frc5409.Testrobot.limelight;

/**
 * Camera PNP Tracking Matrix
 */
public final class CamTrackMatrix {
    /**
     * Construct blank tracking matrix.
     */
    public CamTrackMatrix() {
        x     = 0;
        y     = 0;
        z     = 0;
        yaw   = 0;
        roll  = 0;
        ptch = 0;
    }

    /**
     * Construct tracking matrix with tracking data.
     * 
     * @param x    X position
     * @param y    Y position
     * @param z    Z position
     * @param yaw  Yaw orientation
     * @param ptch Pitch orientation
     * @param roll Roll orientation
     */
    public CamTrackMatrix(double x, double y, double z, double yaw, double ptch, double roll) {
        this.x    = x;
        this.y    = y;
        this.z    = z;
        this.yaw  = yaw;
        this.roll = roll;
        this.ptch = ptch;
    }

    /**
     * X position
     */
    public double x;

    /**
     * Y position
     */
    public double y;

    /**
     * Z position
     */
    public double z;

    /**
     * Yaw orientation
     */
    public double yaw;

    /**
     * Pitch orientation
     */
    public double ptch;

    /**
     * Roll orientation
     */
    public double roll;
}