package vg.view.entity;

import javafx.geometry.Dimension2D;
import vg.utils.V2D;
import vg.utils.path.PathImageEnemy;
import vg.utils.path.PathImageMysteryBox;

public class StaticFactoryEntityBlock {

    public static EntityBlock createMysteryBox(final V2D position, final Dimension2D dimension) {
        EntityBlock block = new EntityBlockImpl(position, dimension);
        block.setImage(PathImageMysteryBox.MYSTERY_BOX);
        return block;
    }
    public static EntityBlock createMosquitoes(final V2D position, final Dimension2D dimension) {
        EntityBlock block = new EntityBlockImpl(position, dimension);
        block.setImage(PathImageEnemy.MOSQUITOES);
        return block;
    }
    public static EntityBlock createBoss(final V2D position, final Dimension2D dimension) {
        EntityBlock block = new EntityBlockImpl(position, dimension);
        block.setImage(PathImageEnemy.BOSS);
        return block;
    }
}
