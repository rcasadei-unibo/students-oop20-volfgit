package vg.model.entity;

import vg.utils.Shape;
import vg.utils.V2D;

public abstract class ShapedEntity implements Entity {
    /**
     * 2D coordinates to keep current entity position in map.
     */
    private V2D position;
    private Shape shape;
    private int radius;
    protected ShapedEntity(final V2D position, final int radius) {
        this.position = position;
        this.radius = radius;
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

    /**
     * Getter of the radius of this entity. If the entity is a circle then it is
     * an actual radius from the center. If the entity is a square then it is the
     * half-width and half-height of the entity.
     * @return the radius or half-width/half-height
     * @see Shape
     */
    public final int getRadius() {
        return this.radius;
    }

    /**
     * Returns the shape of this entity.
     * @return the shape of this entity
     * @see Shape
     */
    public Shape getShape() {
        return this.shape;
    }
    /**
     * Checks if the given position collides with this ShapedEntity.
     * @param position The position to check if it is in shape of this entity
     */
    @Override
    public boolean isInShape(final V2D position) {
        return this.shape.isInShape(this.getPosition(), position, this.getRadius());
    }

    /**
     * Checks if the two shaped entities are colliding.
     * @param other the ShapedEntity to check if this is colling with.
     * @return true if the two entities are colliding, false otherwise
     */
    @Override
    public boolean isInShape(final ShapedEntity other) {
        return this.shape.isInShape(this.getPosition(), other.getPosition(), this.getRadius(), other.getRadius(), other.getShape());
    }
}
