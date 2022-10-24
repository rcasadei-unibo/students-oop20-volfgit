package vg.controller.entity.boss;

import vg.controller.gameBoard.GameBoardController;
import vg.model.entity.ShapedEntity;
import vg.model.entity.boss.BossModel;
import vg.utils.MassTier;
import vg.utils.Shape;
import vg.utils.V2D;
import vg.view.entity.EntityBlock;

public class BossControllerImpl implements BossController{
    private final BossModel model;
    private final EntityBlock view;

    public BossControllerImpl(final BossModel model, final EntityBlock view) {
        this.model = model;
        this.view = view;
    }


    @Override
    public void setInParentNode(final GameBoardController gameController) {
        this.view.setInParentNode(gameController.getGameAreaNode());
    }

    @Override
    public void move() {
        this.model.move();
        this.view.setPosition(this.model.getPosition());
    }

    @Override
    public void saveMySpeed() {
        this.model.saveMySpeed();
    }

    @Override
    public void setSpeed(final V2D v2D) {
        this.model.setSpeed(v2D);
    }

    @Override
    public void restoreMySpeed() {
        this.model.restoreMySpeed();
    }

    @Override
    public void setPosition(final V2D v2dPosition) {
        this.model.setPosition(v2dPosition);
        this.view.setPosition(this.model.getPosition());
    }

    @Override
    public V2D getPosition() {
        return this.model.getPosition();
    }

    @Override
    public boolean isInShape(final V2D position) {
        return this.model.isInShape(position);
    }

    @Override
    public boolean isInShape(final ShapedEntity entity) {
        return this.model.isInShape(entity);
    }

    @Override
    public V2D getSpeed() {
        return this.model.getSpeed();
    }

    @Override
    public Shape getShape() {
        return this.model.getShape();
    }

    @Override
    public MassTier getMassTier() {
        return this.model.getMassTier();
    }

    @Override
    public void setMassTier(final MassTier toSet) {
        this.model.setMassTier(toSet);
    }

    @Override
    public void updateAnimation() {
        this.view.updateAnimation();
    }
}
