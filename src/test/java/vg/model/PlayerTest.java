package vg.model;

import org.junit.jupiter.api.Test;
import vg.model.entity.dynamicEntity.player.BasePlayer;
import vg.model.entity.dynamicEntity.player.Player;
import vg.utils.Direction;
import vg.utils.V2D;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {
    V2D position = new V2D(5, 5);
    Player pl = BasePlayer.newPlayer(position);

    @Test
    void lifeDecInc() {
        assertEquals(BasePlayer.PLAYER_MAX_LIFE, pl.getLife());
        pl.incLife();
        assertEquals(BasePlayer.PLAYER_MAX_LIFE+1, pl.getLife());
        pl.decLife();
        assertEquals(BasePlayer.PLAYER_MAX_LIFE, pl.getLife());
    }

    @Test
    void playerMove() {
        assertEquals(position, pl.getPosition());
        pl.move();
        assertEquals(new V2D(5, 5), pl.getPosition());
        pl.changeDirection(Direction.DOWN);
        pl.move();
        pl.move();
        pl.move();
        assertEquals(new V2D(5, 8), pl.getPosition());

        pl.changeDirection(Direction.LEFT);
        pl.move();
        pl.move();
        pl.move();
        assertEquals(new V2D(2, 8), pl.getPosition());
        
    }

    @Test
    void changeDirection() {
        /*
         * Where speed of entity is module of movement
         * direction define in which way
         */
        assertEquals(position, pl.getPosition());

        pl.changeDirection(Direction.DOWN);
        pl.move();
        assertEquals(new V2D(5, 6), pl.getPosition());

    }
}
