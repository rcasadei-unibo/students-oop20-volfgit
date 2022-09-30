package vg.model.bonus;

public class BonusImpl implements Bonus{
    private double duration;
    private BonusType type;

    @Override
    public Boolean isActive() {
        return duration > 0;
    }

    @Override
    public BonusType getType() {
        return this.type;
    }

    @Override
    public void updateBonusTimer(double elapsedTime) {
        if (this.isActive() && elapsedTime < duration) {
            this.duration = this.duration - elapsedTime;
        }
        else if (this.isActive() && elapsedTime > duration) {
            this.duration = 0;
        }
    }
}
