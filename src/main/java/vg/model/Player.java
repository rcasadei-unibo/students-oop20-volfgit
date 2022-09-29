package vg.model;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import vg.utils.Position;

public class Player extends DynamicEntity {
    static final int PLAYER_MAX_LIFE = 5;
    private int life;
    //private Shield shield;

    public static Player newPlayer(final Position position){
        return new Player(position,PLAYER_MAX_LIFE);
    };

    public static Player newPlayer(final Position position, final int life) {
        return new Player(position,life);
    };

    private Player(final Position position, final int life) {
        super(position);
        this.life = life;
        //TODO: init shield
        //this.shield = new Shield();
    }

}
