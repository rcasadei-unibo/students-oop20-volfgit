package vg.utils;

public enum Direction {
    UP(-1,0),
    DOWN(1,0),
    LEFT(0,-1),
    RIGHT(0,1);

    private double x;
    private double y;
    private Direction(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }
}
