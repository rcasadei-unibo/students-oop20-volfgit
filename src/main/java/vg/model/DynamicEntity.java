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

    public void move(final Direction dir){
        Position updatedPos = new Position(dir.getX()*this.speed.getX(), dir.getY()*this.speed.getY());
        this.getPosition().sumPosition(updatedPos);
    }
}
