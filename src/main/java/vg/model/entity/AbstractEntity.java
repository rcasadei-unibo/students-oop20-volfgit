package vg.model.entity;

import vg.utils.V2D;

public abstract class AbstractEntity implements Entity {
    /**
     * 2D coordinates to keep current entity position in map.
     * */
    private V2D position;
    //private Shape shape;

    protected AbstractEntity(final V2D position) {
        this.position = position;
    }
    public final V2D getPosition() {
      return this.position;
    };

    /**
     * Update entity position with a new one.
     * @param position new position of entity
     * */
    public final void setPosition(final V2D position) {
        this.position = position;
    }
    //Shape getShape();
}
