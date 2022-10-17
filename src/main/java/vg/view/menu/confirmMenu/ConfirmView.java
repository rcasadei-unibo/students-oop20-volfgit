package vg.view.menu.confirmMenu;

import javafx.scene.Scene;
import vg.utils.DimensionUtils;
import vg.utils.LoadFxmlUtils;
import vg.view.AdaptableView;

public class ConfirmView extends AdaptableView {

    protected ConfirmView() {
        super(new Scene(LoadFxmlUtils.loadFxml(""),
                DimensionUtils.DEFAULT_WIDTH,
                DimensionUtils.DEFAULT_HEIGHT));
    }

    public void setTitle(final String title) {
        this.getScene().lookup("#titleText");
    }

    public void setHint(final String hintText) {
        this.getScene().lookup("#hintText");
    }

    @Override
    public void draw() {

    }

    @Override
    public void reset() {

    }
}
