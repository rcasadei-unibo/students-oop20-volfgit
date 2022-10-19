package vg.view.entity;

import javafx.geometry.Dimension2D;

public class StaticFactoryEntityBlock {

    public static EntityBlockImpl create(Dimension2D dimension) {
        return new EntityBlockImpl(dimension.getWidth(), dimension.getHeight());
    }

}
