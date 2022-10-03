package vg.model.entity.dynamicEntity.player;

import vg.model.entity.Entity;
import vg.utils.Direction;
import vg.utils.V2D;

public interface Player extends Entity {

    /**
     * Increment player's score.
     * @param incrementScore score to be added to current one
     */
    void incScore(int incrementScore);

    /**
     * @retun player score.
     */
    int getScore();

    /**
     * Decrement player's life of one unit.
     */
    void decLife();
    /**
     * Increment player's life of one unit but not over maximum value.
     */
    void incLife();
    /**
     * Enable or change current player speed with new one.
     * @param speed Vector that represent speed
     */
    void enableSpeedUp(V2D speed);
    /**
     * Disable speed improvement enabled before, if no new speed was set nothing is disabled.
     */
    void disableSpeedUp();
    /**
     * Move player to new position coordinate by direction.
     * @param dir direction of new movement
     */
    void move(Direction dir);

    /**
     * Get player tail.
     * @return Tail of player
     */
    Tail getPlayerTail();

}
