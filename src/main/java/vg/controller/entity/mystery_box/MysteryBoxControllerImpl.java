package vg.controller.entity.mystery_box;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import vg.model.entity.ShapedEntity;
import vg.model.entity.dynamicEntity.player.Player;
import vg.model.mysteryBox.AbilityInTheBox;
import vg.model.mysteryBox.dataRound.DataRound;
import vg.utils.V2D;
import vg.view.entity.EntityBlock;

public class MysteryBoxControllerImpl<T extends AbilityInTheBox> implements MysteryBoxController<T> {

    private final AbilityInTheBox model;
    private final EntityBlock view;

    public MysteryBoxControllerImpl(AbilityInTheBox model, EntityBlock view) {
        this.model = model;
        this.view = view;
    }

    public T getModel() {
        return (T)this.model;
    }

    @Override
    public V2D getPosition() {
        return this.view.getPosition();
    }

    @Override
    public void setPosition(V2D position) {
        this.model.setPosition(position);
        this.view.setPosition(this.model.getPosition());
    }

    @Override
    public void setBlinking(boolean blinking) {
        this.model.setBlinking(blinking);
    }

    @Override
    public void setInParentNode(ObservableList<Node> gameAreaNode) {
        this.view.setInParentNode(gameAreaNode);
    }

    @Override
    public void setDataRound(DataRound dataRound) {
        this.setPosition(dataRound.getPosition());
        this.setBlinking(dataRound.isBlinking());
    }

    @Override
    public void updateBlinking(long elapsedTime) {
        this.model.updateBlinking(elapsedTime);
        this.view.setShow(this.model.isShow());
    }

    @Override
    public void setImage(String mysteryBoss) {
        this.view.setImage(mysteryBoss);
    }

    @Override
    public void checkCollision(Player player) {
        if(!this.model.isShow()) return;
        boolean collision = player.isInShape((ShapedEntity) this.model);

        if(collision) System.out.println("Collision: ");

    }


}
