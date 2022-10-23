package vg.controller.entity.mystery_box;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import vg.model.Stage;
import vg.model.mystery_box.data_round.DataRound;
import vg.utils.V2D;

public interface MysteryBoxController {

    V2D getPosition();
    int getRadius();
    void setPosition(V2D position);
    void setBlinking(boolean blinking);
    void setInParentNode(ObservableList<Node> gameAreaNode);

    void setDataRound(DataRound dataRound);

    void updateBlinking(long elapsedTime);

    void setImage(String mysteryBoss);

    void checkOnBorder(Stage<V2D> stage);
}
