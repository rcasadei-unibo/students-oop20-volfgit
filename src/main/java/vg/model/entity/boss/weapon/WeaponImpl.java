package vg.model.entity.boss.weapon;

import vg.model.entity.dynamicEntity.bullet.Bolt;
import vg.utils.Direction;
import vg.utils.V2D;

import java.util.List;

public class WeaponImpl {
    private final V2D position;
    private final Direction direction;

    private List<Bolt> bolts;

    public WeaponImpl(final V2D position, final Direction direction) {
        this.position = position;
        this.direction = direction;
    }




}
