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
    Set<V2D> tail = IntStream.rangeClosed(0, 150).boxed().flatMap(e -> Stream.of(new V2D(5, e))).collect(Collectors.toSet());
    Map<V2D> map = new MapImpl(player,boss,new HashSet<>(),new HashSet<>(),new HashSet<>(), IntStream.rangeClosed(0,200).boxed().
            flatMap(e -> Stream.of(new V2D(e,0),new V2D(0,e), new V2D(200,e), new V2D(e,150))).filter(e->e.getY()<=150).
            collect(Collectors.toSet()));
    @Test
    void getOccupiedPercentage() {
        player.getTail().resetTail();
        IntStream.rangeClosed(0,200).boxed().flatMap(e -> Stream.of(new V2D(e,150))).sorted((e1,e2) -> (int) (e1.getX() - e2.getX())).forEach(e -> player.getTail().addPoint(e));
        map.updateBorders(Set.copyOf(player.getTail().getCoordinates()));
        assertFalse(map.getBorders().contains(new V2D(199,151)));
        assertTrue(map.getBorders().contains(new V2D(133, 150)));
        assertTrue(map.getBorders().contains(new V2D(133, 0)));
        assertTrue(map.getBorders().contains(new V2D(0, 150)));
        assertTrue(map.getOccupiedPercentage()<0.05);
        player.getTail().resetTail();
        IntStream.rangeClosed(0,200).boxed().flatMap(e -> Stream.of(new V2D(e,75))).sorted((e1,e2) -> (int) (e1.getX() - e2.getX())).forEach(e -> player.getTail().addPoint(e));
        map.updateBorders(Set.copyOf(player.getTail().getCoordinates()));
        assertFalse(map.getBorders().contains(new V2D(199,91)));
        assertTrue(map.getBorders().contains(new V2D(133, 75)));
        assertTrue(map.getBorders().contains(new V2D(133, 0)));
        assertTrue(map.getBorders().contains(new V2D(0, 75)));
        assertTrue(map.getOccupiedPercentage()>0.5);
        IntStream.rangeClosed(0,75).boxed().flatMap(e -> Stream.of(new V2D(120,e))).sorted((e1,e2) -> (int) (e1.getY() - e2.getY())).forEach(e -> player.getTail().addPoint(e));
        assertTrue(map.isTailCompleted());
        map.updateBorders(Set.copyOf(player.getTail().getCoordinates()));
        assertTrue(map.getBorders().contains(new V2D(120,75)));
        assertTrue(map.getBorders().contains(new V2D(120,30)));
        assertFalse(map.getBorders().contains(new V2D(120,80)));
        assertFalse(map.getBorders().contains(new V2D(130,60)));

    }

    @Test
    void getBorders() {
        assertTrue(map.getBorders().contains(new V2D(0,0)));
        assertFalse(map.getBorders().contains(new V2D(1,1)));
        assertTrue(map.getBorders().contains(new V2D(180,0)));
        assertFalse(map.getBorders().contains(new V2D(201,201)));
        assertFalse(map.getBorders().contains( new V2D(0,170)));
        assertTrue(map.getBorders().contains(new V2D(120,150)));

    }

    @Test
    void updateBorders() {
        tail.stream().sorted((e, e2) -> (int) (e.getY() - e2.getY())).forEach(player.getTail()::addPoint);
        map.updateBorders(tail);
        assertFalse(map.getBorders().contains(new V2D(0,0)));
        assertTrue(map.getBorders().contains(new V2D(5,150)));
    }

    @Test
    void toCapture() {
        assertTrue(map.getBorders().contains(new V2D(0,0)));
        assertTrue(player.getTail().getCoordinates().isEmpty());
        tail.stream().sorted((e, e2) -> (int) (e.getY() - e2.getY())).forEach(player.getTail()::addPoint);
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

    @Test
    void getAfterCollisionDirection(){
        assertTrue( ((MapImpl) map).isPositionValid(new V2D(1,1)));
        assertFalse( ((MapImpl) map).isPositionValid(new V2D(0,1)));
        assertFalse( ((MapImpl) map).isPositionValid(new V2D(1,0)));
        assertFalse( ((MapImpl) map).isPositionValid(new V2D(0,0)));
        var toCheckD = new DynamicEntityImpl(new V2D(1,1), new V2D(-1,-1),2, Shape.CIRCLE,MassTier.HIGH);
        var toCheckD2 = new DynamicEntityImpl(new V2D(3,100), new V2D(-3,-1),2, Shape.CIRCLE,MassTier.HIGH);
        toCheckD.move();
        var t = map.getAfterCollisionDirection(toCheckD);
        assertEquals(t, new V2D(1, 1));
        toCheckD2.move();
        assertEquals(toCheckD2.getPosition(), new V2D(0,99) );
        assertTrue( ((MapImpl) map).isPositionValid(new V2D(1,99)));
        assertFalse( ((MapImpl) map).isPositionValid(new V2D(0,98)));
        assertFalse( ((MapImpl) map).isPositionValid(new V2D(0,100)));
        assertFalse( ((MapImpl) map).isPositionValid(new V2D(-1,99)));
        var t2 = map.getAfterCollisionDirection(toCheckD2);
        assertEquals(t2, new V2D(3,-1));

        toCheckD.setPosition(new V2D(51,51));
        toCheckD2.setPosition(new V2D(48,48));
        assertFalse(toCheckD.isInShape(toCheckD2));
        toCheckD.setSpeed( new V2D(-1,-1));
        toCheckD.move();
        assertFalse(toCheckD2.isInShape(toCheckD));
        toCheckD.move();
        assertTrue(toCheckD2.isInShape(toCheckD));
        var t3 = map.getAfterCollisionDirection(toCheckD);
        assertEquals(t3, new V2D(1,1));
    }
}