package vg.model.timedObject;

import java.io.Serializable;
import java.util.Objects;

public class BonusImpl extends TimedObjectImpl implements Bonus, Serializable {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonusImpl bonus = (BonusImpl) o;
        return type == bonus.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
