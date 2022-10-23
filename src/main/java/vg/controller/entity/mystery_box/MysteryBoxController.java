package vg.controller.entity.mystery_box;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import vg.controller.gameBoard.GameBoardController;
import vg.model.Stage;
import vg.model.mystery_box.AbilityDurable;
import vg.model.mystery_box.ETypeAbility;
import vg.model.mystery_box.data_round.DataRound;
import vg.utils.V2D;

public interface MysteryBoxController {

    AbilityDurable getDurability();

    V2D getPosition();
    int getRadius();
    void setPosition(V2D position);
    void setBlinking(boolean blinking);
    void setInParentNode(ObservableList<Node> gameAreaNode);

    void setDataRound(DataRound dataRound);

    void updateBlinking(long elapsedTime);

    void setImage(String mysteryBoss);

    boolean isType(ETypeAbility type);

    void checkOnBorder(Stage<V2D> stage, GameBoardController gameController);


    boolean isActivated();

    void hide();
}
