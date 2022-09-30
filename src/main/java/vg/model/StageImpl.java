package vg.model;

import vg.model.entity.AbstractEntity;
import vg.model.entity.Entity;
import vg.model.entity.dynamicEntity.DynamicEntity;
import vg.model.entity.dynamicEntity.Player;
import vg.model.entity.staticEntity.StaticEntity;
import vg.utils.V2D;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StageImpl<T> implements Stage<T> {
    private int currentScore;
    private Player player;
    private Set<StaticEntity> ss;
    private Set<DynamicEntity> ds;
    private Set<AbstractEntity> toDestroy;
    private Map<T> map;

    public StageImpl(final int currentScore, final Map<T> map) {
        this.currentScore = currentScore;
        this.map = map;
    }

    public StageImpl(final Map<T> map) {
        this.currentScore = 0;
        this.map = map;
    }

    @Override
    public Map<T> getMap() {
        return map;
    }

    @Override
    public void setMap(Map<T> map) {
        this.map = map;
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    //TODO questo setter non so se serve
    @Override
    public void setPlayer(final Player player) {
        this.player = player;
    }

    @Override
    public Set<StaticEntity> getStaticEntitySet() {
        return ss;
    }

    @Override
    public Set<DynamicEntity> getDynamicEntitySet() {
        return ds;
    }

    @Override
    public Set<AbstractEntity> getToDestroySet() {
        return toDestroy;
    }
    @Override
    public T getBorders() {
        return getMap().getBorders();
    }
    @Override
    public Set<Entity> getAllEntities() {
        return Stream.of(getDynamicEntitySet().stream(), getStaticEntitySet().stream(), Stream.of(getPlayer())).flatMap(e -> e).collect(Collectors.toSet());
    }

    @Override
    public void moveAll() {
        //TODO dare al giocatore la giusta direzione (passarlo come argomento?)
        getPlayer().move(new V2D(0, 0));
        getDynamicEntitySet().forEach(e -> e.move(e.getSpeed()));
    }
    @Override
    public void addToDestroy(final AbstractEntity toDestroy) {
        this.getToDestroySet().add(toDestroy);
    }
    @Override
    public void checkCollisions() {
        getDynamicEntitySet().forEach(e -> {
            getAllEntities().forEach(t -> {
                //TODO aggiungere la condizione per cui effettivamente stanno collidendo
                if (!e.equals(t)) {
                    e.afterCollisionAction();
                }
            });
        });
    }
    @Override
    public void checkAllOutOfBounds() {
        getDynamicEntitySet().forEach(e -> {
            if (!getMap().isInBorder(e)) {
               e.afterCollisionAction();
            }
        });
    }
    @Override
    public void destroyAll() {
        getToDestroySet().forEach(e -> {
            if (getDynamicEntitySet().contains(e)) {
                getDynamicEntitySet().remove(e);
            }
            if (getStaticEntitySet().contains(e)) {
               getStaticEntitySet().remove(e);
            }
        });
        getToDestroySet().removeAll(getToDestroySet());
    }


    @Override
    public void doCycle() {
        moveAll();
        checkAllOutOfBounds();
        checkCollisions();
        destroyAll();
    }
}
