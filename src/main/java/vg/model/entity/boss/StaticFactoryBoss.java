package vg.model.entity.boss;

import vg.utils.V2D;

public final class StaticFactoryBoss {
    private StaticFactoryBoss() {
    }

    public static BossModel createRound1() {
        return new BossImpl(new V2D(1, 1));
    }
}
