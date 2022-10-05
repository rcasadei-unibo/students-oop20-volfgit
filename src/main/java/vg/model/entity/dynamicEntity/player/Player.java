package vg.model.entity.dynamicEntity.player;

import vg.model.entity.Entity;
import vg.model.timedObject.Shield;
import vg.utils.Direction;
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
     * Enable or change current player speed with new one.
     * @param speed Vector that represent speed
     */
    void enableSpeedUp(V2D speed);
    /**
     * Disable speed improvement if enabled.
     */
    void disableSpeedUp();
    /**
     * Return true if player can shoot.
     * @return true if player can shoot, false if not
     */
    boolean canShoot();
    /**
     * Enable player capability to shoot.
     * */
    void enableShoot();
    /**
     * Disable player capability to shoot if enabled.
     * */
    void disableShoot();

    /**
     * Move player to new position coordinate
     */
    void move();

    void changeDirection(Direction direction);

    /**
     * Get player tail.
     * @return Tail of player
     */
    Tail getPlayerTail();

    void setShield(Shield shield);

    Shield getShield();

}
