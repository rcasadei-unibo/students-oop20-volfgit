package vg.model;

import vg.utils.Position;
import vg.utils.Speed;

public abstract class Bolt extends DynamicEntity {
    Bolt(Position position, Speed speed) {
        super(position, speed);
    }
}
