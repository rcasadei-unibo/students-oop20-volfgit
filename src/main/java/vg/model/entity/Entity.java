package vg.model.entity;

import vg.utils.V2D;

public interface Entity {
    V2D getPosition();
    boolean isInShape(V2D position);
    //Shape getShape();
}
