package vg.utils;

public enum GameState {
    /**
     * Game level is running.
     */
    PLAYING,
    /**
     * Game level is paused.
     */
    PAUSED,
    /**
     * Player has been killed and did not complete level.
     */
    GAMEOVER,
    /**
     * Game level is not running.
     */
    STOPPED
}
