package vg.model.entity.dynamicEntity.bolt;

import vg.model.entity.dynamicEntity.bolt.EnemyBolt;
import vg.utils.Shape;
import vg.utils.V2D;

public class BasicEnemyBolt extends EnemyBolt {

    public BasicEnemyBolt(final V2D position, final V2D speed, final int radius, final Shape shape) {
        super(position, speed, radius, shape);
    }

}
