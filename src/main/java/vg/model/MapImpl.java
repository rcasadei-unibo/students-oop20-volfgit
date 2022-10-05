package vg.model;

import vg.model.entity.ShapedEntity;
import vg.model.timedObject.Bonus;
import vg.model.entity.Entity;
import vg.model.entity.dynamicEntity.DynamicEntity;
import vg.model.entity.dynamicEntity.bolt.Bolt;
import vg.model.entity.dynamicEntity.bolt.EnemyBolt;
import vg.model.entity.dynamicEntity.enemy.Boss;
import vg.model.entity.dynamicEntity.player.Player;
import vg.model.entity.staticEntity.MysteryBox;
import vg.model.entity.staticEntity.StaticEntity;
import vg.utils.MassTier;
import vg.utils.V2D;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapImpl implements Map<V2D> {
    /**
     * The player.
     * @see Player
     */
    private final Player player;
    /**
     * The boss.
     * @see Boss
     */
    private final Boss boss;
    /**
     * Set of active bonuses that affect the player.
     * @see Bonus
     */
    private final Set<Bonus> setBonuses;
    /**
     * Set of all static entities on the map.
     * @see StaticEntity
     */
    private final Set<StaticEntity> staticEntitySet;
    /**
     * Set of all dynamic entities on the map,
     * excluding the player and the boss.
     * @see DynamicEntity
     */
    private final Set<DynamicEntity> dynamicEntitySet;

    /**
     * The Set of {@link V2D} position that will indicate
     * the current border of the map.
     * @see Map#getBorders()
     */
    private final Set<V2D> border;
    /**
     * Constructor for MapImpl.
     *
     * @param player           the player of the map
     * @param boss             the boss of the map
     * @param setBonuses       the set of active bonuses
     * @param staticEntitySet  the set of all static entities
     * @param dynamicEntitySet the set of all dynamic entities
     * @param border           the border of the map
     */
    public MapImpl(final Player player, final Boss boss, final Set<Bonus> setBonuses, final Set<StaticEntity> staticEntitySet, final Set<DynamicEntity> dynamicEntitySet, final Set<V2D> border) {
        this.player = player;
        this.boss = boss;
        this.setBonuses = setBonuses;
        this.staticEntitySet = staticEntitySet;
        this.dynamicEntitySet = dynamicEntitySet;
        this.border = border;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getOccupiedPercentage() {
        //TODO effettivamente calcolare la percentuale per differenze immagino
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
        //internal check if the tail is actually completed
        //and the borders can be updated from it
        if (!isTailCompleted()) {
            throw new IllegalStateException();
        }
        //before updating the Borders Entity that needs to be captured
        //must be deleted, but that is not a responsibility of this
        //method neither this class
        var tr = new HashSet<V2D>();
        getBorders().forEach(e -> {
            if (isClosedByTail(e, tail, getBoss())) {
               tr.add(e);
            }
        });
        getBorders().removeAll(tr);
        getBorders().addAll(tail);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Player getPlayer() {
        return this.player;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Set<V2D> getTail() {
        return new HashSet<>(getPlayer().getPlayerTail().getCoordinates());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isTailCompleted() {
        return getBorders().contains(getPlayer().getPlayerTail().getLastCoordinate());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toCapture(final Entity toCheck) {
        return isClosedByTail(toCheck.getPosition(), getTail(), getBoss());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void removeEntity(final Entity toRemove) {
        if (toRemove instanceof DynamicEntity) {
           getAllDynamicEntities().remove(toRemove);
        } else if (toRemove instanceof StaticEntity) {
            getAllStaticEntities().remove(toRemove);
        } else {
            throw new IllegalArgumentException();
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Bonus> getActiveBonus() {
        return this.setBonuses;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Set<MysteryBox<Bonus>> getAllMysteryBoxes() {
        //TODO check the cast to be safe
        return this.staticEntitySet.stream().filter(e -> e instanceof MysteryBox).map(e -> (MysteryBox<Bonus>) e).collect(Collectors.<MysteryBox<Bonus>>toSet());
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
     * If the position to check is on the tail, this return true.
     * This method can be used to check if a position is "outside"
     * the current borders.
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
        for (int i = 0; i <= Math.abs(dx); i++) {
            if (tail.contains(step.sum(new V2D(Math.signum(-dx) * i, 0)))) {
                //the original point is between the tail and the boss
                return true;
            }
        }
        for (int i = 0; i <= Math.abs(dy); i++) {
            if (tail.contains(step.sum(new V2D(pos.getX() - dx, Math.signum(-dx) * i)))) {
                //the original point is between the tail and the boss
                return true;
            }
        }
        // if the cycles finished and tail not contains a point between pos and the boss
        return false;
    }

    /**
     * This method tell if a position is valid on the
     * map (not out of borders and is not on the same
     * position with other entities that has a mass
     * tier higher then {@link vg.utils.MassTier#NOCOLLISION}.
     * @param pos the position to check
     * @return true if the position can be occupied, false otherwise
     */
    public boolean isPositionValid(final V2D pos) {
        if (getAllStaticEntities().stream().anyMatch(e -> e.isInShape(pos))) {
            return false;
        }
        if (getAllDynamicEntities().stream().filter(e -> e.getMassTier() != MassTier.NOCOLLISION).anyMatch(e -> e.isInShape(pos))) {
            return false;
        }
        return !isClosedByTail(pos, getBorders(), getBoss());
    }
    /**
     * Overloading for checking if a position is valid but removing one
     * entity from checks.
     * @param pos the position to check
     * @param toRemove the entity to remove
     * @return true if the position is valid and can be occupied, false otherwise
     */
    public boolean isPositionValid(final V2D pos, final ShapedEntity toRemove) {
        if (getAllStaticEntities().stream().anyMatch(e -> e.isInShape(pos) && !e.equals(toRemove))) {
            return false;
        }
        if (getAllDynamicEntities().stream().filter(e -> e.getMassTier() != MassTier.NOCOLLISION && !e.equals(toRemove)).anyMatch(e -> e.isInShape(pos))) {
            return false;
        }
        return !isClosedByTail(pos, getBorders(), getBoss());
    }

    /**
     * This method will compute what is the correct direction
     * to take for an entity that is colliding.
     * @param de the entity to compute the new direction
     * @return the correct speed to apply to the entity
     */
    public V2D getAfterCollisionDirection(final DynamicEntity de) {
        var t = Stream.of(-1, 1).flatMap(e -> Stream.of(new V2D(e, 0), new V2D(0, e))).
                filter(e -> isPositionValid(e.sum(de.getPosition()), de)).reduce(new V2D(0, 0), V2D::sum);
        if (!(t.getX() == 0 || 0 == t.getY()) || t.getX() == t.getY()) {
            System.out.println(de.getSpeed().mul(new V2D(-1, -1)));
            return de.getSpeed().mul(new V2D(-1, -1));
        } else {
            var x = t.getX() == 0 ? 1 : -1;
            var y = t.getY() == 0 ? 1 : -1;
            return de.getSpeed().mul(x, y);
        }
    }

}
