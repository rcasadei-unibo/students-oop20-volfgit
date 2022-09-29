package vg.utils;

public class Speed {
    private double x;
    private double y;

    Speed(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Speed{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
