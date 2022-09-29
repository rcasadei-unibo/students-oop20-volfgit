package vg.model;

import vg.utils.V2D;

public abstract class Bolt extends DynamicEntity {
    Bolt(V2D position, V2D speed) {
        super(position, speed);
    }
}
