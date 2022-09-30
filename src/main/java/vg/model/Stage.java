package vg.model;

import vg.model.entity.AbstractEntity;
import vg.model.entity.Entity;
import vg.model.entity.dynamicEntity.DynamicEntity;
import vg.model.entity.dynamicEntity.Player;
import vg.model.entity.staticEntity.StaticEntity;

import java.util.Set;

public interface Stage<T> {
    Map<T> getMap();

    void setMap(Map<T> map);

    Player getPlayer();

    //TODO questo setter non so se serve
    void setPlayer(Player player);

    Set<StaticEntity> getStaticEntitySet();

    Set<DynamicEntity> getDynamicEntitySet();

    Set<AbstractEntity> getToDestroySet();

    T getBorders();

    Set<Entity> getAllEntities();

    void moveAll();

    void addToDestroy(AbstractEntity toDestroy);

    void checkCollisions();

    void checkAllOutOfBounds();

    void destroyAll();

    void doCycle();
}
