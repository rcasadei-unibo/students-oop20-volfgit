package vg.model;

import org.junit.jupiter.api.Test;
import vg.model.entity.Entity;
import vg.model.entity.ShapedEntity;
import vg.model.entity.dynamicEntity.DynamicEntity;
import vg.model.entity.dynamicEntity.enemy.Boss;
import vg.model.entity.dynamicEntity.player.BasePlayer;
import vg.model.entity.dynamicEntity.player.Player;

import vg.model.entity.staticEntity.StaticEntity;
import vg.utils.Direction;
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
    Map<V2D> map = new MapImpl(player,boss,new HashSet<>(),new HashSet<>(), IntStream.rangeClosed(0,200).boxed().
            flatMap(e -> Stream.of(new V2D(e,0),new V2D(0,e), new V2D(200,e), new V2D(e,150))).filter(e->e.getY()<=150).
            collect(Collectors.toSet()));
    @Test
    void getOccupiedPercentage() {
        player.getTail().resetTail();
        IntStream.rangeClosed(0,200).boxed().flatMap(e -> Stream.of(new V2D(e,150))).sorted((e1,e2) -> (int) (e1.getX() - e2.getX())).forEach(e -> player.getTail().addPoint(e));
        map.updateBorders(player.getTail().getCoordinates());
        assertFalse(map.getBorders().contains(new V2D(199,151)));
        assertTrue(map.getBorders().contains(new V2D(133, 150)));
        assertTrue(map.getBorders().contains(new V2D(133, 0)));
        assertTrue(map.getBorders().contains(new V2D(0, 150)));
        //assertTrue(map.getOccupiedPercentage()<0.05);
        player.getTail().resetTail();
        IntStream.rangeClosed(0,200).boxed().flatMap(e -> Stream.of(new V2D(e,75))).sorted((e1,e2) -> (int) (e1.getX() - e2.getX())).forEach(e -> player.getTail().addPoint(e));
        map.updateBorders(player.getTail().getCoordinates());
        assertFalse(map.getBorders().contains(new V2D(199,91)));
        assertTrue(map.getBorders().contains(new V2D(133, 75)));
        assertTrue(map.getBorders().contains(new V2D(133, 0)));
        assertTrue(map.getBorders().contains(new V2D(0, 75)));
        //assertTrue(map.getOccupiedPercentage()>0.5);
        player.getTail().resetTail();
        IntStream.rangeClosed(0,75).boxed().flatMap(e -> Stream.of(new V2D(120,e))).sorted((e1,e2) -> (int) (e1.getY() - e2.getY())).forEach(e -> player.getTail().addPoint(e));
        assertTrue(map.isTailCompleted());
        map.updateBorders(player.getTail().getCoordinates());
        assertTrue(map.getBorders().contains(new V2D(120,75)));
        assertTrue(map.getBorders().contains(new V2D(120,30)));
        assertFalse(map.getBorders().contains(new V2D(120,80)));
        assertFalse(map.getBorders().contains(new V2D(130,60)));
        map.getPlayer().getTail().resetTail();
        IntStream.rangeClosed(0,25).boxed().flatMap(e -> Stream.of(new V2D(5,e))).sorted((e1,e2) -> (int) (e1.getX() - e2.getX())).forEach(e -> player.getTail().addPoint(e));
        IntStream.rangeClosed(0,2).boxed().flatMap(e -> Stream.of(new V2D(e + 5,25))).sorted((e1,e2) -> (int) (e1.getX() - e2.getX())).forEach(e -> player.getTail().addPoint(e));
        IntStream.rangeClosed(0,25).boxed().flatMap(e -> Stream.of(new V2D(7,25-e))).sorted((e1,e2) -> (int) (e1.getX() - e2.getX())).forEach(e -> player.getTail().addPoint(e));
        //System.out.println(map.getBoss().getPosition());
        assertTrue(((MapImpl)map).isInBorders(map.getBoss().getPosition()));
        //System.out.println(map.getBorders().stream().sorted((e1,e2) -> (int)(1000*e1.getX() -1000*e2.getX() + e1.getY()- e1.getY())).collect(Collectors.toList()));
        assertTrue(map.getBorders().contains(new V2D(10,0)));
        map.updateBorders(player.getTail().getCoordinates());
        assertFalse(map.getBorders().contains(new V2D(6,6)));
        assertTrue(map.getBorders().contains(new V2D(5,5)));
        assertFalse(((MapImpl)map).isInBorders(new V2D(5,5)));
        ((MapImpl)map).isInBorderAxis(50);
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
        assertTrue(new V2D(5,100).isAdj(new V2D(6,100)));

        assertTrue(new V2D(5,100).isAdj(new V2D(4,100)));

        assertTrue(new V2D(5,100).isAdj(new V2D(5,101)));

        assertTrue(new V2D(5,100).isAdj(new V2D(5,99)));
        assertFalse(new V2D(5,150).isAdj(new V2D(6,0)));
        assertTrue(map.getBorders().contains(new V2D(0,0)));
        assertTrue(map.getBorders().contains(new V2D(5,0)));
        assertTrue(map.getBorders().contains(new V2D(5,150)));
        //assertTrue(map.getBorders().contains(new V2D(5,151)));


        player.getTail().resetTail();
       // System.out.println(map.getBorders().stream().sorted((e, e2) -> (int) (1000*e.getX() -1000*e2.getX() +e.getY() - e2.getY())).collect(Collectors.toList()));
        tail.stream().sorted((e, e2) -> (int) (e.getY() - e2.getY())).forEach(player.getTail()::addPoint);
      //  System.out.println(player.getTail().getCoordinates().stream().sorted((e, e2) -> (int) (e.getY() - e2.getY())).collect(Collectors.toList()));
        map.updateBorders(player.getTail().getCoordinates());
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
        //TODO
        var toCheckD = new DynamicEntityImpl(new V2D(2,2), new V2D(5,0),2, Shape.CIRCLE,MassTier.HIGH);
        //var toCheckS = new FixedMysteryBox(new V2D(2,2),2, null);
        map.getAllDynamicEntities().add(toCheckD);
        //map.getAllStaticEntities().add(toCheckS);
        //assertTrue(map.getAllMysteryBoxes().contains(toCheckS));
        //map.removeEntity(toCheckS);
       // assertFalse(map.getAllMysteryBoxes().contains(toCheckS));

    }

    @Test
    void addTailPointsByPlayerSpeed() {
        assertTrue(player.getPosition().equals(new V2D(20,20)));
        assertFalse(map.isPlayerOnBorders());
        assertTrue(((MapImpl) map).isInBorders(player.getPosition()));
        assertTrue(player.getTail().getCoordinates().isEmpty());
        //In this test doesn't matter if player is on border or not
        player.changeDirection(Direction.RIGHT, false);
        ((DynamicEntity) player).setSpeed(new V2D(5,0));
        assertTrue(player.getSpeed().equals(new V2D(5,0)));
        if (!map.isPlayerOnBorders()) {
            ((MapImpl) map).addTailPointsByPlayerSpeed();
        }

        assertTrue(player.getTail().getCoordinates().contains(new V2D(16,20)));
        assertTrue(player.getTail().getCoordinates().contains(new V2D(20,20)));
        assertFalse(player.getTail().getCoordinates().contains(new V2D(15,20)));
        assertFalse(player.getTail().getCoordinates().contains(new V2D(21,20)));
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
        assertFalse( ((MapImpl) map).isPositionValid(new V2D(10,-99)));
        assertFalse( ((MapImpl) map).isPositionValid(new V2D(-10,99)));
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