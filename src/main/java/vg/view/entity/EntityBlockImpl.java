package vg.view.entity;

import javafx.collections.ObservableList;
import javafx.geometry.Dimension2D;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import vg.utils.ImageFXUtils;
import vg.utils.V2D;

import java.util.List;

public class EntityBlockImpl extends Rectangle implements EntityBlock {
    private List<String> animationPathList;
    private int indexImage;
    private final Rectangle rectangleOverlay;

    public EntityBlockImpl(final V2D position, final Dimension2D dimension, final List<String> animationPathList)  {
        super(dimension.getWidth(), dimension.getHeight());
        this.animationPathList = animationPathList;
        this.rectangleOverlay = new Rectangle(dimension.getWidth(), dimension.getHeight());
        V2D centerPos = new V2D(position.getX() - dimension.getWidth() / 2, position.getY() - dimension.getHeight() / 2);
        this.setPosition(centerPos);
        this.hideImageOverlay();
        this.indexImage = 0;
        this.setImage(this.animationPathList.get(this.indexImage));
    }
    @Override
    public V2D getPosition() {
        return new V2D(this.getX(), this.getY());
    }

    @Override
    public void setPosition(final V2D position) {
        V2D centerPos = new V2D(position.getX() - this.getWidth() / 2, position.getY() - this.getHeight() / 2);

        this.setX(centerPos.getX());
        this.setY(centerPos.getY());
        this.rectangleOverlay.setX(centerPos.getX());
        this.rectangleOverlay.setY(centerPos.getY());
    }

    private void setImage(final String pathImage) {
        this.setFill(ImageFXUtils.createImagePatternFrom(pathImage));
    }

    @Override
    public void setAnimation(final List<String> animationPathList) {
        this.animationPathList = animationPathList;
    }

    @Override
    public void setInParentNode(final ObservableList<Node> gameAreaNode) {
        gameAreaNode.add(this);
        gameAreaNode.add(this.rectangleOverlay);
    }

    @Override
    public void setImageOverlay(final String pathImage) {
        this.rectangleOverlay.setFill(ImageFXUtils.createImagePatternFrom(pathImage));
    }


    @Override
    public void showImageOverlay() {
        this.rectangleOverlay.setVisible(true);
    }
    @Override
    public void hideImageOverlay() {
        this.rectangleOverlay.setVisible(false);
    }


    @Override
    public void setShow(final boolean show) {
        this.setVisible(show);

        boolean isVisible = this.rectangleOverlay.isVisible() && show;
        this.rectangleOverlay.setVisible(isVisible);
    }

    @Override
    public void updateAnimation() {
        if (this.animationPathList.size() == 0) {
            return;
        }
        this.setImage(this.animationPathList.get(this.indexImage));
        this.indexImage = (this.indexImage + 1) % this.animationPathList.size();
    }
    public Rectangle getRectangleOverlay(){
        return this.rectangleOverlay;
    }
}
