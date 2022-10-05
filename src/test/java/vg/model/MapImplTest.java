package vg.model;

import org.junit.jupiter.api.Test;
import vg.model.entity.Entity;
import vg.model.entity.ShapedEntity;
import vg.model.entity.dynamicEntity.DynamicEntity;
import vg.model.entity.dynamicEntity.enemy.Boss;
import vg.model.entity.dynamicEntity.player.BasePlayer;
import vg.model.entity.dynamicEntity.player.Player;
import vg.model.entity.staticEntity.FixedMysteryBox;
import vg.model.entity.staticEntity.StaticEntity;
import vg.utils.MassTier;
import vg.utils.Shape;
import vg.utils.V2D;

import java.util.HashSet;
import java.util.Set;
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
    private class DynamicEntityImpl extends DynamicEntity {

        public DynamicEntityImpl(V2D position, V2D speed, int radius, Shape shape, MassTier massTier) {
            super(position, speed, radius, shape, massTier);
        }
    }
    Player player = BasePlayer.newPlayer(new V2D(20,20));
    Boss boss = new BossImpl();
    Set<V2D> tail = IntStream.range(0, 201).boxed().flatMap(e -> Stream.of(new V2D(5, e))).collect(Collectors.toSet());
    Map<V2D> map = new MapImpl(player,boss,new HashSet<>(),new HashSet<>(),new HashSet<>(), IntStream.range(0,201).boxed().
            flatMap(e -> Stream.of(new V2D(e,0),new V2D(0,e), new V2D(200,e), new V2D(e,200))).
            collect(Collectors.toSet()));
    @Test
    void getOccupiedPercentage() {
    }

    @Test
    void getBorders() {
        assertTrue(map.getBorders().contains(new V2D(0,0)));
        assertFalse(map.getBorders().contains(new V2D(1,1)));
        assertTrue(map.getBorders().contains(new V2D(180,0)));
        assertFalse(map.getBorders().contains(new V2D(201,201)));

    }

    @Test
    void updateBorders() {
        //TODO rewrite the next 2 lines

        tail.stream().sorted((e, e2) -> (int) (e.getY() - e2.getY())).forEach(player.getPlayerTail()::addPoint);
        map.updateBorders(tail);
        assertFalse(map.getBorders().contains(new V2D(0,0)));
        assertTrue(map.getBorders().contains(new V2D(5,150)));
    }

    @Test
    void toCapture() {
        assertTrue(map.getBorders().contains(new V2D(0,0)));
        assertTrue(player.getPlayerTail().getCoordinates().isEmpty());
        tail.stream().sorted((e, e2) -> (int) (e.getY() - e2.getY())).forEach(player.getPlayerTail()::addPoint);
        assertTrue(map.isTailCompleted());
        var toCheck = new DynamicEntityImpl(new V2D(2,2), new V2D(5,0),2, Shape.CIRCLE,MassTier.HIGH);
        map.getAllDynamicEntities().add(toCheck);
        assertTrue(map.toCapture(toCheck));
        toCheck.move();
        assertFalse(map.toCapture(toCheck));
    }

    @Test
    void removeEntity() {
        var toCheckD = new DynamicEntityImpl(new V2D(2,2), new V2D(5,0),2, Shape.CIRCLE,MassTier.HIGH);
        var toCheckS = new FixedMysteryBox(new V2D(2,2),2, null);
        map.getAllDynamicEntities().add(toCheckD);
        map.getAllStaticEntities().add(toCheckS);
        assertTrue(map.getAllMysteryBoxes().contains(toCheckS));
        map.removeEntity(toCheckS);
        assertFalse(map.getAllMysteryBoxes().contains(toCheckS));
        
    }

    @Test
    void getActiveBonus() {
    }

    @Test
    void getFriendlyBolts() {
    }
}