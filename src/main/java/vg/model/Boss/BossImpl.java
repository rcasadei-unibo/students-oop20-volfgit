package vg.model.Boss;

import javafx.geometry.Dimension2D;
import vg.model.entity.dynamicEntity.enemy.Boss;
import vg.utils.MassTier;
import vg.utils.Shape;
import vg.utils.V2D;

public class BossImpl extends Boss implements BossModel {
    private static final Dimension2D DIMENSION_BOX = new Dimension2D(80, 80);
    private static final V2D INIT_POSITION = new V2D(400, 400);

    private final Dimension2D dimension;
    private boolean isDead;


    public BossImpl(V2D speed) {
        super(INIT_POSITION, speed, (int) (DIMENSION_BOX.getWidth() / 2), Shape.SQUARE, MassTier.HIGH);
        this.dimension = DIMENSION_BOX;
    }

    @Override
    public Dimension2D getDimension() {
        return this.dimension;
    }
}
