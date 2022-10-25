package vg.model;

import vg.model.entity.Entity;
import vg.model.entity.dynamicEntity.DynamicEntity;
import vg.model.entity.dynamicEntity.enemy.Boss;
import vg.model.entity.dynamicEntity.player.Player;
import vg.model.entity.staticEntity.StaticEntity;
import vg.utils.V2D;

import java.util.List;
import java.util.Set;

/**
 * Interface that defines what a map must do to become usable by {@link Stage}
 * that is containing all the data structures and getters for them, methods
 * for updating the border, computing if an {@link Entity} is captured by
 * the player when creating new borders using {@link vg.model.entity.dynamicEntity.player.Tail}.
 * @param <T> the type that defines positions and dimensionless entities
 * @see V2D
 */
public interface Map<T> {
    /**
     * Will compute and return the percentage of the map that is captured
     * by the player. This is used to check if the level is completed.
     * @return a percentage that indicates show much of the map is captured
     */
    double getOccupiedPercentage();

    /**
     * Return the set of the current borders, that where the player can travel
     * without creating a tail and with the shield active. At the start of each
     * level, the borders will be a Set from (0,0) to (xMax,0) to (xMax,yMax)
     * to (0,yMax) and then will be replaced by the ones created by player's tail.
     * @return a set of positions (usually {@link V2D})
     */
    Set<T> getBorders();

    /**
     * Update the borders of the map. Must call internally {@link #isTailCompleted()}
     * or something that checks if the player's tail is actually completed.
     * @param tail the player tail that will become part of the new border
     */
    void updateBorders(List<T> tail);

    /**
     * Returns the player.
     * @return the player
     */
    Player getPlayer();

    /**
     * Returns the tail that is created by the player. The tail, when not completed,
     * is considered as a Set of {@link Entity} without a {@link vg.utils.Shape} and
     * with the lowest {@link vg.utils.MassTier}. So other entities can walk through
     * the tail without colliding with it.
     * @return the tail that is created by the player
     */
    Set<T> getTail();

    /**
     * Checks if the tail, generated by the player, is ready to become a border, so if
     * the last {@link T} is colliding with the current border.
     * @return true if the tail is completed and will become a border, false otherwise
     * @see T
     */
    boolean isTailCompleted();

    /**
     * Returns true if the player is on borders.
     * @return true if the player is on the boards
     */
     boolean isPlayerOnBorders();

    /**
     * Checks if an entity is captured by the player when he created a new border
     * completing a tail. The Boss of the level cannot be captured (as the boss will
     * be used to compute what part of the map to capture).
     * @param toCheck the entity to check if it is captured or not
     * @return true if the entity must be captured, false otherwise
     */
    boolean toCapture(Entity toCheck);

    /**
     * Removes an entity after being captured or destroyed in some way.
     * @param toRemove the entity to remove
     */
    void removeEntity(Entity toRemove);

    /**
     * Update bonus internal timer and remove from active bonus if expired.
     * @param elapsedTime elasped time between current and previous game cycle
     */
    void updateBonusTimer(double elapsedTime);

    /**
     * Returns the set of static entities.
     * @return the set of static entities
     * @see StaticEntity
     */
    Set<StaticEntity> getAllStaticEntities();
    /**
     * Returns the set of dynamic entities.
     * @return the set of dynamic entities
     * @see DynamicEntity
     */
    Set<DynamicEntity> getAllDynamicEntities();
    /**
     * Returns the set of all bolts.
     * @return the set of all bolts
     * @see vg.model.entity.dynamicEntity.bullet.Bolt
     */
    Set<DynamicEntity> getBolts();

    /**
     * Returns the set of all enemy bolts.
     * @return the set of all enemy bolts
     * @see vg.model.entity.dynamicEntity.bullet.EnemyBolt
     */
    Set<DynamicEntity> getEnemyBolts();

    /**
     * Returns the set of all friendly bolts.
     * @return the set of all friendly bolts
     * @see vg.model.entity.dynamicEntity.bullet.Bolt
     */
    Set<DynamicEntity> getFriendlyBolts();
    /**
     * Returns the boss of the map.
     * @return the boss of the map
     */
    Boss getBoss();

    /**
     * This method will compute what is the correct speed of an
     * {@link DynamicEntity} when a collision is happening.
     * @param toCheckD the entity to check
     * @return the correct new speed of the entity after a collision
     */
    T getAfterCollisionDirection(DynamicEntity toCheckD);


    boolean isInBorders(V2D pos);
}
