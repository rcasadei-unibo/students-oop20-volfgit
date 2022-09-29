package vg.model;

import vg.utils.Direction;
import vg.utils.V2D;

public abstract class DynamicEntity extends AbstractEntity{
    private V2D speed;

    public DynamicEntity(final V2D position, final V2D speed) {
        super(position);
        this.speed = speed;
    }

    public void move(final Direction dir){
        V2D curPos = this.getPosition();
        V2D updatedPos = new V2D(dir.getX()*this.speed.getX(), dir.getY()*this.speed.getY());
        this.setPosition(curPos.sum(updatedPos));
    }

    public V2D getSpeed() {
        return this.speed;
    }

    public void afterCollisionAction(){

    }
}
