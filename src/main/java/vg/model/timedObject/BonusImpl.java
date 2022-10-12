package vg.model.timedObject;

public class BonusImpl extends TimedObjectImpl implements Bonus {
    /**
     * Typology of bonus.
     */
    private BonusType type;

    public static BonusImpl createBonus(final BonusType type, final double duration) {
        return new BonusImpl(type, duration);
    }

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
