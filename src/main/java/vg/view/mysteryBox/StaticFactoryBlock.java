package vg.view.mysteryBox;

public class StaticFactoryBlock {

    public static BlockImpl createBlock(double x, double y, double width, double height) {
        return new BlockImpl(x, y, width, height);
    }

}
