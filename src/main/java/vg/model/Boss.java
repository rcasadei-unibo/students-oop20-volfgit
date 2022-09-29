package vg.model;

import vg.utils.V2D;

public abstract class Boss extends Enemy {
    Boss(V2D position, V2D speed) {
        super(position, speed);
    }
}
