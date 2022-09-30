package vg.model.bonus;

public interface Bonus {
    Boolean isActive();

    /** @return Typology of bonus collected by player */
    BonusType getType();

    /**
     * Call this method in order to update timer of bonus.
     * @param elapsedTime time elapsed from previous game loop cycle to current one
     * */
    void updateBonusTimer(double elapsedTime);
}
