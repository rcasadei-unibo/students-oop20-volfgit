package vg.model;

import vg.controller.entity.EntityManager;
import vg.model.entity.ShapedEntity;
import vg.model.entity.Entity;
import vg.model.entity.dynamicEntity.DynamicEntity;
import vg.model.entity.dynamicEntity.enemy.Boss;
import vg.model.entity.dynamicEntity.player.BasePlayer;
import vg.model.entity.dynamicEntity.player.Player;
import vg.model.entity.staticEntity.StaticEntity;
import vg.model.levels.LEVEL;
import vg.utils.Direction;
import vg.utils.MassTier;
import vg.utils.V2D;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The class that implements Stage using V2D as type for positions and vectors.
 * @see Stage
 * @see V2D
 */
public class StageImpl<T> implements Stage<V2D> {

    /**
     * The current level.
     */
    private int lv;
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
    private EntityManager emController;

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
        this.lv = 1;
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
        this.lv = 1;
    }

    /**
     * Constructor with no parameters, when a new game is started (not from a save),
     * this will set up everything needed to play.
     */
    public StageImpl() throws IOException, ClassNotFoundException {
        this.currentScore = 0;
        this.map = new MapFactoryImpl().fromSerialized(1);
        this.player = map.getPlayer();
        this.lv = 1;
        this.ss = map.getAllStaticEntities();
        this.ds = map.getAllDynamicEntities();
        this.toDestroy = new HashSet<>();
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
        return this.player;
    }

    @Override
    public Boss getBoss() {
        return this.map.getBoss();
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
    public List<V2D> getBorders() {
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

    public int getLv() {
        return lv;
    }

    /**
     *
     * {@inheritDoc}
     */
    public void setLv(final int lv) {
        this.lv = lv;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void moveAll() {
        getBoss().move();
        getDynamicEntitySet().forEach(DynamicEntity::move);
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
        //TODO add boss, ok now check them better, this is just to not let the game crash
        getBorders().forEach(e -> {
            if (getBoss().isInShape(e)){
               getBoss().setSpeed(getMap().getAfterCollisionDirection(getBoss()));
            }
        });
        getDynamicEntitySet().forEach(e -> getAllEntities().forEach(t -> {

            if (e.isInShape((ShapedEntity) t) && !e.equals(t)) {
                e.setSpeed(getMap().getAfterCollisionDirection(e));
            }
        }));
        getDynamicEntitySet().forEach(e -> getBorders().forEach(t -> {
            if(e.isInShape(t)){
                e.setSpeed(getMap().getAfterCollisionDirection(e));
            }
        }));
    }
    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void checkAllOutOfBounds() {
        /*getDynamicEntitySet().forEach(e -> {
            if (!((MapImpl) getMap()).isInBorders(e.getPosition())) {
                e.setSpeed(e.getSpeed().scalarMul(-1));
                e.move();
            }
        });*/
        if (!((MapImpl) getMap()).isInBorders(getPlayer().getPosition()) && !getBorders().contains(getPlayer().getPosition())) {

            var l = getPlayer().getTail().getCoordinates().stream().filter(e -> getBorders().contains(e)).collect(Collectors.toList());
            if (l.size()<2) {
                ((DynamicEntity) getPlayer()).setSpeed(getPlayer().getSpeed().scalarMul(-1));
                getPlayer().move();
                getPlayer().changeDirection(Direction.NONE,true);
                ((DynamicEntity) getPlayer()).setSpeed(getPlayer().getSpeed().scalarMul(-1));
                getPlayer().getTail().resetTail();
                return;
            } else if (l.size() > 2) {
               throw new RuntimeException("l:" + l + "Error in tail generation : more then 2 intersactions with borders" + getPlayer().getTail().getCoordinates());
            }
            var tail = getPlayer().getTail().getCoordinates();
            var l0 = l.get(0);
            var l1 = l.get(1);
            if (tail.get(0).equals(l1)) {
               l1 = l0;
               l0 = tail.get(0);
            }
            // the second subTail is need if the tail start and end are the same, to get the index of the end V2D
            l = tail.subList(tail.indexOf(l0), tail.subList(1, tail.size() - 1).indexOf(l1));
            ((DynamicEntity) getPlayer()).setPosition(l1);
            getPlayer().getTail().resetTail();
            l.forEach(getPlayer().getTail()::addPoint);
        }
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
        System.out.println(getBorders());
        getPlayer().move();
        if (!getMap().isPlayerOnBorders() || !getPlayer().getTail().getCoordinates().isEmpty()) {
            ((MapImpl) getMap()).addTailPointsByPlayerSpeed();
        }
        checkAllOutOfBounds();
         if (getMap().isTailCompleted()) {
            getMap().updateBorders(getPlayer().getTail().getCoordinates());
            getPlayer().getTail().resetTail();
            //now to capture all the entities
            getDynamicEntitySet().forEach(e -> {
                if (((MapImpl) getMap()).isInBorders(e.getPosition())) {
                    getToDestroySet().add(e);
                } else {
                    getBorders().forEach(e2 -> {
                        if (e.isInShape(e2)) {
                            map.getAfterCollisionDirection(e);
                        }
                    });
                }
            });
            //TODO check for static entities
        }
        moveAll();
        checkCollisions();
        destroyAll();
    }

    @Override
    public void setEntityManagerController(EntityManager e) {
        this.emController = e;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void createNextLevel() {
        try {
            nextLevelFromSerialized();
        } catch (IOException | ClassNotFoundException e) {

            throw new RuntimeException(e);
        }
    }
    /*
    private void updateStaticEntitiesListFromController() {
        try {
            emController.
        }
    }*/
    /**
     * Uses {@link MapFactoryImpl#fromSerialized(int)} to createMysteryBox the map for the next level,
     * set up the {@link #currentScore} and the {@link #lv}.
     * @throws IOException may be launched attempting to read serialized data
     * @throws ClassNotFoundException may be launched if Map class is changed and the saved one is not updated.
     */
    private void nextLevelFromSerialized() throws IOException, ClassNotFoundException {
        if (getMap().getOccupiedPercentage() > 80) {
            this.setCurrentScore(getCurrentScore() + (int) (getMap().getOccupiedPercentage() * 1000));
            var mf = new MapFactoryImpl();
            this.setLv(getLv() + 1);
            this.setMap(mf.fromSerialized(getLv()));
        }
    }
}
