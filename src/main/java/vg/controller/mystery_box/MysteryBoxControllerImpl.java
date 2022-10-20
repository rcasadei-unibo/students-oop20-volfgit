package vg.controller.mystery_box;

import com.sun.javafx.geom.Vec2d;
import javafx.scene.Node;
import vg.model.mysteryBox.AbilityInTheBox;
import vg.view.entity.EntityBlock;

public class MysteryBoxControllerImpl<T extends AbilityInTheBox> implements MysteryBoxController<T> {

    private final AbilityInTheBox model;
    private final EntityBlock view;

    public MysteryBoxControllerImpl(AbilityInTheBox model, EntityBlock view) {
        this.model = model;
        this.view = view;
        this.view.setImage(this.model.getPathImage());
//        this.view.setDimension(this.model.getDimension());
    }

    public T getModel() {
        return (T)this.model;
    }


    @Override
    public Node getNode() {
        return this.view.getNode();
    }

    @Override
    public Vec2d getPosition() {
        return this.view.getPosition();
    }

    @Override
    public void setPosition(Vec2d position) {
        this.view.setPosition(position);
    }
}
