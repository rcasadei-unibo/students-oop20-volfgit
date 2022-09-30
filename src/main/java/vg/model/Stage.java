package vg.model;

import vg.model.entity.AbstractEntity;
import vg.model.entity.Entity;
import vg.model.entity.dynamicEntity.DynamicEntity;
import vg.model.entity.dynamicEntity.Player;
import vg.model.entity.staticEntity.StaticEntity;

import java.util.Set;

/**
 * The main model class that will control all the entities
 * on the map.
 * @param <T> : the type which defines borders data structure.
 */
public interface Stage<T> {
    /**
     * Return the current map state.
     * @return : Map<T> in his current state.
     */
    Map<T> getMap();

    /**
     * Sets the map of the stage.
     * @param map : the map to set to.
     */
    void setMap(Map<T> map);

    /**
     * Return the current player state.
     * @return : the current player state.
     */
    Player getPlayer();

    /**
     * Sets the player in this stage.
     * @param player : the player to set to.
     */
    void setPlayer(Player player);

    /**
     * Return a Set of all static entities on the map.
     * @return : Set<StaticEntity> that contains all staticEntity on the map.
     */
    Set<StaticEntity> getStaticEntitySet();

    /**
     * Return a Set of all dynamic entities on the map.
     * @return : Set<DynamicEntity> that contains all staticEntity on the map.
     */
    Set<DynamicEntity> getDynamicEntitySet();

    /**
     * Return a Set of all entities that will be deleted from the map before the next iteration begins.
     * @return : Set<AbstractEntity> that contains all entities on the map that will be deleted.
     */
    Set<AbstractEntity> getToDestroySet();

    /**
     * Return a data structure containing the current actual borders of the map.
     * This will not include Magic Boxes even if they are present on the map and
     * entities con collide with.
     * @return T : a data structure containing the borders of the map.
     */
    T getBorders();

    /***********************************************TODO da qui in poi devo finire di mettere
     * altra documentazione, in più creare il metodo Map<T, Pair<MassTier,FactionType>> getCollidble()
     */
    Set<Entity> getAllEntities();

    void moveAll();

    void addToDestroy(AbstractEntity toDestroy);

    void checkCollisions();

    void checkAllOutOfBounds();

    void destroyAll();

    void doCycle();
}
