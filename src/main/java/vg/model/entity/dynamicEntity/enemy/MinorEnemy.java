package vg.model.entity.dynamicEntity.enemy;

import vg.utils.MassTier;
import vg.utils.Shape;
import vg.utils.V2D;

public abstract class MinorEnemy extends Enemy {

    public MinorEnemy(V2D position, V2D speed, int radius, Shape shape, MassTier massTier) {
        super(position, speed, radius, shape, massTier);
    }
}
