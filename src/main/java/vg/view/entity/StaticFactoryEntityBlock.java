package vg.view.entity;

import javafx.geometry.Dimension2D;
import vg.utils.V2D;
import vg.utils.path.PathImageEnemy;
import vg.utils.path.PathImageMysteryBox;

public class StaticFactoryEntityBlock {

    public static EntityBlock createMysteryBox(V2D position, Dimension2D dimension) {
        EntityBlock block = new EntityBlockImpl(position, dimension);
        block.setImage(PathImageMysteryBox.MYSTERY_BOX);
        return block;
    }

    public static EntityBlock createMosquitoes(V2D position, Dimension2D dimension) {
        EntityBlock block = new EntityBlockImpl(position, dimension);
 //       block.setImage(PathImageMysteryBox.MYSTERY_BOX);
        return new EntityBlockImpl(position, dimension);
    }

    public static EntityBlock createBoss(V2D position, Dimension2D dimension) {
        EntityBlock block = new EntityBlockImpl(position, dimension);
        block.setImage(PathImageEnemy.BOSS);
        block.hideImageOverlay();
        return new EntityBlockImpl(position, dimension);
    }
}
