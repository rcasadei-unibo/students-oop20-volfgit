package vg.model;

import vg.model.entity.dynamicEntity.player.Player;
import vg.model.entity.staticEntity.StaticEntity;
import vg.model.levels.LEVEL;
import vg.model.levels.levelGenerator;
import vg.utils.V2D;

import java.io.IOException;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * {@inheritDoc}.
 */
public class MapFactoryImpl implements MapFactory<V2D> {

    Player player;

    MapFactoryImpl(final Player player) {
        this.player = player;
    }

    @Override
    public Map<V2D> fromEnum(final LEVEL lv) {
        //TODO: fix
       /* return new MapImpl(this.player, lv.getBoss(), new HashSet<Bonus>(),new HashSet<StaticEntity>(), lv.getEnemies(), IntStream.rangeClosed(0,200).boxed().
                flatMap(e -> Stream.of(new V2D(e, 0), new V2D(0, e), new V2D(200, e), new V2D(e, 150))).filter(e -> e.getY() <= 150).
                collect(Collectors.toSet()));

        */
        //TODO: remove it
        return null;
    }

    @Override
    public Map<V2D> fromSerialized(final int lv) throws IOException, ClassNotFoundException {
        var lg = new levelGenerator();
        Map<V2D> map;
        try {
            map = lg.deserializeLevel(Integer.toString(lv));
        } catch (IOException | ClassNotFoundException e) {
            lg.serializeDefaults();
            map = lg.deserializeLevel(Integer.toString(lv));
        }
        return map;
    }
    @Override
    public Map<V2D> fromSave() {
        var lg = new levelGenerator();
        Map<V2D> map;
        try {
            map = lg.deserializeSaved();
        } catch (IOException | ClassNotFoundException e) {
          throw new RuntimeException("Failed to load save file.");
        }
        return map;
    }
    @Override
    public Map<V2D> fromData() {
        return null;
    }
}
