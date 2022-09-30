package vg.utils;

import java.text.MessageFormat;

public class V2D {
    /**
     * X: Horizontal coordinate.*/
    private final double x;
    /**
     * Y: Vertical coordinate.*/
    private final double y;

    public V2D(final double x, final double y) {
        this.x = x;
        this.y = y;
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
}
