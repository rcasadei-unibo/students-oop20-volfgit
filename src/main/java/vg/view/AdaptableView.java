package vg.view;

import javafx.scene.Scene;
import vg.controller.Controller;
import vg.utils.NoSuchControllerException;
import vg.view.utils.KeyAction;

import java.util.Optional;

/**
 * A view that resize and correctly puts elements on the screen
 * based on the resolution.
 */
public abstract class AdaptableView implements View {
    private final Scene scene;
    private Optional<Controller> controller;

    protected AdaptableView(Scene scene) {
        this.scene = scene;
    }

    @Override
    public Controller getController() throws NoSuchControllerException {
        if (this.controller.isPresent()) {
            return this.controller.get();
        } else {
            throw new NoSuchControllerException();
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = Optional.of(controller);
    }

    @Override
    public Scene getScene() {
        return this.scene;
    }
}
