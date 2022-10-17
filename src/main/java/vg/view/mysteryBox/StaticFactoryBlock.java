package vg.view.mysteryBox;

import com.sun.javafx.geom.Vec2d;
import javafx.geometry.Dimension2D;

public class StaticFactoryBlock {

    public static BlockImpl createBlock(Dimension2D dimension) {
        return new BlockImpl(dimension.getWidth(), dimension.getHeight());
    }

}
