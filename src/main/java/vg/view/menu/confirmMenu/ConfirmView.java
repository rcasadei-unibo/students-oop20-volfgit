package vg.view.menu.confirmMenu;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import vg.utils.DimensionUtils;
import vg.utils.LoadFxmlUtils;
import vg.view.AdaptableView;

public class ConfirmView extends AdaptableView {

    public ConfirmView() {
        super(new Scene(LoadFxmlUtils.loadFxml("layout/ConfirmationView.fxml"),
                DimensionUtils.DEFAULT_WIDTH,
                DimensionUtils.DEFAULT_HEIGHT));
    }

    public void setTitle(final String title) {
        ((Text )this.getScene().lookup("#titleText")).setText(title);
    }

    public void setHint(final String hintText) {
        ((Text) this.getScene().lookup("#hintText")).setText(hintText);
    }

    public void selectConfirm() {
        //TODO: edit graphic/color of rectangle
        //((Rectangle) this.getScene().lookup("#confirmBtn"));
        System.out.println("CONFIRM");
    }

    public void selectDeny() {
        //TODO: edit graphic/color of rectangle
        System.out.println("DENY");
    }

}
