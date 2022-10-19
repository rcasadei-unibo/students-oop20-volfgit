package vg.view.entity;

import javafx.geometry.Dimension2D;
import vg.utils.V2D;

public class StaticFactoryEntityBlock {

    public static EntityBlockImpl create(Dimension2D dimension) {
        return new EntityBlockImpl(dimension.getWidth(), dimension.getHeight());
    }

    public static EntityBlock createBoss(final V2D position) {
        EntityBlock boss = new EntityBlockImpl(40, 40);
        //this.boss.setImage("img/boss.png");
        boss.setPosition(position.getVec2d());
        return boss;
    }

    public static EntityBlock createMosquito(final V2D position) {
        EntityBlock mosq = new EntityBlockImpl(40, 40);
        //this.boss.setImage("img/mosquito.png");
        mosq.setPosition(position.getVec2d());
        return mosq;
    }

}
