package vg.controller.entity.boss;

import vg.model.Boss.BossModel;
import vg.model.Boss.StaticFactoryBoss;
import vg.view.entity.EntityBlock;
import vg.view.entity.StaticFactoryEntityBlock;

public class StaticFactoryBossController {

    public static BossController createRound1() {
        BossModel model = StaticFactoryBoss.createRound1();
        EntityBlock view = StaticFactoryEntityBlock.createBoss(model.getPosition(), model.getDimension());
        return new BossControllerImpl(model, view);
    }

}
