package vg.view.gameBoard;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import vg.controller.GameController;
import vg.controller.KeyEventImpl;
import vg.controller.StateController;
import vg.model.Boss.BossImpl;
import vg.model.MapImpl;
import vg.model.StageImpl;
import vg.model.entity.dynamicEntity.player.BasePlayer;
import vg.utils.LoadFxmlUtils;
import vg.utils.MassTier;
import vg.utils.Shape;
import vg.utils.V2D;

import vg.view.ViewManager;
import vg.view.ViewManagerImpl;

import java.util.Set;
import java.util.concurrent.ExecutionException;

public class GameBoard extends Application {

    GameBoardController controller = new GameBoardController();
    ViewManager viewManager;

    @Override
    public void start(Stage stage) throws Exception {
        this.viewManager = new ViewManagerImpl(stage);
        Scene scene = new Scene(LoadFxmlUtils.loadFxml("layout/GameBoard.fxml"));
        GameController<V2D> gameController = getController(scene);

        viewManager.addScene(scene, gameController);



        Rectangle rect = new Rectangle(100, 100, 100, 100);
/*
        stage.setScene(scene);
        stage.sizeToScene();
*/
        scene.getRoot().lookup("#gameArea").setClip(rect);
        scene.getRoot().lookup("#gameArea").setStyle("-fx-background-color: #000000;");
        scene.getRoot().lookup("#gameAreaDue").setStyle("-fx-background-color: #2a77ff;");

        controller.stampa();

        stage.show();
    }

    public void back() throws ExecutionException {
        this.viewManager.popScene();
    }

    public void scen2() {
        Scene scene2 = new Scene(LoadFxmlUtils.loadFxml("layout/GameBoard.fxml"));
        this.viewManager.addScene(scene2, getController(scene2));
    }

    private GameController getController(Scene scene) {
        GameController<V2D> gameController = new GameController<>();
        gameController.setup(scene,
                KeyEventImpl.defaultKeyEventImpl(),
                new StageImpl(0,
                        new MapImpl(
                                BasePlayer.newPlayer(new V2D(0, 0)),
                                new BossImpl(new V2D(0, 0), new V2D(0, 0), 0, Shape.CIRCLE, MassTier.LOW),
                                Set.of(),
                                Set.of(),
                                Set.of(),
                                Set.of()))
        );
        return gameController;
    }
}

