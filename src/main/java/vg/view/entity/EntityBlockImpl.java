package vg.view.entity;

import javafx.collections.ObservableList;
import javafx.geometry.Dimension2D;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import vg.utils.ImageFXUtils;
import vg.utils.V2D;

public class EntityBlockImpl extends Rectangle implements EntityBlock {
    private final Rectangle rectangleOverlay;

    public EntityBlockImpl(V2D position, Dimension2D dimension)  {
        super(dimension.getWidth(), dimension.getHeight());
        this.rectangleOverlay = new Rectangle(dimension.getWidth(), dimension.getHeight());

        V2D centerPos = new V2D(position.getX() - dimension.getWidth() / 2, position.getY() - dimension.getHeight() / 2);
        this.setPosition(centerPos);
        this.hideImageOverlay();
//        this.showCollider();
    }

    @Override
    public V2D getPosition() {
        return new V2D(this.getX(), this.getY());
    }

    @Override
    public void setPosition(V2D position) {
        V2D centerPos = new V2D(position.getX() - this.getWidth() / 2, position.getY() - this.getHeight() / 2);

        this.setX(centerPos.getX());
        this.setY(centerPos.getY());
        this.rectangleOverlay.setX(centerPos.getX());
        this.rectangleOverlay.setY(centerPos.getY());
    }

    @Override
    public void setImage(String pathImage) {
        this.setFill(ImageFXUtils.createImagePatternFrom(pathImage));
    }

    @Override
    public void setInParentNode(ObservableList<Node> gameAreaNode) {
        gameAreaNode.add(this);
        gameAreaNode.add(this.rectangleOverlay);
    }

    @Override
    public void setImageOverlay(String pathImage){
        this.rectangleOverlay.setFill(ImageFXUtils.createImagePatternFrom(pathImage));
    }


    @Override
    public void showImageOverlay(){
        this.rectangleOverlay.setVisible(true);
    }

    @Override
    public void hideImageOverlay(){
        this.rectangleOverlay.setVisible(false);
    }

    @Override
    public void showCollider() {
        this.setStroke(Color.RED);
        this.setStrokeWidth(1);
    }

    @Override
    public void hideCollider() {
//        this.setStroke(Color.);
        this.setStrokeWidth(0);
    }

    @Override
    public void setShow(boolean show) {
        this.setVisible(show);

        boolean isVisible = this.rectangleOverlay.isVisible() && show;
        this.rectangleOverlay.setVisible(isVisible);
    }


}
