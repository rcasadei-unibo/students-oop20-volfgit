package vg.model.entity.dynamicEntity;

import vg.model.Tail;

public interface Player {

    void decLife();
    void incLife();
    Tail getPlayerTail();
}
