package vg.model.entity.dynamicEntity.enemy;

import vg.model.entity.dynamicEntity.DynamicEntity;
import vg.utils.V2D;

public abstract class Enemy extends DynamicEntity {

    Enemy(V2D v2D, V2D speed) {
        super(v2D, speed);
    }
}
