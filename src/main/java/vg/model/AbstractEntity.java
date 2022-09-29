package vg.model;

import vg.utils.Direction;
import vg.utils.Position;

public abstract class AbstractEntity implements Entity{
    private Position position;
    //private Shape shape;

    AbstractEntity(final Position position) {
        this.position = position;
    }

    public void move(final Direction direction){
        double curX = this.position.getX();
        double curY = this.position.getY();
        this.position = new Position(curX+ direction.getX(), curY+direction.getY());
    }

    public Position getPosition() {
      return this.position;
    };
    //Shape getShape();

}
