package vg.model.entity.dynamicEntity;

import vg.utils.V2D;

/**
 * Player Entity*/
public class Player extends DynamicEntity {
    static final int PLAYER_MAX_LIFE = 5;
    private int life;
    private Tail tail;
    //private Shield shield;

    /**
     * @return Player with default life*/
    public static Player newPlayer(final V2D position){
        return new Player(position,PLAYER_MAX_LIFE);
    };

    /**
     * If position is negative or greater than maximum life then is set to the maximum allowed
     * @return Player with user define position and life*/
    public static Player newPlayer(final V2D position, final int life) {
        int playerLife = life < 0 || life > PLAYER_MAX_LIFE ? PLAYER_MAX_LIFE : life;
        return new Player(position,playerLife);
    };

    private Player(final V2D position, final int life) {
        super(position,new V2D(2,2));
        this.life = life;
        this.tail = TailImpl.emptyTail();
        //TODO: init shield
        //this.shield = new Shield();
    }

}
