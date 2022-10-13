package vg.view;

import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Pair;
import vg.controller.KeyAction;
import vg.controller.StateController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ViewManagerImpl<V> implements ViewManager<V> {
    private final Stage stage;
    private List<Pair<StateController<V>, Scene>> sceneStack;

    private ViewManagerImpl(final Stage stage) {
        this.stage = stage;
        stage.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
            StateController<V> ctrl = this.sceneStack.get(this.sceneStack.size() - 1).getKey();
            KeyAction action = ctrl.captureKeyEvent(e.getCode());
            ctrl.activatesEvent(action);
        });
        this.sceneStack = new ArrayList<>();
    }
    /**
     * Return new ViewManager with.
     * @param stage the main scene that cannot be removed, the entry point view
     */
    public ViewManagerImpl<V> ViewManagerWithRoot(final Stage stage) {
        return new ViewManagerImpl<>(stage);
    }

    @Override
    public void addScene(final Scene scene, final StateController<V> controller) {
        this.sceneStack.add(new Pair<>(controller, scene));
        this.stage.setScene(scene);
    }


    @Override
    public void popScene() throws ExecutionException {
        int stackSize = this.sceneStack.size();
        if (stackSize > 1) {
            this.sceneStack.remove(stackSize - 1);
            this.stage.setScene(this.sceneStack.get(stackSize - 1).getValue());
        } else {
            throw new ExecutionException("No other scene can be removed from stack!",
                    new Throwable("You are trying to removed the root scene from sceneStack"));
        }
    }
}
