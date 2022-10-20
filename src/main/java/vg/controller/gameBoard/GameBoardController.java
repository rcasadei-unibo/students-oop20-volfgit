package vg.controller.gameBoard;

import javafx.collections.ObservableList;
import javafx.geometry.Dimension2D;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import vg.model.entity.dynamicEntity.DynamicEntity;
import vg.utils.V2D;

import java.util.List;
import java.util.Set;

public interface GameBoardController {

    Dimension2D getGameAreaDimension();

    Pane getGameArea();

    void addInGameArea(Node node);

    ObservableList<Node> getGameAreaNode();

    void updatePlayer(V2D position, boolean shieldActive, List<V2D> tail);

    void initMapView();

    void updateMosquitoesPosition(Set<DynamicEntity> mosquitoes);

    void updateBossPosition(V2D bossPos);
}
