package vg.view.entity;

import javafx.collections.ObservableList;
import javafx.geometry.Dimension2D;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import vg.utils.ImageFXUtils;
import vg.utils.V2D;

public class EntityBlockImpl extends Rectangle implements EntityBlock {
    private final Rectangle rectangleOverlay;

    public EntityBlockImpl(V2D position, Dimension2D dimension)  {
        super(dimension.getWidth(), dimension.getHeight());
        this.rectangleOverlay = new Rectangle(dimension.getWidth(), dimension.getHeight());
        this.setPosition(position);
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
    public V2D getPosition() {
        return new V2D(this.getX(), this.getY());
    }

    @Override
    public void setPosition(V2D position) {
        this.setX(position.getX());
        this.setY(position.getY());
        this.rectangleOverlay.setX(position.getX());
        this.rectangleOverlay.setY(position.getY());
    }

    @Override
    public void setImageOverlay(String pathImage){
        this.rectangleOverlay.setFill(ImageFXUtils.createImagePatternFrom(pathImage));
    }

    @Override
    public void showImageOverlay(){
        this.rectangleOverlay.setOpacity(1);
    }

    @Override
    public void hideImageOverlay(){
        this.rectangleOverlay.setOpacity(0);
    }


}
