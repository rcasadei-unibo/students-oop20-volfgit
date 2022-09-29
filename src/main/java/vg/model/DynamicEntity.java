package vg.model;

import vg.utils.Direction;
import vg.utils.Position;
import vg.utils.Speed;

public abstract class DynamicEntity extends AbstractEntity{
    private Speed speed;

    DynamicEntity(final Position position, final Speed speed) {
        super(position);
        this.speed = speed;
    }

    public void move(final Direction direction){
        double curX = this.getPosition().getX();
        double curY = this.getPosition().getY();
        this.setPosition(new Position(curX+ direction.getX(), curY+direction.getY()));
    }
}
