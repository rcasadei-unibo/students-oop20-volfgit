package vg.model.entity.dynamicEntity.enemy;

import vg.utils.V2D;

public abstract class MinorEnemy extends Enemy {
    MinorEnemy(V2D position, V2D speed) {
        super(position, speed);
    }
}