package vg.controller.gameBoard;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Dimension2D;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polyline;
import vg.model.entity.dynamicEntity.DynamicEntity;
import vg.utils.V2D;
import vg.view.ViewController;
import vg.view.entity.EntityBlock;
import vg.view.entity.StaticFactoryEntityBlock;
import vg.view.player.PlayerViewController;
import vg.view.player.PlayerViewControllerImpl;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameBoardControllerImpl extends ViewController implements GameBoardController {

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
    @FXML
    public Button life1;
    @FXML
    public Button life2;
    @FXML
    public Button life3;
    @FXML
    public Button life4;
    @FXML
    public Button life5;
    @FXML
    public Button life6;

    private PlayerViewController player;
    private Polyline tailPolyline;
    private Polyline borders;
    private EntityBlock boss;
    private Set<Node> mosquitoesNode;

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

    @Override
    public void addInGameArea(Node node) {
        this.gameArea.getChildren().add(node);
    }

    @Override
    public ObservableList<Node> getGameAreaNode() {
        return this.gameArea.getChildren();
    }

    @Override
    public void initMapView() {
        //TODO: rimappare cooridnate entità dominio in coordinate mappate sulle dimensioni del gameArea
        //o metodo statico qui oppure metodo setposition di entityblock che rimappa oppure soluzione di ale
        //Set player in view map
        this.player = new PlayerViewControllerImpl();
        this.player.setInParentNode(this.getGameAreaNode());

        //this.boss = StaticFactoryEntityBlock.createBoss();


        this.mosquitoesNode = new HashSet<>();
        this.tailPolyline = new Polyline();
    }

    @Override
    public void updateMosquitoesPosition(final Set<DynamicEntity> mosquitoes) {
        this.gameArea.getChildren().removeAll(mosquitoesNode);

        mosquitoes.forEach(mosq -> {
            EntityBlock entityBlock =  StaticFactoryEntityBlock.createMosquitoes(mosq.getPosition(), new Dimension2D( 30, 30));
            entityBlock.setInParentNode(this.gameArea.getChildren());
        });
    }

    @Override
    public void updateBossPosition(final V2D bossPos) {
       // this.boss.setPosition(bossPos);
    }

    @Override
    public void updateBorders(List<V2D> vertexBorder) {
/*
        this.borders = new Polyline();
        this.borders.getPoints().setAll(convertToListOfDouble(vertexBorder.stream().sorted((v1,v2)-> (int)(v1.getX()- v2.getX())).collect(Collectors.toList())));
        this.borders.setStrokeWidth(5);
        this.borders.setStroke(Paint.valueOf("#945200"));
        this.addInGameArea(this.borders);
*/
    }

    @Override
    public void updateLifeCounter(int life) {
        Stream.of(life6, life5, life4, life3, life2, life1)
                .limit(Math.min(life, 6))
                .forEach(btn -> btn.setDisable(false));
    }

    @Override
    public void updatePercentage(double percentage) {
        this.percentage.setText(String.valueOf((int)percentage*100));
    }

    @Override
    public void setRound(int round) {
        this.numberRound.setText(String.valueOf(round));
    }

    @Override
    public void updateScoreText(int score) {
        this.scoreText.setText(String.valueOf(score));
    }

    @Override
    public void setHighScoreText(int highScore) {
        this.highScoreText.setText(String.valueOf(highScore));
    }

    @Override
    public void updateShieldTime(double time) {
        this.shield.setText(String.valueOf((int)time/100));
    }

    @Override
    public void updatePlayer(V2D position, boolean shieldActive, final List<V2D> tailVec) {
        if (shieldActive) {
            this.player.showShield();
        } else {
            this.player.hideShield();
        }
        this.player.setPosition(position);

        this.gameArea.getChildren().remove(this.tailPolyline);

        tailVec.add(position);
        this.tailPolyline = new Polyline();
        this.tailPolyline.getPoints().setAll(convertToListOfDouble(tailVec));
        this.tailPolyline.setStrokeWidth(4);
        this.tailPolyline.setStroke(Paint.valueOf("#945200"));
        this.addInGameArea(this.tailPolyline);
    }

    /**
     * COnvert List of vectors V2D to a list with alternate x and y.
     * @param vectors List of vertex vector of player tail
     * @return List of double
     */
    private List<Double> convertToListOfDouble(final List<V2D> vectors) {
        return vectors.stream()
                .map(vec -> List.of(vec.getX(), vec.getY()))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
