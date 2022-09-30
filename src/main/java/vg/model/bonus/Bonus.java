package vg.model.bonus;

public interface Bonus {
    /**
     * Bonus is active until duration is not zero */
    Boolean isActive();

    /** @return Typology of bonus collected by player */
    BonusType getType();

    /**
     * Call this method in order to update timer of bonus*/
    void updateBonusTimer(final double elapsedTime);
}
