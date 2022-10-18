package vg.utils;

/**
 *  Static class with resolutions in pixels.
 */
public final class DimensionUtils {

    public static int DEFAULT_WIDTH = 1400;
    public static int DEFAULT_HEIGHT = 950;

    /**
     * width 4k.
     */
    private static final double WIDTH_4K   = 3840;
    /**
     * height 4k.
     */
    private static final double HEIGHT_4K  = 2160;
    /**
     * width full HD.
     */
    private static final double WIDTH_FHD  = 1920;
    /**
     * height full HD.
     */
    private static final double HEIGHT_FHD = 1080;
    /**
     * width HD.
     */
    private static final double WIDTH_HD   = 1280;
    /**
     * height HD.
     */
    private static final double HEIGHT_HD  =  720;
    /**
     * Native scaling is 4k so the factor is 1.
     */
    private static final double SCALE_BASE = 1;
    /**
     * Scaling factor for FHD (0.5).
     */
    private static final double SCALE_FHD = HEIGHT_FHD / HEIGHT_4K;
    /**
     * Scaling factor for HD (0.333).
     */
    private static final double SCALE_HD  = HEIGHT_HD  / HEIGHT_4K;

}
