package vg.controller.gameBoard;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Dimension2D;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import vg.model.entity.dynamicEntity.DynamicEntity;
import vg.utils.V2D;
import vg.view.ViewController;
import vg.view.entity.EntityBlock;
import vg.view.entity.StaticFactoryEntityBlock;
import vg.view.player.PlayerViewController;
import vg.view.player.PlayerViewControllerImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    public Button life1;
    public Button life2;
    public Button life3;
    public Button life4;
    public Button life5;
    public Button life6;

    private PlayerViewController player;
    private List<Node> tail;
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

//        this.boss = StaticFactoryEntityBlock.createBoss(initBossPos);
//        this.addInGameArea(this.boss.getNode());

        this.mosquitoesNode = new HashSet<>();
        this.tail = new ArrayList<>();
    }

    @Override
    public void updateMosquitoesPosition(final Set<DynamicEntity> mosquitoes) {
        this.gameArea.getChildren().removeAll(mosquitoesNode);

//        mosquitoes.forEach(mosq -> {
//            EntityBlock entityBlock =  StaticFactoryEntityBlock.createMosquito(mosq.getPosition());
//            this.mosquitoesNode.add(entityBlock.getNode());
//            this.addInGameArea(entityBlock.getNode());
//        });
    }

    @Override
    public void updateBossPosition(final V2D bossPos) {
       // this.boss.setPosition(bossPos);
    }

    @Override
    public void updatePlayer(V2D position, boolean shieldActive, final List<V2D> tail) {
        if (shieldActive) {
            this.player.showShield();
        } else {
            this.player.hideShield();
        }

        new Circle();

        this.player.setPosition(position);

//        System.out.println(tail);
        Platform.runLater(() -> {
            tail.stream()
                    .map(t -> new Circle( t.getX(), t.getY(),4))
                    .forEach(e -> {
                        this.gameArea.getChildren().add(e);
                    });
        });

    }
}
