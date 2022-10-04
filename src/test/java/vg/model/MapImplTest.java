package vg.model;

import org.junit.jupiter.api.Test;
import vg.model.entity.dynamicEntity.enemy.Boss;
import vg.model.entity.dynamicEntity.player.BasePlayer;
import vg.model.entity.dynamicEntity.player.Player;
import vg.utils.MassTier;
import vg.utils.Shape;
import vg.utils.V2D;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MapImplTest {

    private class BossImpl extends Boss {
        BossImpl(){
            super(new V2D(10,10),new V2D(1,1),5, Shape.SQUARE,MassTier.HIGH);
        }
    }
    Player player = BasePlayer.newPlayer(new V2D(20,20));
    Boss boss = new BossImpl();
    Map map = new MapImpl(player,boss,new HashSet<>(),new HashSet<>(),new HashSet<>(), Stream.of(0,200).
            flatMap(e -> Stream.of(new V2D(e,0),new V2D(0,e), new V2D(200,e), new V2D(e,200))).
            collect(Collectors.toSet()));
    @Test
    void getOccupiedPercentage() {
    }

    @Test
    void getBorders() {
        assertTrue(map.getBorders().contains(new V2D(0,0)));
    }

    @Test
    void updateBorders() {
    }

    @Test
    void isTailCompleted() {
    }

    @Test
    void toCapture() {
    }

    @Test
    void removeEntity() {
    }

    @Test
    void getActiveBonus() {
    }

    @Test
    void getAllMysteryBoxes() {
    }

    @Test
    void getFriendlyBolts() {
    }
}