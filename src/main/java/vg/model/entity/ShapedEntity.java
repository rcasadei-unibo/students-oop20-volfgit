package vg.model.entity;

import vg.utils.V2D;

public abstract class ShapedEntity implements Entity {
    /**
     * 2D coordinates to keep current entity position in map.
     */
    private V2D position;
    //private Shape shape;

    protected ShapedEntity(final V2D position) {
        this.position = position;
    }
    public final V2D getPosition() {
      return this.position;
    };

    /**
     * Update entity position with a new one.
     * @param position new position of entity
     */
    public final void setPosition(final V2D position) {
        this.position = position;
    }
    //Shape getShape();
    /**
     * Checks if the given position collides with this ShapedEntity.
     * @param position The position to check if it is in shape of this entity
     */
    @Override
    public boolean isInShape(final V2D position) {
        return this.position.equals(position);
    }
}
