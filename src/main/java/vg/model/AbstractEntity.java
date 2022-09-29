package vg.model;

import vg.utils.V2D;

public abstract class AbstractEntity implements Entity{
    private V2D position;
    //private Shape shape;

    AbstractEntity(final V2D position) {
        this.position = position;
    }

    public V2D getPosition() {
      return this.position;
    };

    public void setPosition(V2D position) {
        this.position = position;
    }

    //Shape getShape();

}
