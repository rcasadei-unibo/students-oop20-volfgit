package vg.model.timedObject;

public class BonusImpl extends TimedObjectImpl implements Bonus {
    /**
     * Typology of bonus.
     */
    private BonusType type;

    BonusImpl(final BonusType type, final double duration) {
        super(duration);
        this.type = type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final BonusType getType() {
        return this.type;
    }

}
