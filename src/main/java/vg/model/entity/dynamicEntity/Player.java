package vg.model.entity.dynamicEntity;

import vg.model.Tail;
import vg.model.bonus.BonusType;
import vg.model.entity.AbstractEntity;
import vg.model.entity.Entity;
import vg.utils.V2D;

public interface Player extends Entity {

    void decLife();
    void incLife();
    void move(V2D newPosition);
    Tail getPlayerTail();

}
