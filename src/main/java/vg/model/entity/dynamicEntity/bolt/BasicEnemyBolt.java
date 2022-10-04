package vg.model.entity.dynamicEntity.bolt;

import vg.model.entity.dynamicEntity.bolt.EnemyBolt;
import vg.utils.Shape;
import vg.utils.V2D;

public class BasicEnemyBolt extends EnemyBolt {

    public BasicEnemyBolt(V2D position, V2D speed, int radius, Shape shape) {
        super(position, speed, radius, shape);
    }
}
