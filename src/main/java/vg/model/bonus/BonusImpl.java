package vg.model.bonus;

public class BonusImpl implements Bonus {
    /**
     *Time duration of bonus.*/
    private double duration;
    /**
     * Typology of bonus.*/
    private BonusType type;

    @Override
    public final Boolean isActive() {
        return duration > 0;
    }

    @Override
    public final BonusType getType() {
        return this.type;
    }

    @Override
    public void updateBonusTimer(final double elapsedTime) {
        if (this.isActive() && elapsedTime < duration) {
            this.duration = this.duration - elapsedTime;
        } else if (this.isActive() && elapsedTime > duration) {
            this.duration = 0;
        }
    }
}
