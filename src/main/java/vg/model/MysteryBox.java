package vg.model;

import vg.utils.Position;

public abstract class MysteryBox<T> extends StaticEntity {

    final private T bonus;

    MysteryBox(Position position) {
        super(position);
        //TODO assegnare bonus correttamente
        this.bonus = null;
    }

    public T getBonus(){
        return this.bonus;
    }
}
