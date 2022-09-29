package vg.model;

import vg.utils.Direction;
import vg.utils.Position;

public abstract class AbstractEntity implements Entity{
    private Position position;
    //private Shape shape;

    AbstractEntity(final Position position) {
        this.position = position;
    }

    public Position getPosition() {
      return this.position;
    };

    public void setPosition(Position position) {
        this.position = position;
    }

    //Shape getShape();

}
