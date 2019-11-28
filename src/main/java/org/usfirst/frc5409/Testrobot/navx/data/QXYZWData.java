package org.usfirst.frc5409.Testrobot.navx.data;

import org.usfirst.frc5409.Testrobot.navx.NavXData;

/**
 * Gryoscopic Quaternion (X Y Z W) data container.
 * Packaged from gyro data on NavX MXP.
 * 
 * @author Keith Davies
 */
public class QXYZWData extends NavXData {
    /**
     * Construct blank QXYZW data container.
     */
    public QXYZWData() {
        qx = 0;
        qy = 0;
        qz = 0;
        qw = 0;
    }

    /**
     * Construct QXYZW data container with
     * quaternion data parameters.
     * 
     * @param qx Quaternion X
     * @param qy Quaternion Y
     * @param qz Quaternion Z
     * @param qw Quaternion W
     */
    public QXYZWData(double qx, double qy, double qz, double qw) {
        this.qx = qx;
        this.qy = qy;
        this.qz = qz;
        this.qw = qz;
    }

    /**
     * {@inheritDoc}
     */
    public static QXYZWData fromRaw(byte raw_data[]) {
        check(raw_data, m_raw_data_length);
        return new QXYZWData(
            cv.decodeSignedPiRadians(raw_data, 0), // Quaternion X
            cv.decodeSignedPiRadians(raw_data, 2), // Quaternion Y
            cv.decodeSignedPiRadians(raw_data, 4), // Quaternion Z
            cv.decodeSignedPiRadians(raw_data, 6)  // Quaternion W
        );
    }

    /**
     * Quaternion X
     */
    public double qx;

    /**
     * Quaternion Y
     */
    public double qy;

    /**
     * Quaternion Z
     */
    public double qz;

    /**
     * Quaternion W
     */
    public double qw;

    /**
     * {@inheritDoc}
     */
    private static final int m_raw_data_length = 8;
}