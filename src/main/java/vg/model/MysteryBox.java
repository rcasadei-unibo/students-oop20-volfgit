package vg.model;

import vg.utils.V2D;

public abstract class MysteryBox<T> extends StaticEntity {

    final private T bonus;

    MysteryBox(V2D position) {
        super(position);
        //TODO assegnare bonus correttamente
        this.bonus = null;
    }

    public T getBonus(){
        return this.bonus;
    }
}
