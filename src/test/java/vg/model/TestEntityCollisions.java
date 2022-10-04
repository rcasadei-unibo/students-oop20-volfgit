package vg.model;

import org.junit.jupiter.api.Test;
import vg.model.entity.dynamicEntity.DynamicEntity;
import vg.utils.MassTier;
import vg.utils.Shape;
import vg.utils.V2D;

public class TestEntityCollisions {
    private class DynamicEntityImpl extends DynamicEntity{

        public DynamicEntityImpl(V2D position, V2D speed, int radius, Shape shape, MassTier massTier) {
            super(position, speed, radius, shape, massTier);
        }

        @Override
        public void afterCollisionAction() {
            this.setSpeed(this.getSpeed().mul(new V2D(-1,-1)));
            this.move();
        }
    }

    /**
     * position and speed of the point.
     */
    V2D pp = new V2D(0,0);
    V2D ps = new V2D(1,2);
    /**
     * position, speed and radius of the circle.
     *
     */
    V2D cp = new V2D(0,0);
    V2D cs = new V2D(0,0);
    int cr = 3;
    /**
     * position,speed and radius (half-width and half-height) of the square
     */
    V2D sp = new V2D(0,0);
    V2D ss = new V2D(0,0);
    int sr = 5;
    DynamicEntity p = new DynamicEntityImpl(pp,ps,0,Shape.CIRCLE, MassTier.HIGH);
    DynamicEntity c = new DynamicEntityImpl(cp,cs,cr,Shape.CIRCLE, MassTier.MEDIUM);
    DynamicEntity s = new DynamicEntityImpl(sp,ss,sr,Shape.CIRCLE, MassTier.LOW);

    @Test
    void pointVPoint(){

    }
    @Test
    void pointVCircle(){

    }
    @Test
    void circleVPoint(){

    }
    @Test
    void squareVPoint(){

    }
    @Test
    void pointVSquare(){

    }
    @Test
    void circleVSquare(){

    }
    @Test
    void squareVCircle(){

    }
}
