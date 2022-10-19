package vg.controller.gameBoard;

import javafx.fxml.FXML;
import javafx.geometry.Dimension2D;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import vg.model.entity.dynamicEntity.DynamicEntity;
import vg.view.entity.EntityBlock;
import vg.view.entity.EntityBlockImpl;
import vg.view.entity.StaticFactoryEntityBlock;
import vg.view.player.PlayerViewController;
import vg.view.player.PlayerViewControllerImpl;
import vg.utils.V2D;
import vg.view.ViewController;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GameBoardViewControllerImpl extends ViewController implements GameBoardController {

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
    public void initMapView(final V2D initPlayerPos, final V2D initBossPos, final Set<DynamicEntity> mosquitoes) {
        //Set player in view map
        this.player = new PlayerViewControllerImpl();
        this.addInGameArea(this.player.getNode());

        this.boss = StaticFactoryEntityBlock.createBoss(initBossPos);
        this.addInGameArea(this.boss.getNode());

        this.mosquitoesNode = new HashSet<>();
        updateMosquitoesPosition(mosquitoes);
    }

    @Override
    public void updateMosquitoesPosition(final Set<DynamicEntity> mosquitoes) {
        this.gameArea.getChildren().removeAll(mosquitoesNode);

        mosquitoes.forEach(mosq -> {
            EntityBlock entityBlock =  StaticFactoryEntityBlock.createMosquito(mosq.getPosition());
            this.mosquitoesNode.add(entityBlock.getNode());
            this.addInGameArea(entityBlock.getNode());
        });
    }

    @Override
    public void updateBossPosition(final V2D bossPos) {
        this.boss.setPosition(bossPos.getVec2d());
    }

    @Override
    public void updatePlayerPosition(final V2D position) {
        this.player.setPosition(position.getVec2d());
    }
}
