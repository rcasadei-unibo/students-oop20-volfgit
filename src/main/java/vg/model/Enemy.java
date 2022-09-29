package vg.model;

import vg.utils.Position;
import vg.utils.Speed;

public abstract class Enemy extends DynamicEntity {

    Enemy(Position position, Speed speed) {
        super(position, speed);
    }
}
