package vg.controller.entity.mystery_box;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import vg.model.entity.ShapedEntity;
import vg.model.entity.dynamicEntity.player.Player;
import vg.model.mystery_box.AbilityInTheBox;
import vg.model.mystery_box.dataRound.DataRound;
import vg.utils.V2D;
import vg.view.entity.EntityBlock;

public class MysteryBoxControllerImpl<T extends AbilityInTheBox> implements MysteryBoxController<T> {

    private final AbilityInTheBox model;
    private final EntityBlock view;

    public MysteryBoxControllerImpl(final AbilityInTheBox model, final EntityBlock view) {
        this.model = model;
        this.view = view;
    }

    public T getModel() {
        return (T) this.model;
    }

    @Override
    public V2D getPosition() {
        return this.view.getPosition();
    }

    @Override
    public void setPosition(final V2D position) {
        this.model.setPosition(position);
        this.view.setPosition(this.model.getPosition());
    }

    @Override
    public void setBlinking(final boolean blinking) {
        this.model.setBlinking(blinking);
    }

    @Override
    public void setInParentNode(final ObservableList<Node> gameAreaNode) {
        this.view.setInParentNode(gameAreaNode);
    }

    @Override
    public void setDataRound(final DataRound dataRound) {
        this.setPosition(dataRound.getPosition());
        this.setBlinking(dataRound.isBlinking());
    }

    @Override
    public void updateBlinking(final long elapsedTime) {
        this.model.updateBlinking(elapsedTime);
        this.view.setShow(this.model.isShow());
    }

    @Override
    public void setImage(final String mysteryBoss) {
        this.view.setImage(mysteryBoss);
    }

    @Override
    public void checkCollision(final Player player) {
//        if (this.model.isBlinking() && ShapedEntity.isCollision(this.model, player)) {
//            this.model.setBlinking(false);
//            this.model.setShow(false);
//            this.model.applyEffect(player);
//        }

        if(!this.model.isShow()) {
            return;
        }
        boolean collision = player.isInShape((ShapedEntity) this.model);
        if(collision) {
            System.out.println("Collision: ");
        }

    }


}
