package vg.view;


import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import vg.controller.Controller;
import vg.view.utils.KeyAction;

public interface View {
    /**
     * @return controller of view.
     */
    Controller getController();

    /**
     * Set controller of view.
     * @param controller controller that controls this view.
     */
    void setController(Controller controller);
    Scene getScene();

    /**
     * This draw must use {@link vg.view.utils.ScreenLoader} utilities when
     * implemented to resize correctly.
     */
    void draw();
    void reset();
}
