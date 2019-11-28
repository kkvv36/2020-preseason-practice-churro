package org.usfirst.frc5409.Testrobot.navx.data;

/**
 * Raw data conversion functions for NavX.
 * 
 * @author Keith
 */
final class cv { //SOME FUNCTIONS NEED TESTING.
    private static short sxFF = (short) 0xFF;
    private static int   ixFF = (int)   0xFF;
    private static long  lxFF = (long)  0xFF;

    /**
     * Decode Unsigned Byte. (8-bit)
     * 
     * @param data Raw byte data
     * @param i Index offset
     * 
     * @return Unsigned Byte
     */
    public static short decodeUnsignedByte(byte data[], int i) { 
        return (short) (data[i] & sxFF);
    }

    /**
     * Decode Unsigned Byte. (8-bit)
     * 
     * @param data Raw byte
     * 
     * @return Unsigned Byte (short)
     */
    public static short decodeUnsignedByte(byte data) {
        return (short) (data & sxFF);
    }

    /**
     * Decode Signed Short. (16-bit)
     * 
     * @param data Raw byte data
     * @param i Index offset
     * 
     * @return Signed short
     */
    public static short decodeSignedShort(byte data[], int i) {
        return (short) ( 
            ( data[i + 0]         << 8 ) |
            ((data[i + 1] & sxFF)      )   
        );
    }

    /**
     * Decode Unsigned Short. (16-bit)
     * 
     * @param data Raw byte data
     * @param i Index offset
     * 
     * @return Unsigned short (int)
     */
    public static int decodeUnsignedShort(byte data[], int i) {
        return (int) ( 
            ((data[i + 0] & ixFF) << 8 ) |
            ((data[i + 1] & ixFF)      )   
        );
    }

    /**
     * Decode Signed Integer. (32-bit)
     * 
     * @param data Raw byte data
     * @param i Index offset
     * 
     * @return Signed Integer
     */
    public static int decodeSignedInt(byte data[], int i) {
        return (int) ( 
            ( data[i + 0]         << 24) |
            ((data[i + 1] & ixFF) << 16) |
            ((data[i + 2] & ixFF) << 8 ) |
            ((data[i + 3] & ixFF)      )
        );
    }

    /**
     * Decode Unsigned Integer. (32-bit)
     * 
     * @param data Raw byte data
     * @param i Index offset
     * 
     * @return Unsigned Integer
     */
    public static long decodeUnsignedInt(byte data[], int i) {
        return (long) ( 
            ((data[i + 0] & lxFF) << 24L) |
            ((data[i + 1] & lxFF) << 16L) |
            ((data[i + 2] & lxFF) << 8L ) |
            ((data[i + 3] & lxFF)       )
        );
    }
    /**
     * Decode Signed Hundredths. (-327.68 to 327.67)
     * 
     * @param data Raw byte data
     * @param i Index offset
     * 
     * @return Double floating-point number
     */
    public static double decodeSignedHundredths(byte data[], int i) {
        return (double) (decodeSignedShort(data, i)) / 100.0d;
    }

    /**
     * Decode Unsigned Hundredths. (0.0 to 655.35)
     * 
     * @param data Raw byte data
     * @param i Index offset
     * 
     * @return Double floating-point number
     */
    public static double decodeUnsignedHundredths(byte data[], int i) {
        return (double) (decodeUnsignedShort(data, i)) / 100.0d;
    }

    /**
     * Decode Signed Thousandths. (-32.768 to 32.767)
     * 
     * @param data Raw byte data
     * @param i Index offset
     * 
     * @return Double floating-point number
     */
    public static double decodeSignedThousandths(byte data[], int i) {
        return (double) (decodeSignedShort(data, i)) / 1000.0d;
    }

    /**
     * Decode Signed Pi. (-2 to 2)
     * 
     * @param data Raw byte data
     * @param i Index offset
     * 
     * @return Double floating-point number
     */
    public static double decodeSignedPiRadians(byte data[], int i) {
        return (double) (decodeSignedShort(data, i)) / 16384.0d;
    }

    /**
     * Decode Q16.16 Number. (-32768.9999 to 32767.9999)
     * 
     * @param data Raw byte data
     * @param i Index offset
     * 
     * @return Double floating-point number
     */
    public static double decodeQ1616(byte data[], int i) {
        return (double) (decodeSignedInt(data, i)) / 65536.0d;
    }
}