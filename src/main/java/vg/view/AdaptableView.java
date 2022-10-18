package vg.view;

import javafx.scene.Scene;
import vg.controller.Controller;
import vg.utils.NoSuchControllerException;

import java.util.Optional;

/**
 * A view that resize and correctly puts elements on the screen
 * based on the resolution.
 */
public abstract class AdaptableView implements View {
    private final Scene scene;
    private Optional<Controller> logicController;

    protected AdaptableView(final Scene scene) {
        this.scene = scene;
    }

    @Override
    public void setIoLogicController(final Controller controller) {
        this.logicController = Optional.of(controller);
    }

    @Override
    public Controller getIoLogicController() throws NoSuchControllerException {
        if (this.logicController.isPresent()) {
            return this.logicController.get();
        } else {
            throw new NoSuchControllerException();
        }
    }

    @Override
    public Scene getScene() {
        return this.scene;
    }
}
