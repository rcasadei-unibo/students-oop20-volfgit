package vg.model;

import vg.utils.Direction;
import vg.utils.Position;

public abstract class DynamicEntity extends AbstractEntity{

    DynamicEntity(Position position) {
        super(position);
    }

    public void move(final Direction direction){
        double curX = this.getPosition().getX();
        double curY = this.getPosition().getY();
        this.setPosition(new Position(curX+ direction.getX(), curY+direction.getY()));
    }
}
