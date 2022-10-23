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
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import vg.model.MapImpl;
import vg.model.entity.ShapedEntity;
import vg.model.entity.dynamicEntity.DynamicEntity;
import vg.model.entity.dynamicEntity.enemy.Boss;
import vg.utils.V2D;
import vg.view.ViewController;
import vg.view.entity.EntityBlock;
import vg.view.entity.EntityBlockImpl;
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

    public Button life1;
    public Button life2;
    public Button life3;
    public Button life4;
    public Button life5;
    public Button life6;

    private PlayerViewController player;
    private Polyline tailPolyline;
    private EntityBlock boss;
    private Set<Node> mosquitoesNode;
    private Set<EntityBlock> mosqs;

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
        //TODO create an appropriate controller for boss?
        this.boss = StaticFactoryEntityBlock.createBoss(new Dimension2D(0,0), modelRadiusToDimension2D(5));
        this.boss.setInParentNode(this.getGameAreaNode());
        this.mosqs = new HashSet<>();
//        this.addInGameArea(this.boss.getNode());

        this.mosquitoesNode = new HashSet<>();
        this.tailPolyline = new Polyline();
    }

    @Override
    public void updateMosquitoesPosition(final Set<DynamicEntity> mosquitoes) {
       // this.gameArea.getChildren().removeAll(mosquitoesNode);
        this.gameArea.getChildren().removeAll(mosqs);
        this.mosqs.clear();/*
        var b = StaticFactoryEntityBlock.createBoss( ((EntityBlockImpl)this.boss).getDimension2D(),
                new Dimension2D( ((EntityBlockImpl) this.boss).getWidth(),((EntityBlockImpl) this.boss).getHeight()));
        this.mosqs.add(b);
        ((EntityBlockImpl) this.boss).setDisable(true);
        b.setInParentNode(this.getGameAreaNode());*/
        mosquitoes.forEach(m -> {
            EntityBlock entityBlock = StaticFactoryEntityBlock.createMosquitoes(V2DtoDimension2D(m.getPosition()), modelRadiusToDimension2D(m.getRadius()));
            entityBlock.setInParentNode(this.getGameAreaNode());
            this.mosqs.add(entityBlock);
            //this.mosquitoesNode.add(entityBlock.getNode());
            //this.addInGameArea(entityBlock.getNode());
        });
    }

    @Override
    public void updateBossPosition(final V2D bossPos) {
        ((EntityBlockImpl)this.boss).setDisable(true);
        this.getGameArea().getChildren().removeIf(Node::isDisable);
        this.boss = StaticFactoryEntityBlock.createBoss(V2DtoDimension2D(bossPos), modelRadiusToDimension2D(5));
        //((EntityBlockImpl)this.boss).setDisable(false);
        this.boss.setInParentNode(this.getGameAreaNode());

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
        this.tailPolyline.getPoints().setAll(convertTolistofDouble(tailVec));
        this.tailPolyline.setStrokeWidth(5);
        this.tailPolyline.setStroke(Paint.valueOf("#945200"));
        this.addInGameArea(this.tailPolyline);
    }

    /**
     * COnvert List of vectors V2D to a list with alternate x and y.
     * @param vectors List of vertex vector of player tail
     * @return List of double
     */
    private List<Double> convertTolistofDouble(final List<V2D> vectors) {
        List<Double> list = vectors.stream()
                .map(vec -> List.of(vec.getX(), vec.getY()))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        return list;
    }

    /**
     * Converts from model dimension into JavaFX {@link Dimension2D}.
     * @param v2d the model position
     * @return {@link Dimension2D} that correctly scales from the model position into {@link #gameArea}
     */
    private Dimension2D V2DtoDimension2D(V2D v2d){
        return new Dimension2D(v2d.getX() * getGameArea().getWidth()/ MapImpl.MAXBORDERX,
                v2d.getY() * getGameArea().getHeight()/ MapImpl.MAXBORDERY);
    }
    /**
     * Converts from model radius into JavaFX {@link Dimension2D}.
     * @param radius the model {@link ShapedEntity#getRadius()}
     * @return {@link Dimension2D} that correctly scales from the model into {@link #gameArea}
     */
    private Dimension2D modelRadiusToDimension2D(int radius){
        return new Dimension2D(radius * getGameArea().getWidth()/ MapImpl.MAXBORDERX,
                radius * getGameArea().getWidth()/ MapImpl.MAXBORDERX);
    }
    /**
     * Converts from model {@link ShapedEntity#getRadius()} into JavaFX {@link Dimension2D}.
     * @param entity the model {@link ShapedEntity#getRadius()}
     * @return {@link Dimension2D} that correctly scales from the model into {@link #gameArea}
     */
    private Dimension2D modelRadiusToDimension2D(ShapedEntity entity){
        return new Dimension2D(entity.getRadius() * getGameArea().getWidth()/ MapImpl.MAXBORDERX,
                entity.getRadius() * getGameArea().getWidth()/ MapImpl.MAXBORDERX);
    }
}
