package vg.model.levels;

import vg.model.Boss.BossImpl;
import vg.model.Map;
import vg.model.MapImpl;
import vg.model.entity.dynamicEntity.DynamicEntity;
import vg.model.entity.dynamicEntity.enemy.Boss;
import vg.model.entity.dynamicEntity.enemy.Mosquitoes;
import vg.model.entity.dynamicEntity.player.BasePlayer;
import vg.model.entity.dynamicEntity.player.Player;
import vg.model.entity.staticEntity.FixedMysteryBox;
import vg.model.entity.staticEntity.StaticEntity;
import vg.model.timedObject.Bonus;
import vg.model.timedObject.BonusImpl;
import vg.model.timedObject.BonusType;
import vg.utils.MassTier;
import vg.utils.Shape;
import vg.utils.V2D;

import java.io.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class levelGenerator {

    /**
     * The borders are the same for every level at the beginning.
     */
    private Set<V2D> defaultBorders = IntStream.rangeClosed(0, 200).boxed().
            flatMap(e -> Stream.of(new V2D(e,0),new V2D(0,e), new V2D(200,e), new V2D(e,150))).filter(e->e.getY()<=150).
            collect(Collectors.toSet());
    /**
     * Lv1.
     */
    private Boss bossLv1 = new BossImpl(new V2D(110, 40), new V2D(3, 3), 5, Shape.SQUARE, MassTier.HIGH);

    private Set<StaticEntity> ssLv1 = new HashSet<>(Stream.of(5, 100, 195)
            .flatMap(e -> Stream.of(new V2D(e,148)))
            .flatMap(e -> Stream.of(new FixedMysteryBox(e,2, BonusImpl.createBonus(BonusType.EXTRA_SCORE,10))))
            .collect(Collectors.toSet()));

    private Set<DynamicEntity> dsLv1 = generatesEnemies(ssLv1, bossLv1, 5 );

    private Map<V2D> lv1 = new MapImpl(BasePlayer.newPlayer(new V2D(0, 0)),
            bossLv1,
            new HashSet<Bonus>(),
            ssLv1,
            dsLv1,
            defaultBorders);


    /**
     * Generates n {@link Mosquitoes} that are in borders and not colliding
     * with other entities on the map.
     * @param ss the set of {@link StaticEntity}
     * @param boss the boss of the map
     * @param nEnemies number of enemies to generate
     * @return a {@link Set<DynamicEntity>}
     */
    private Set<DynamicEntity> generatesEnemies(Set<StaticEntity> ss, Boss boss, int nEnemies) {
        var r = new Random();
        Set<DynamicEntity> rt = new HashSet<>();
        while (rt.size() < nEnemies) {
            var t = new Mosquitoes(new V2D(r.nextInt(200), r.nextInt(150)), new V2D(r.nextInt(7), r.nextInt(7)), 3, Shape.CIRCLE, MassTier.LOW);
            if (rt.stream().noneMatch(e -> e.isInShape(t)) && !boss.isInShape(t) && defaultBorders.stream().noneMatch(t::isInShape) && !t.isInShape(BasePlayer.newPlayer(new V2D(0, 0)))) {
                rt.add(t);
            }
        }
        return rt;
    }

    void serializeDefaults() throws IOException {
        FileOutputStream fileOutLv1 = new FileOutputStream("1");
        ObjectOutputStream lv1 = new ObjectOutputStream(fileOutLv1);
        lv1.writeObject(this.lv1);
        lv1.flush();
        lv1.close();
        //do this for every level
    }

    void serializeState(final Map<V2D> map) throws IOException {
        FileOutputStream out = new FileOutputStream("save");
        ObjectOutputStream oOut = new ObjectOutputStream(out);
        oOut.writeObject(map);
        oOut.flush();
        oOut.close();
    }

    Map<V2D> deserializeLevel(final String lv) throws IOException, ClassNotFoundException {
        FileInputStream in = new FileInputStream(lv);
        ObjectInputStream oIn = new ObjectInputStream(in);
        var map = (Map<V2D>)oIn.readObject();
        oIn.close();
        return map;
    }
    Map<V2D> deserializeSaved() throws IOException, ClassNotFoundException {
        FileInputStream in = new FileInputStream("save");
        ObjectInputStream oIn = new ObjectInputStream(in);
        var map = (Map<V2D>)oIn.readObject();
        oIn.close();
        return map;
    }
}
