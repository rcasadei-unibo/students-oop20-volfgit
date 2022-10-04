package vg.model.entity.staticEntity;

import vg.model.timedObject.Bonus;
import vg.utils.V2D;

/**
 * This class represents the squared box that contains a bonus
 * that can be captured by the player. The mass tier is always
 * the highest one as it extends {@link StaticEntity}.
 * @param <T> the type of actual bonus class, must extend {@link Bonus}
 * @see Bonus
 */
public abstract class MysteryBox<T extends Bonus> extends StaticEntity {

    /**
     * The bonus contained by this Mystery Box.
     */
    private final T bonus;

    /**
     * The constructor simply calls the super one and assign the bonus
     * added as the third param.
     * {@link StaticEntity#StaticEntity(V2D, int)}
     * @param position the initial and final position of this mystery box
     * @param halfWidth the half of the width and the height of the mystery box
     * @param toCreate the Bonus that will be contained by the mystery box
     * @see Bonus
     */
    MysteryBox(final V2D position, final int halfWidth, final T toCreate) {
        super(position, halfWidth);

        this.bonus = toCreate;
    }

    /**
     * Returns the bonus that can be obtained by this Mystery Box.
     * @return the bonus of this mystery box
     */
    public T getBonus() {
        return this.bonus;
    }
}
