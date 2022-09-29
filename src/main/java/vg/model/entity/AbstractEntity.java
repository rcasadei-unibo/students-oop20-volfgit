package vg.model.entity;

import vg.utils.V2D;

public abstract class AbstractEntity implements Entity {
    private V2D position;
    //private Shape shape;

    protected AbstractEntity(final V2D position) {
        this.position = position;
    }

    public V2D getPosition() {
      return this.position;
    };

    public void setPosition(final V2D position) {
        this.position = position;
    }

    //Shape getShape();

}
