package vg.view;

import javafx.scene.Scene;
import vg.controller.Controller;
import vg.view.utils.KeyAction;

/**
 * A view that resize and correctly puts elements on the screen
 * based on the resolution.
 */
public abstract class AdaptableView implements View {
    private final Scene scene;
    private Controller controller;

    protected AdaptableView(Scene scene) {
        this.scene = scene;
    }

    @Override
    public Controller getController() {
        return this.controller;
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public Scene getScene() {
        return this.scene;
    }

    /**
     * This draw must use {@link vg.view.utils.ScreenLoader} utilities when
     * implemented to resize correctly.
     */
    @Override
    public void draw() {
    }
}
