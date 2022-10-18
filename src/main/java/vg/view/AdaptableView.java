package vg.view;

import javafx.scene.Scene;
import vg.controller.Controller;
import vg.utils.NoSuchControllerException;
import vg.view.menu.confirmMenu.ConfirmViewController;

import java.util.Optional;

/**
 * A view that resize and correctly puts elements on the screen
 * based on the resolution.
 * It keeps logic controller ({@link Controller}) and javafx scene ({@link Scene}).
 */
public abstract class AdaptableView<T> implements View<T> {
    private final Scene scene;
    private Optional<Controller> logicController;
    /**
     * JavaFX controller loaded from file associated to file fxml.
     */
    private Optional<T> viewController;

    protected AdaptableView(final Scene scene, final T viewController) {
        this.scene = scene;
        this.viewController = Optional.ofNullable(viewController);
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

    @Override
    public T getViewController() {
        if (this.viewController.isPresent()) {
            return this.viewController.get();
        } else {
            throw new NoSuchControllerException();
        }
    }

}
