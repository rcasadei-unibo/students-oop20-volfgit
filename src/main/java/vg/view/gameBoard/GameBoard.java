package vg.view.gameBoard;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import vg.utils.DimensionUtils;
import vg.utils.LoadFxmlUtils;
import vg.view.ViewManager;
import vg.view.block.ManagerBlock;

public class GameBoard extends Application {

    private static Stage stage;
    GameBoardController controller = new GameBoardController();

    ManagerBlock managerBlock = new ManagerBlock();

    ViewManager viewManager;

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(LoadFxmlUtils.loadFxml("layout/GameBoard.fxml"));
        stage.setTitle("GameBoard");
        stage.setScene(scene);
        managerBlock.createBlock();

//        Rectangle rectangle = new Rectangle(25, 25);
//        rectangle.setX(0);
//        rectangle.setY(0);
//        rectangle.setStyle("-fx-fill: #ffffff;");


        Pane gameArea = (Pane) scene.lookup("#gameArea");
        this.managerBlock.getBlockControllers().forEach(gameArea.getChildren()::add);
//        gameArea.getChildren().add(this.blockController) ;




        stage.setMinWidth(DimensionUtils.DEFAULT_WIDTH);
        stage.setMinHeight(DimensionUtils.DEFAULT_HEIGHT);
        stage.setMaxWidth(DimensionUtils.DEFAULT_WIDTH);
        stage.setMaxHeight(DimensionUtils.DEFAULT_HEIGHT);

//        stage.minWidthProperty().bind(scene.heightProperty().multiply(2));
//        stage.minHeightProperty().bind(scene.widthProperty().divide(2));

        stage.show();
    }
}

