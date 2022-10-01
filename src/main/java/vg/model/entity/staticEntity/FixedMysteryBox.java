package vg.model.entity.staticEntity;

import vg.model.bonus.Bonus;
import vg.model.bonus.BonusImpl;
import vg.model.entity.staticEntity.MysteryBox;
import vg.utils.V2D;

/**
 * A simple mystery box that is always fixed in the same
 * spot.
 * @see vg.model.entity.staticEntity.MysteryBox
 * @see vg.model.entity.staticEntity.StaticEntity
 */
public class FixedMysteryBox extends MysteryBox<BonusImpl> {

    /**
     * {@link MysteryBox#MysteryBox(V2D, int, Bonus)}.
     * @param position the position of the mystery box.
     * @param halfWidth the half-width and height of the box
     * @param bonus the bonus contained by the box
     */
    FixedMysteryBox(final V2D position, final int halfWidth, final BonusImpl bonus) {
        super(position, halfWidth, bonus);
    }
}
