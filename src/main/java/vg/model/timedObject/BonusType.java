package vg.model.timedObject;

public enum BonusType {
    /**
     * Add extra score to current player score.
     */
    EXTRA_SCORE,
    /**
     * Stop all enemies from moving.
     */
    FREEZE_WORLD,
    /**
     * Remove all mosquitoes from map and get an extra score.
     */
    KILL_MOSQUITOES,
    /**
     * Improve player speed increasing speed of an amount.
     */
    PLAYER_SPEEDUP,
    /**
     * Enable ability of player to shoot only the mosquitoes.
     */
    PLAYER_SHOT,
    /**
     * Enable ability of player to shoot and kill only the Boss.
     */
    PLAYER_CANNON
}
