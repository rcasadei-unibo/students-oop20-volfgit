package vg.model;

import vg.utils.Direction;
import vg.utils.Position;
import vg.utils.Speed;

public abstract class DynamicEntity extends AbstractEntity{
    private Speed speed;

    public DynamicEntity(final Position position, final Speed speed) {
        super(position);
        this.speed = speed;
    }

    public void move(final Direction dir){
        Position curPos = this.getPosition();
        Position updatedPos = new Position(dir.getX()*this.speed.getX(), dir.getY()*this.speed.getY());
        this.setPosition(curPos.sum(updatedPos));
    }

    public Speed getSpeed() {
        return this.speed;
    }

    public void afterCollisionAction(){

    }
}
