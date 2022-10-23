package vg.model.Boss;

import vg.utils.V2D;

public class StaticFactoryBoss {

    public static BossModel createRound1() {
        return new BossImpl(new V2D(2, 2));
    }
}
