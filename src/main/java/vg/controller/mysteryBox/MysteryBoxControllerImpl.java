package vg.controller.mysteryBox;

import com.sun.javafx.geom.Vec2d;
import javafx.scene.Node;
import vg.model.mysteryBox.AbilityInTheBox;
import vg.view.mysteryBox.Block;

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

    @Override
    public Vec2d GetPosition() {
        return this.view.getPosition();
    }
}
