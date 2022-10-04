package vg.model.entity.dynamicEntity.bolt;

import vg.utils.Shape;
import vg.utils.V2D;

public abstract class EnemyBolt extends Bolt {

    public EnemyBolt(V2D position, V2D speed, int radius, Shape shape) {
        super(position, speed, radius, shape);
    }
}
