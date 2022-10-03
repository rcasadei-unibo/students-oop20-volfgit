package vg.model.bonus;

public class BonusImpl extends TimedObjectImpl implements Bonus {
    /**
     * Typology of bonus.
     */
    private BonusType type;

    /**
     * {@inheritDoc}
     */
    @Override
    public final BonusType getType() {
        return this.type;
    }

}
