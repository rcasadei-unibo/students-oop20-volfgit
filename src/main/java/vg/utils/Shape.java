package vg.utils;

/**
 * Enum that defines possible shapes of entities.
 * @see vg.model.entity.ShapedEntity
 */
public enum Shape {
    /**
     * CIRCLE defines an entity that is a circle.
     */
    CIRCLE,
    /**
     * SQUARE defines an entity that is a squared one.
     */
    SQUARE;

    /**
     * This method evaluates if p2 is in shape of p1 + radius.
     * The calculation is based on the Shape type (CIRCLE or SQUARE)
     * @param p1 the first V2D point
     * @param p2 the second V2D point
     * @param radius the radius of p1
     * @return true is p2 is in shape of p1, false otherwise
     * @see V2D
     */
    public boolean isInShape(final V2D p1, final V2D p2, final int radius) {
        return this == CIRCLE ? Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2) <= Math.pow(radius, 2) : p1.getX() - p2.getX() < radius && p1.getX() - p2.getX() > -radius && p1.getY() - p2.getY() < radius && p1.getY() - p2.getY() > -radius;
    }

    /**
     * Overloading of the method above method, checks if two entities
     * are colliding.
     * @param p1 center of this entity
     * @param p2 center of the comparing with entity
     * @param r1 radius of this entity
     * @param r2 radius of the comparing with entity
     * @param p2Type the type of the comparing with entity (CIRCLE or SQUARE)
     * @return true if the two entities are colliding, false otherwise.
     */
    public boolean isInShape(final V2D p1, final V2D p2, final int r1, final int r2, final Shape p2Type) {
        if (this == Shape.CIRCLE && p2Type == Shape.CIRCLE) {
            return Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2) <= Math.pow(r1 + r2, 2) - 2 * r1 * r2;
        }
        if (this == Shape.SQUARE && p2Type == Shape.SQUARE) {
            return p1.getX() - r1 < p2.getX() + 2 * r2 && p2.getX() < p1.getX() + r1 && p1.getY() - r1 < p2.getY() * 2 * r2 && p2.getY() < p1.getY() + r1;
        }
        if (this == Shape.CIRCLE && p2Type == Shape.SQUARE) {
            var dx = Math.abs(p1.getX() - p2.getX());
            var dy = Math.abs(p1.getY() - p2.getY());
            dx = Math.max(dx - r2, 0);
            dy = Math.max(dy - r2, 0);
            return dx * dx + dy * dy <= r1 * r1;
        }
        if (this == Shape.SQUARE && p2Type == Shape.CIRCLE) {
            return Shape.CIRCLE.isInShape(p2, p1, r2, r1, Shape.SQUARE);
        }
        // there are no other cases for now
        return false;
    }
}
