package vg.model.timedObject;

public class BonusImpl extends TimedObjectImpl implements Bonus {
    /**
     * Typology of bonus.
     */
    private BonusType type;

    BonusImpl(double duration) {
        super(duration);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final BonusType getType() {
        return this.type;
    }

}
