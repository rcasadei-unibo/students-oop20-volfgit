package vg.model.entity.dynamicEntity;

import vg.model.Tail;
import vg.utils.V2D;

public interface Player {

    void decLife();
    void incLife();
    void move(V2D newPosition);
    Tail getPlayerTail();
}
