package vg.model.Boss.weapon;

import vg.model.entity.dynamicEntity.bullet.Bolt;
import vg.utils.Direction;
import vg.utils.V2D;

import java.util.List;

public class WeaponImpl {
    private V2D position;
    private Direction direction;

    private List<Bolt> bolts;

    public WeaponImpl(V2D position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }




}
