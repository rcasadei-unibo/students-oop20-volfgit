package vg.model.entity.dynamicEntity.bolt;

import vg.utils.V2D;

public abstract class EnemyBolt extends Bolt {
    EnemyBolt(V2D position, V2D speed) {
        super(position, speed);
    }
}
