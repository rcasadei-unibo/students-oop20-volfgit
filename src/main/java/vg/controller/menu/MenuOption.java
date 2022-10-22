package vg.controller;

public enum MenuOption {
    PLAY(0),
    LEADERBOARDS(1),
    SETTINGS(2),
    CONTROLS(3),
    QUIT(4);

    private int value;
    MenuOption(final int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
