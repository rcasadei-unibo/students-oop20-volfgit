package vg.model.player;

import vg.model.DynamicEntity;
import vg.utils.Position;
import vg.utils.Speed;

public class Player extends DynamicEntity {
    static final int PLAYER_MAX_LIFE = 5;
    private int life;
    private Tail tail;
    //private Shield shield;

    public static Player newPlayer(final Position position){
        return new Player(position,PLAYER_MAX_LIFE);
    };

    public static Player newPlayer(final Position position, final int life) {
        return new Player(position,life);
    };

    private Player(final Position position, final int life) {
        super(position,new Speed(2,2));
        this.life = life;
        this.tail = TailImpl.emptyTail();
        //TODO: init shield
        //this.shield = new Shield();
    }

}
