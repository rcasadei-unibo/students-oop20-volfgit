package vg.utils;

public class V2D {
    private double x;
    private double y;

    public V2D(final double x, final double y){
        this.x = x;
        this.y = y;
    }

    public V2D sum(final V2D pos){
        return new V2D(this.x+pos.x,this.y+pos.y);
    }

    public V2D mul(final V2D pos) {
        return new V2D(this.x*pos.getX(),this.y*pos.getY());
    }

    public V2D scalarMul(final double scalar) {
        return this.mul(new V2D(scalar,scalar));
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
