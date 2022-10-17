package vg.controller.mysteryBox;

import javafx.scene.Node;
import vg.model.mysteryBox.ability.AbilityInTheBox;
import vg.view.block.Block;

public class MysteryBoxControllerImpl<T extends AbilityInTheBox> implements MysteryBoxController<T> {

    private final AbilityInTheBox model;
    private final Block view;

    public MysteryBoxControllerImpl(AbilityInTheBox model, Block view) {
        this.model = model;
        this.view = view;
    }

    public T getModel() {
        return (T)this.model;
    }


    @Override
    public Node getNode() {
        return this.view.getNode();
    }
}
