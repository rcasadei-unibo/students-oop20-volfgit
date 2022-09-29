package vg.utils;

public class Position {
    private double x;
    private double y;

    public Position(final double x, final double y){
        this.x = x;
        this.y = y;
    }

    public Position sumPosition(final Position pos){
        return new Position(this.x+pos.x,this.y+pos.y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
