package vg.view.menu.confirmMenu;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import vg.utils.DimensionUtils;
import vg.utils.LoadFxmlUtils;
import vg.view.AdaptableView;

import java.io.IOException;
import java.util.Optional;

public class ConfirmView extends AdaptableView {
    private Optional<ConfirmViewController> viewController;

    private ConfirmView(final Scene scene, final ConfirmViewController viewController) {
        super(new Scene(LoadFxmlUtils.loadFxml("layout/ConfirmationView.fxml"),
                DimensionUtils.DEFAULT_WIDTH,
                DimensionUtils.DEFAULT_HEIGHT));
        this.viewController = Optional.ofNullable(viewController);
    }

    public static ConfirmView newConfirmDialogView() {
        FXMLLoader loader = new FXMLLoader(ConfirmView.class.getResource("/layout/ConfirmationView.fxml"));
        Scene scene = null;
        //TODO: review and do it better
        try {
            scene = new Scene(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        ConfirmViewController viewController = loader.getController();
        return new ConfirmView(scene, viewController);
    }

    public void setTitle(final String title) {
    }

    public void setHint(final String hintText) {

    }

    public void selectConfirm() {
        this.viewController.ifPresent(ConfirmViewController::highlightConfirm);
        System.out.println("CONFIRM");

    }

    public void selectDeny() {
        this.viewController.ifPresent(ConfirmViewController::highlightDeny);
        System.out.println("DENY");
    }

}
