package vg.model.Boss;

import vg.model.entity.dynamicEntity.enemy.Boss;
import vg.utils.MassTier;
import vg.utils.Shape;
import vg.utils.V2D;

public class BossImpl extends Boss {
    private boolean isDead;


    public BossImpl(V2D position, V2D speed, int radius, Shape shape, MassTier massTier) {
        super(position, speed, radius, shape, massTier);
    }
}
