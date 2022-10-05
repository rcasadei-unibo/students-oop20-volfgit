package vg.model.entity.dynamicEntity.player;

import vg.model.entity.dynamicEntity.DynamicEntity;
import vg.model.timedObject.Shield;
import vg.utils.Direction;
import vg.utils.MassTier;
import vg.utils.Shape;
import vg.utils.V2D;

import java.util.Optional;

/**
 * Player Entity.*/
public final class BasePlayer extends DynamicEntity implements Player {
    /**
     * Maximum player life.
     * */
    public static final int PLAYER_MAX_LIFE = 5;
    /**
     * Default player speed.
     */
    public static final V2D DEFAULT_PLAYER_SPEED = new V2D(1, 1);

    /**
     * Default player radius shape.
     * */
    public static final int DEFAULT_PLAYER_RADIUS = 2;

    /**
     * Default state of capability to shoot of player.
     * */
    public static final boolean DEFAULT_SHOOT_CAPABILITY = false;

    /**
     * Default state of capability to shoot of player.
     * */
    public static final Direction DEFAULT_DIRECTION = Direction.NONE;

    /**
     * Life of player.
     */
    private int life;
    /**
     *  Alternative speed of Player with speed bonus improvement applied. It can be bigger or smaller than actual.
     *  This field keep saved direction and module of speed.
     */
    private Optional<V2D> speedImproved;

    private Direction direction;

    /**
     * Tail created by player while moves in map.
     */
    private final Tail tail;
    /**
     * Player shield.
     * */
    private Shield shield;

    private boolean canShoot;

    /**
     * @param position starting position of player
     * @return Player with default life
     */
    public static BasePlayer newPlayer(final V2D position) {
        return new BasePlayer(position, PLAYER_MAX_LIFE, Shield.create(Shield.DEFAULT_DURATION, true));
    };

    /**
     * If position is negative or greater than maximum life then is set to the maximum allowed.
     * @param position starting position
     * @param life starting life of player
     * @return Player with user define position and life
     */
    public static BasePlayer newPlayer(final V2D position, final int life) {
        int playerLife = life < 0 || life > PLAYER_MAX_LIFE ? PLAYER_MAX_LIFE : life;
        return new BasePlayer(position, playerLife, Shield.create(Shield.DEFAULT_DURATION, true));
    };

    private BasePlayer(final V2D position, final int life, final Shield shield) {
        super(position, DEFAULT_PLAYER_SPEED, DEFAULT_PLAYER_RADIUS, Shape.CIRCLE, MassTier.LOW);
        this.life = life;
        this.tail = TailImpl.emptyTail();
        this.shield = shield;
        this.canShoot = DEFAULT_SHOOT_CAPABILITY;
        this.speedImproved = Optional.empty();
        this.direction = DEFAULT_DIRECTION;
    }

    public void decLife() {
        this.life = this.life > 0 ? this.life - 1 : 0;
    }
    /**
     * {@inheritDoc}
     */
    public void incLife() {
        this.life = this.life + 1;
    }

    @Override
    public int getLife() {
        return this.life;
    }

    /**
     * {@inheritDoc}
     */
    public Tail getTail() {
        return this.tail;
    }

    @Override
    public void setShield(final Shield shield) {
        this.shield = shield;
    }

    @Override
    public Shield getShield() {
        return this.shield;
    }

    /**
     * Update speed direction of basic speed and bonus speed if active.
     * @param dir Direction vector that define sign of speed's coordinates
     */
    public void changeDirection(final Direction dir) {
        this.direction = dir;
    }

    @Override
    public Direction getDirection() {
        return this.direction;
    }

    @Override
    public void move() {
       setPosition(
                this.getPosition().sum(this.getSpeed().mul(this.direction.getVector()))
        );
    }

    @Override
    public void enableSpeedUp(final V2D speed) {
        /*
        * In order to not change direction of move by speed vector
        * is checked if coordinates are negative
        */
        if (this.speedImproved.isEmpty() && speed.getX() >= 0 && speed.getY() > 0) {
            this.speedImproved = Optional.of(speed);
        }
    }

    @Override
    public void disableSpeedUp() {
        this.speedImproved = Optional.empty();
    }

    @Override
    public boolean canShoot() {
        return this.canShoot;
    }

    @Override
    public void enableShoot() {
        this.canShoot = true;
    }

    @Override
    public void disableShoot() {
        this.canShoot = false;
    }

    @Override
    public V2D getSpeed() {
        //if speedUp is set return it else return original speed
        return this.speedImproved.orElseGet(super::getSpeed);
    }

}
