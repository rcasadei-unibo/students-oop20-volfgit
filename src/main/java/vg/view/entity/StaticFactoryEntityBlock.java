package vg.view.entity;

import javafx.geometry.Dimension2D;
import vg.utils.V2D;
import vg.utils.path.PathImageEnemy;
import vg.utils.path.PathImageMysteryBox;

import java.util.List;

public final class StaticFactoryEntityBlock {
    private StaticFactoryEntityBlock() {
    }

    public static EntityBlock createMysteryBox(final V2D position, final Dimension2D dimension) {
        return new EntityBlockImpl(position, dimension, List.of(PathImageMysteryBox.MYSTERY_BOX));
    }
    public static EntityBlock createMosquitoes(final V2D position, final Dimension2D dimension) {
        return new EntityBlockImpl(position, dimension, PathImageEnemy.MOSQUITOES);
    }
    public static EntityBlock createBoss(final V2D position, final Dimension2D dimension) {
        return new EntityBlockImpl(position, dimension, PathImageEnemy.BOSS);
    }
}
