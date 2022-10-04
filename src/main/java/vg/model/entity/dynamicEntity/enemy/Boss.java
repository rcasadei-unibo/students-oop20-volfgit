package vg.model.entity.dynamicEntity.enemy;

import vg.utils.MassTier;
import vg.utils.Shape;
import vg.utils.V2D;

public abstract class Boss extends Enemy {

    Boss(final V2D position, final V2D speed, final int radius, final Shape shape, final MassTier massTier) {
        super(position, speed, radius, shape, massTier);
    }
}
