package vg.view.menu.confirmMenu;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import vg.utils.DimensionUtils;
import vg.view.AdaptableView;
import java.io.IOException;

/**
 * A specific adaptable view to show a dialog with two selection: confirm and deny.
 * {@inheritDoc}
 */
public class ConfirmView extends AdaptableView<ConfirmViewController> {

    private ConfirmView(final Scene scene, final ConfirmViewController viewController) {
        super(scene, viewController);
    }

    /**
     * Load confirmation view and its view controller from file.
     * @return new confirmation dialog screen.
     */
    public static ConfirmView newConfirmDialogView() {
        FXMLLoader loader = new FXMLLoader(ConfirmView.class.getResource("/layout/ConfirmationView.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(loader.load(),
                    DimensionUtils.DEFAULT_WIDTH,
                    DimensionUtils.DEFAULT_HEIGHT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ConfirmViewController viewController = loader.getController();
        return new ConfirmView(scene, viewController);
    }

    /**
     * Set new title to dialog screen.
     * @param title new title string
     */
    public void setTitle(final String title) {
        this.getViewController().setTitle(title);
    }

    /**
     * Set new subtitle hint to dialog screen.
     * @param hintText new subtitle string
     */
    public void setHint(final String hintText) {
        this.getViewController().setHint(hintText);
    }

    /**
     * Highlight confirm button as selected.
     * This method delegates to {@link ConfirmViewController#highlightConfirm()}
     */
    public void selectConfirm() {
        this.getViewController().highlightConfirm();
    }

    /**
     * Highlight deny button as selected.
     *  * This method delegates to {@link ConfirmViewController#highlightDeny()}}
     */
    public void selectDeny() {
        this.getViewController().highlightDeny();
    }

}
