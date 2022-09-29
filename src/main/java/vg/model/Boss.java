package vg.model;

import vg.utils.Position;
import vg.utils.Speed;

public abstract class Boss extends Enemy {
    Boss(Position position, Speed speed) {
        super(position, speed);
    }
}
