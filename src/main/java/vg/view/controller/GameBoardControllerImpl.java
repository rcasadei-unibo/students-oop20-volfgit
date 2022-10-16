package vg.view.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Dimension2D;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class GameBoardControllerImpl implements GameBoardController {


    @FXML
    private BorderPane borderPane;

    @FXML
    public Label numberRound;
    @FXML
    public Label scoreText;
    @FXML
    public Label highScoreText;

    @FXML
    public Label shield;
    @FXML
    public Label percentage;

    public Button life1;
    public Button life2;
    public Button life3;
    public Button life4;
    public Button life5;
    public Button life6;

    @FXML
    private Pane gameArea;


    @Override
    public Dimension2D getGameAreaDimension() {
        return new Dimension2D(gameArea.getWidth(), gameArea.getHeight());
    }

    @Override
    public Pane getGameArea() {
        return this.gameArea;
    }


}
