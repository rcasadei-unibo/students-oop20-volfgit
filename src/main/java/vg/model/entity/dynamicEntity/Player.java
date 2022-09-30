package vg.model.entity.dynamicEntity;

import vg.model.Tail;
import vg.model.bonus.BonusType;
import vg.model.entity.AbstractEntity;
import vg.model.entity.Entity;
import vg.utils.V2D;

public interface Player extends Entity {

    /**
     * Decrement player's life of one unit.
     */
    void decLife();
    /**
     * Increment player's life of one unit but not over maximum value.
     */
    void incLife();

    /**
     * Move player to new position coordinate.
     * @param newPosition new position coordinate
     */
    void move(V2D newPosition);

    /**
     * Get player tail.
     * @return Tail of player
     */
    Tail getPlayerTail();

}
