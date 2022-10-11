package vg.application;

/**
 * This class represents the Launcher of the system, otherwise the system will not
 * properly call javaFX calls.
 */
public final class Launcher {

    private Launcher() { }

    /**
     * @param args unused
     */
    public static void main(final String[] args) {
        Main.main(args);
    }
}
