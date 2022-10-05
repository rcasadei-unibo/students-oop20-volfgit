package vg.model.entity.dynamicEntity;

import vg.model.entity.ShapedEntity;
import vg.utils.Direction;
import vg.utils.MassTier;
import vg.utils.Shape;
import vg.utils.V2D;

public abstract class DynamicEntity extends ShapedEntity {
    /**
     * Entity movement speed.
     * */
    private V2D speed;

    public DynamicEntity(final V2D position, final V2D speed, final int radius, final Shape shape, final MassTier massTier) {
        super(position, radius, shape, massTier);
        this.speed = speed;
    }

    /**
     * Update sing of coordinates with the direction ones.
     * Example: speed = (-2,3), new direction LEFT -> new speed = (-2, -3)
     * @param dir new direction movement
     */
    public void changeDirection(final Direction dir) {
        //get new speed with updated direction
        this.setSpeed(this.speed.updateSign(dir.getVector()));
    }
    /**
     * Sums the speed to position and sets the result to
     * position.
     */
    public void move() {
        setPosition(getPosition().sum(getSpeed()));
    }
    /**
     * Return vector that represent current entity speed.
     * @return current entity speed
     */
    public V2D getSpeed() {
        return this.speed;
    }

    /**
     * Sets the speed of the entity.
     * @param newSpeed the speed to set to
     */
    public void setSpeed(final V2D newSpeed) {
        this.speed = newSpeed;
    }

    /**
     * Evaluates what happens to the entity after a
     * collision. Generally an entity will "bounce"
     * if a collision occurs with another entity which
     * {@link MassTier} equal or higher, than it will
     * bounce, otherwise not. An exception is for entities
     * with mass tier of {@link MassTier#NOCOLLISION}, this
     * type of mass tier will never "bounce".
     * @param other the mass tier of the entity comparing to
     */
    public void afterCollisionAction(final MassTier other) {
        if (this.getMassTier().compareTo(other) <= 0 && !this.getMassTier().equals(MassTier.NOCOLLISION)) {
            this.bounces();
        }
    }

    private void bounces() {
        //TODO invertire speed
    }
}
