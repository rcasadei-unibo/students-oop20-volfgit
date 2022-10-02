package vg.utils;

import java.text.MessageFormat;
import java.util.Objects;

public class V2D {
    /**
     * X: Horizontal coordinate.
     */
    private final double x;
    /**
     * Y: Vertical coordinate.
     */
    private final double y;

    public V2D(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructor that builds a new V2D equal
     * to the one that is passed.
     * @param equal the V2D point which coordinates
     *              will be used to create the new one
     */
    public V2D(final V2D equal) {
        this.x = equal.getX();
        this.y = equal.getY();
    }
    public final V2D sum(final V2D pos) {
        return new V2D(this.x + pos.x, this.y + pos.y);
    }

    public final V2D mul(final V2D pos) {
        return new V2D(this.x * pos.getX(), this.y * pos.getY());
    }

    public final V2D scalarMul(final double scalar) {
        return this.mul(new V2D(scalar, scalar));
    }

    public final double getX() {
        return x;
    }

    public final double getY() {
        return y;
    }

    /**
     * Print position coordinates.*/
    @Override
    public String toString() {
        return MessageFormat.format("Position'{'x={0}, y={1}'}'", x, y);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof V2D)) {
            return false;
        }
        V2D v2D = (V2D) o;
        return Double.compare(v2D.getX(), getX()) == 0 && Double.compare(v2D.getY(), getY()) == 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}
