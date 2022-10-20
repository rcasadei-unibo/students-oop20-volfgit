package vg.view.entity;

import javafx.geometry.Dimension2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
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
        Image dots = new Image(pathImage);
        this.setFill(new ImagePattern(dots));
    }

    @Override
    public Node getNode() {
        return this;
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

    public void setImageOverlay(String pathImage){
        Image dots = new Image(pathImage);
        this.setFill(new ImagePattern(dots));
    }

    public void showImageOverlay(){
        this.rectangleOverlay.setOpacity(1);
    }

    public void hideImageOverlay(){
        this.rectangleOverlay.setOpacity(0);
    }


}
