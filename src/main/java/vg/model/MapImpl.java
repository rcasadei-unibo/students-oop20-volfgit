package vg.model;

import vg.model.entity.ShapedEntity;
import vg.model.entity.dynamicEntity.player.Tail;
import vg.model.score.Score;
import vg.model.score.ScoreImpl;
import vg.model.timedObject.Bonus;
import vg.model.entity.Entity;
import vg.model.entity.dynamicEntity.DynamicEntity;
import vg.model.entity.dynamicEntity.bullet.Bolt;
import vg.model.entity.dynamicEntity.bullet.EnemyBolt;
import vg.model.entity.dynamicEntity.enemy.Boss;
import vg.model.entity.dynamicEntity.player.Player;
import vg.model.entity.staticEntity.MysteryBox;
import vg.model.entity.staticEntity.StaticEntity;
import vg.model.timedObject.BonusImpl;
import vg.model.timedObject.BonusType;
import vg.utils.MassTier;
import vg.utils.V2D;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapImpl implements Map<V2D>, Serializable {
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
     * Default max X coordinate.
     */
    private static final int maxBorderX = 200;
    /**
     * Default max Y coordinate.
     */
    private static final int maxBorderY = 150;
    private final Score score;

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
        this.score = new ScoreImpl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getOccupiedPercentage() {
        //approximate and slow, to upgrade
        return ((double) IntStream.rangeClosed(0, maxBorderX).boxed().flatMap(e -> IntStream.rangeClosed(0, maxBorderY).boxed().flatMap(e2 -> Stream.of(new V2D(e, e2)))).filter(e -> !isInBorders(e)).count()) / (maxBorderX * maxBorderY);
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
            throw new IllegalStateException("Attempted to call updateBorders while the tail is not completed");
        }

        var tr = createNewBorder(tail, getBoss().getPosition());
        this.getBorders().addAll(tr);
        this.getBorders().retainAll(tr);
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
        return new HashSet<>(getPlayer().getTail().getCoordinates());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isTailCompleted() {
        return getBorders().contains(getPlayer().getTail().getLastCoordinate());
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
    public void updateBonusTimer(final double elapsedTime) {
        this.getActiveBonus().forEach(bonus -> bonus.updateTimer(elapsedTime));
        Set.copyOf(this.getActiveBonus()).forEach(bonus -> {
            if (bonus.isTimeOver()) {
                this.setBonuses.remove(bonus);
            }
        });
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
     * Creates the new border using the {@link vg.model.entity.dynamicEntity.player.Tail} of the
     * {@link Player} and the position ({@link V2D}) of the {@link Boss}. This method will not update
     * the borders, it is called internally by {@link #updateBorders(Set)}. A side note: the {@link Set}
     * can be extracted by {@link Tail#getCoordinates()}.
     * @param tail a set of {@link V2D}.
     * @param boss the {@link Boss} of the map.
     * @return {@link #getBorders()}
     */
    private Set<V2D> createNewBorder(final Collection<V2D> tail, final V2D boss) {
        List<V2D> t = new LinkedList<>();
        t.add(player.getTail().getLastCoordinate());
        try {
            while (true) {
                t.add(this.getBorders().stream().filter(e -> !t.contains(e) && e.isAdj(t.get(t.size() - 1))).findFirst().orElseThrow());
            }
        } catch (NoSuchElementException e) {
            if (!t.get(0).isAdj(t.get(t.size() - 1))) {
                throw new IllegalStateException("The list of points is not closed; first: " + t.get(0) + " last: " + t.get(t.size() - 1));
            }
        }

        var indInit = t.indexOf(player.getTail().getLastCoordinate());
        var indHalf = t.indexOf(player.getTail().getCoordinates().get(0));
        if (indInit > indHalf) {
            var tmp = indHalf;
            indHalf = indInit;
            indInit = tmp;
        }
        var t1 = Stream.concat(t.subList(indInit, indHalf).stream(), tail.stream()).collect(Collectors.toSet());
        var t2 = Stream.concat(t.subList(indHalf, t.size()).stream(), tail.stream()).collect(Collectors.toSet());
        if (isInBorders(boss, t1)) {
            return t1;
        } else if (isInBorders(boss, t2)) {
            return t2;
        } else {
            throw new IllegalStateException("Failed to create a new border (Boss too big?)");
        }
    }
    /**
     * Method to check if a point will be closed by the border
     * or not. Works only with points
     * @param pos the starting position from which to check
     * @param tail the tail that will become the new border
     * @param boss the boss of the map
     * @return true if the position will be outside the map
     *         and will be captured/deleted, false otherwise
     */
    public boolean isClosedByTail(final V2D pos, final Set<V2D> tail, final Boss boss) {


        if (tail.contains(pos)) {
            return false;
        }
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
            if (tail.contains(step.sum(new V2D(-dx, Math.signum(-dy) * i)))) {
                //the original point is between the tail and the boss

                return true;
            }
        }
        // if the cycles finished and tail not contains a point between pos and the boss
        return false;
    }

    /**
     * Checks if a position is inside the current borders.
     * @param pos the position to check
     * @return true if the position is inside the borders, false otherwise
     */
    public boolean isInBorders(final V2D pos) {
        if (getBorders().contains(pos) || pos.getX() < 0) {
            return false;
        }
        List<Integer> segments = new ArrayList<>();
        var t = IntStream.rangeClosed(1, this.maxBorderX)
                .filter(e -> getBorders().contains(new V2D(e, pos.getY())) != getBorders().contains(new V2D(e - 1, pos.getY())))
                .peek(segments::add).filter(e -> pos.getX() < e).findFirst();
         Collections.reverse(segments);

        if (t.isPresent()) {
            return segments.indexOf(t.getAsInt()) % 2 == 0;
        } else {
            return false;
        }
    }
    private boolean isInBorders(final V2D pos, final Set<V2D> borders) {
        List<Integer> segments = new ArrayList<>();
        var t = IntStream.rangeClosed(1, this.maxBorderX)
                .filter(e -> borders.contains(new V2D(e, pos.getY())) != borders.contains(new V2D(e - 1, pos.getY())))
                .peek(segments::add).filter(e -> pos.getX() < e).findFirst();

        Collections.reverse(segments);
        if (t.isPresent()) {
            return segments.indexOf(t.getAsInt()) % 2 == 0;
        } else {
            return false;
        }
    }
    /**
     * This method tell if a position is valid on the
     * map (not out of borders and is not on the same
     * position with other entities that has a mass
     * tier higher then {@link vg.utils.MassTier#NOCOLLISION}).
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
        return isInBorders(pos);
    }
    /**
     * Overloading for checking if a position is valid but removing one
     * entity from checks. This is used in {@link MapImpl#getAfterCollisionDirection(DynamicEntity)}
     * where it checks for every entity how to "bounce" but it excludes itself from computations
     * (and the entities that has a mass tier lower).
     * @param pos the position to check
     * @param toRemove the entity to remove
     * @return true if the position is valid and can be occupied, false otherwise
     */
    public boolean isPositionValid(final V2D pos, final ShapedEntity toRemove) {
        if (getAllStaticEntities().stream().anyMatch(e -> e.isInShape(pos) && !e.equals(toRemove))) {
            return false;
        }
        if (getAllDynamicEntities().stream()
                .filter(e -> e.getMassTier() != MassTier.NOCOLLISION && !e.equals(toRemove))
                .filter(e -> e.getMassTier().ordinal() >= toRemove.getMassTier().ordinal())
                .anyMatch(e -> e.isInShape(pos))) {
            return false;
        }
        return isInBorders(pos);
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
            return de.getSpeed().mul(new V2D(-1, -1));
        } else {
            var x = t.getX() == 0 ? 1 : -1;
            var y = t.getY() == 0 ? 1 : -1;
            return de.getSpeed().mul(x, y);
        }
    }

}
