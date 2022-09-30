package vg.model.entity.staticEntity;

import vg.model.entity.ShapedEntity;
import vg.utils.V2D;

public abstract class StaticEntity extends ShapedEntity {

    StaticEntity(V2D position) {
        super(position);
    }
}
