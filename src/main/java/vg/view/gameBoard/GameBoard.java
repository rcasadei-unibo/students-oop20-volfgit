package vg.view.gameBoard;

import javafx.application.Application;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import vg.controller.GameController;

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

        final FXMLLoader fxmlLoader = new FXMLLoader(ClassLoader.getSystemResource("layout/GameBoard.fxml"));
        final Parent root = fxmlLoader.load();
        fxmlLoader.getController());

        viewManager.addScene(scene);
        viewManager.getStage().show();

        Rectangle rect = new Rectangle(100, 100, 100, 100);

        scene.getRoot().lookup("#gameArea").setClip(rect);
        scene.getRoot().lookup("#gameArea").setOnMouseClicked(e -> scen2());

        scene.getRoot().lookup("#gameArea").setStyle("-fx-background-color: #000000;");
        scene.getRoot().lookup("#gameAreaDue").setStyle("-fx-background-color: #2a77ff;");

        controller.stampa();

        stage.show();
    }

    public void back() {
        this.viewManager.popScene();
    }

    public void scen2() {
        System.out.println("Cliccato per andare in scena 2");
        Scene scene2 = new Scene(LoadFxmlUtils.loadFxml("layout/leaderBoards.fxml"));

       scene2.getRoot().lookup("#backBtn").setOnMouseClicked(e -> {
            back();
        });

        if (this.viewManager == null) {
            System.out.println("è null");
        } else {
            this.viewManager.addScene(scene2);
        }
    }

}

