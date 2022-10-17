package vg.view.block;

import javafx.geometry.Dimension2D;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public class ManagerBlock {

    private final int countBlockRow;
    private final int countBlockColumn;

    private  double widthSingleBlock;
    private  double heightSingleBlock;

    private final List<Block> blockControllers;

    public ManagerBlock() {
        this.countBlockRow = 15;
        this.countBlockColumn = 30;
        this.blockControllers = new ArrayList<>();
    }

    public void createBlock(Pane gameArea) {


        this.widthSingleBlock = gameArea.getWidth() / this.countBlockColumn;
        this.heightSingleBlock = gameArea.getHeight() / this.countBlockRow;

        System.out.println("width " + gameArea.getWidth() + " height " + gameArea.getHeight());

        for (int i = 0; i < this.countBlockRow; i++) {
            for (int j = 0; j < this.countBlockColumn; j++) {
                Block block = new Block(this.widthSingleBlock, this.heightSingleBlock);
                gameArea.getChildren().add(block);
                block.setX(j * this.widthSingleBlock);
                block.setY(i * this.heightSingleBlock);
                this.blockControllers.add(block);
            }
        }
    }

    public List<Block> getBlockControllers() {
        return this.blockControllers;
    }
}
