package vg.view.block;

import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import vg.utils.PathImage;

public class BlockImpl extends Rectangle implements Block {

    public BlockImpl(double x, double y, double width, double height) {
        super(x, y, width, height);
        this.setImage(PathImage.MYSTERY_BOX);
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
}
