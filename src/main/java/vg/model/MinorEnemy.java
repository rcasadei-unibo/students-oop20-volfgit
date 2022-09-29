package vg.model;

import vg.utils.Position;
import vg.utils.Speed;

public abstract class MinorEnemy extends Enemy {
    MinorEnemy(Position position, Speed speed) {
        super(position, speed);
    }
}
