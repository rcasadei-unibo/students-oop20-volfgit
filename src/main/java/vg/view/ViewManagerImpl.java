package vg.view;

import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Pair;
import vg.controller.EventHandlerController;
import vg.controller.KeyAction;
import vg.controller.StateController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ViewManagerImpl implements ViewManager {
    private final Stage stage;
    private List<Scene> sceneStack;

    /**
     * Return new ViewManager with.
     * @param stage the main scene that cannot be removed, the entry point view
     */
    public ViewManagerImpl(final Stage stage) {
        this.stage = stage;
        /*
        stage.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
            EventHandlerController ctrl = this.sceneStack.get(this.sceneStack.size() - 1);
            ctrl.notifyKeyEvent(e.getCode());
        });*/
        this.sceneStack = new ArrayList<>();
    }

    @Override
    public void addScene(final Scene scene/*, final EventHandlerController controller*/) {
        this.sceneStack.add(scene);
        this.stage.setScene(scene);
    }

    @Override
    public void popScene() {
        int stackSize = this.sceneStack.size();
        if (stackSize > 1) {
            this.sceneStack.remove(stackSize - 1);
            this.stage.setScene(this.sceneStack.get(this.sceneStack.size() -1 ));
        }
    }

    public Stage getStage() {
        return this.stage;
    }
}
