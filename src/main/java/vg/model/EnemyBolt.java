package vg.model;

import vg.utils.Position;
import vg.utils.Speed;

public abstract class EnemyBolt extends Bolt {
    EnemyBolt(Position position, Speed speed) {
        super(position, speed);
    }
}
