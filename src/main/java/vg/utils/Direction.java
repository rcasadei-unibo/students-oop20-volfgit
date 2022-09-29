package vg.utils;

public enum Direction {
    LEFT(-1,0),
    RIGHT(1,0),
    UP(0,-1),
    DOWN(0,1),
    NONE(0,0);

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

    public V2D getVector() {
        return new V2D(this.x,this.y);
    }
}
