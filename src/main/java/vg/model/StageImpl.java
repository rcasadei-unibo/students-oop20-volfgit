package vg.model;

import vg.model.entity.ShapedEntity;
import vg.model.entity.Entity;
import vg.model.entity.dynamicEntity.DynamicEntity;
import vg.model.entity.dynamicEntity.Player;
import vg.model.entity.staticEntity.StaticEntity;
import vg.utils.V2D;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The class that implements Stage using V2D as type for positions and vectors.
 * @see Stage
 * @see V2D
 */
public class StageImpl implements Stage<V2D> {


    /**
     * The current score earned by the player.
     */
    private int currentScore;
    /**
     * The player.
     */
    private Player player;
    /**
     * The set of static entities.
     * @see #getStaticEntitySet()
     */
    private Set<StaticEntity> ss;
    /**
     * The set of dynamic entities.
     * @see #getDynamicEntitySet()
     */
    private Set<DynamicEntity> ds;
    /**
     * The set of entities that need to be destroyed.
     * @see #getToDestroySet()
     */
    private Set<ShapedEntity> toDestroy;
    /**
     * The current active map of the Stage. This will change as the player
     * will progress from one level to another. The Score of the player is
     * incremented as the player completes levels and is saved in this class.
     * @see Map
     */
    private Map<V2D> map;

    /**
     * Constructor with map and currentScore as parameters, useful if the
     * Stage is created from a saved file.
     * @param currentScore The player score
     * @param map The map
     * @see Map
     * @see Player
     * @see Stage
     */
    public StageImpl(final int currentScore, final Map<V2D> map) {
        this.currentScore = currentScore;
        this.map = map;
    }
    /**
     * Constructor with only map as parameter, useful if the
     * game is a new one and the currentScore will be set to 0.
     * @param map The map
     * @see Map
     * @see Player
     * @see Stage
     */
    public StageImpl(final Map<V2D> map) {
        this.currentScore = 0;
        this.map = map;
    }
    /**
     *
     * {@inheritDoc}
     */
    public int getCurrentScore() {
        return currentScore;
    }
    /**
     *
     * {@inheritDoc}
     */
    public void setCurrentScore(final int currentScore) {
        this.currentScore = currentScore;
    }
    /**
     *
     * {@inheritDoc}
     */
    @Override
    public Map<V2D> getMap() {
        return map;
    }
    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void setMap(final Map<V2D> map) {
        this.map = map;
    }
    /**
     *
     * {@inheritDoc}
     */
    @Override
    public Player getPlayer() {
        return player;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void setPlayer(final Player player) {
        this.player = player;
    }
    /**
     *
     * {@inheritDoc}
     */
    @Override
    public Set<StaticEntity> getStaticEntitySet() {
        return ss;
    }
    /**
     *
     * {@inheritDoc}
     */
    @Override
    public Set<DynamicEntity> getDynamicEntitySet() {
        return ds;
    }
    /**
     *
     * {@inheritDoc}
     */
    @Override
    public Set<ShapedEntity> getToDestroySet() {
        return toDestroy;
    }
    /**
     *
     * {@inheritDoc}
     */
    @Override
    public Set<V2D> getBorders() {
        return getMap().getBorders();
    }
    /**
     *
     * {@inheritDoc}
     */
    @Override
    public Set<Entity> getAllEntities() {
        return Stream.of(getDynamicEntitySet().stream(), getStaticEntitySet().stream(), Stream.of(getPlayer())).flatMap(e -> e).collect(Collectors.toSet());
    }
    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void moveAll() {
        //TODO dare al giocatore la giusta direzione (passarlo come argomento?)
        getPlayer().move(new V2D(0, 0));
        getDynamicEntitySet().forEach(e -> e.move(e.getSpeed()));
    }
    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void addToDestroy(final ShapedEntity toDestroy) {
        this.getToDestroySet().add(toDestroy);
    }
    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void checkCollisions() {
        getDynamicEntitySet().forEach(e -> getAllEntities().forEach(t -> {
            //TODO aggiungere la condizione per cui effettivamente stanno collidendo
            if (!e.equals(t)) {
                e.afterCollisionAction();
            }
        }));
    }
    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void checkAllOutOfBounds() {
        getDynamicEntitySet().forEach(e -> {
            if (!getMap().isInBorder(e)) {
               e.afterCollisionAction();
            }
        });
    }
    /**
     *
     * {@inheritDoc}
     */
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
    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void doCycle() {
        moveAll();
        checkAllOutOfBounds();
        checkCollisions();
        destroyAll();
    }
}
