package vg.view.block;

import vg.utils.DimensionUtils;

import java.util.ArrayList;
import java.util.List;

public class ManagerBlock {

    private final int countRow;
    private final int countColumn;

    private final List<Block> blockControllers;

    public ManagerBlock() {
        this.countRow = DimensionUtils.DEFAULT_WIDTH / 50;
        this.countColumn = DimensionUtils.DEFAULT_HEIGHT / 60;
        this.blockControllers = new ArrayList<>();
    }

    public void createBlock(){
        for (int i = 0; i < countRow; i++) {
            for (int j = 0; j < countColumn; j++) {
                Block blockController = new Block();
                blockController.setX(i * 50);
                blockController.setY(j * 50);
                blockControllers.add(blockController);
            }
        }
    }

    public List<Block> getBlockControllers() {
        return blockControllers;
    }
}
