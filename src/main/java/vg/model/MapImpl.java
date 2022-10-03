package vg.model;

import vg.model.bonus.Bonus;
import vg.model.entity.Entity;
import vg.model.entity.dynamicEntity.DynamicEntity;
import vg.model.entity.dynamicEntity.bolt.Bolt;
import vg.model.entity.dynamicEntity.bolt.EnemyBolt;
import vg.model.entity.dynamicEntity.enemy.Boss;
import vg.model.entity.dynamicEntity.player.Player;
import vg.model.entity.staticEntity.MysteryBox;
import vg.model.entity.staticEntity.StaticEntity;
import vg.utils.V2D;

import java.util.Set;
import java.util.stream.Collectors;

public class MapImpl implements Map<V2D> {
    /**
     * The player.
     * @see Player
     */
    private Player player;
    /**
     * The boss.
     * @see Boss
     */
    private Boss boss;
    /**
     * Set of all static entities on the map.
     * @see StaticEntity
     */
    private Set<StaticEntity> staticEntitySet;
    /**
     * Set of all dynamic entities on the map,
     * excluding the player and the boss.
     * @see DynamicEntity
     */
    private Set<DynamicEntity> dynamicEntitySet;

    /**
     * The Set of {@link V2D} position that will indicate
     * the current border of the map.
     * @see Map#getBorders()
     */
    private Set<V2D> border;
    /**
     * Constructor for MapImpl.
     *
     * @param player           the player of the map
     * @param boss             the boss of the map
     * @param staticEntitySet  the set of all static entities
     * @param dynamicEntitySet the set of all dynamic entities
     * @param border           the border of the map
     */
    public MapImpl(final Player player, final Boss boss, final Set<StaticEntity> staticEntitySet, final Set<DynamicEntity> dynamicEntitySet, final Set<V2D> border) {
        this.player = player;
        this.boss = boss;
        this.staticEntitySet = staticEntitySet;
        this.dynamicEntitySet = dynamicEntitySet;
        this.border = border;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getOccupiedPercentage() {
        return 0;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Set<V2D> getBorders() {
        return this.border;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void updateBorders(final Set<V2D> tail) {

    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Player getPlayer() {
        return null;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Set<V2D> getTail() {
        return null;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isTailCompleted() {
        return false;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toCapture(final Entity toCheck) {
        return false;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void removeEntity(final Entity toRemove) {

    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Bonus> getActiveBonus() {
        return null;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Set<MysteryBox<Bonus>> getAllMysteryBoxes() {
        //TODO check the cast to be safe
        return this.staticEntitySet.stream().filter(e -> e instanceof MysteryBox).map(e -> (MysteryBox<Bonus>)e).collect(Collectors.<MysteryBox<Bonus>>toSet());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Set<StaticEntity> getAllStaticEntities() {
        return this.staticEntitySet;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Set<DynamicEntity> getAllDynamicEntities() {
        return this.dynamicEntitySet;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Set<DynamicEntity> getBolts() {
        return this.dynamicEntitySet.stream().filter(e -> e instanceof Bolt).collect(Collectors.toSet());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Set<DynamicEntity> getEnemyBolts() {
        return this.dynamicEntitySet.stream().filter(e -> e instanceof EnemyBolt).collect(Collectors.toSet());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Set<DynamicEntity> getFriendlyBolts() {
        //TODO updated with correct Bolt logic where there will be one
        return this.dynamicEntitySet.stream().filter(e -> e instanceof Bolt && !(e instanceof EnemyBolt)).collect(Collectors.toSet());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Boss getBoss() {
        return this.boss;
    }

    /**
     * Function that checks if a position is on the same "side"
     * as the boss or not, this means that only 1 boss at the
     * same time can be present on the map. The final parameter,
     * boss, is there for a possible future overloading of this
     * method so more than one boss will be possible to have.
     * @param pos the starting position from which to check
     * @param tail the tail that will become the new border
     * @param boss the boss of the map
     * @return true if the position will be outside the map
     *         and will be captured/deleted, false otherwise
     */
    private boolean isClosedByTail(final V2D pos, final Set<V2D> tail, final Boss boss) {

        V2D step = new V2D(pos);
        var dx = pos.getX() - boss.getPosition().getX();
        var dy = pos.getY() - boss.getPosition().getY();
        for (int i = 0; i < Math.abs(dx); i++) {
            if (tail.contains(step.sum(new V2D(Math.signum(-dx) * i, 0)))) {
                //the original point is between the tail and the boss
                return true;
            }
        }
        for (int i = 0; i < Math.abs(dy); i++) {
            if (tail.contains(step.sum(new V2D(pos.getX() - dx, Math.signum(-dx) * i)))) {
                //the original point is between the tail and the boss
                return true;
            }
        }
        // if the cycles finished and tail not contains a point between pos and the boss
        return false;
    }

}
