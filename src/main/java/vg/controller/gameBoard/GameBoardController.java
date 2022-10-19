package vg.controller.gameBoard;

import javafx.geometry.Dimension2D;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import vg.model.entity.dynamicEntity.DynamicEntity;
import vg.utils.V2D;

import java.util.Set;

public interface GameBoardController {

    Dimension2D getGameAreaDimension();

    Pane getGameArea();

    void addInGameArea(Node node);

    void updatePlayerPosition(V2D position);

    void initMapView(V2D initPlayerPos, V2D initBossPos, Set<DynamicEntity> mosquitoes);

    void updateMosquitoesPosition(Set<DynamicEntity> mosquitoes);

    void updateBossPosition(V2D bossPos);
}
