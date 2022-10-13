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
    private List<Pair<EventHandlerController, Scene>> sceneStack;

    /**
     * Return new ViewManager with.
     * @param stage the main scene that cannot be removed, the entry point view
     */
    public ViewManagerImpl(final Stage stage) {
        this.stage = stage;
        stage.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
            EventHandlerController ctrl = this.sceneStack.get(this.sceneStack.size() - 1).getKey();
            ctrl.notifyKeyEvent(e.getCode());
        });
        this.sceneStack = new ArrayList<>();
    }

    @Override
    public void addScene(final Scene scene, final EventHandlerController controller) {
        this.sceneStack.add(new Pair<>(controller, scene));
        this.stage.setScene(scene);
        this.stage.requestFocus();
        this.stage.show();
    }


    @Override
    public void popScene() {
        int stackSize = this.sceneStack.size();
        if (stackSize > 1) {
            System.out.println(stackSize);
            this.stage.setScene(this.sceneStack.get(stackSize - 1).getValue());
            //this.sceneStack.remove(stackSize - 1);
            this.stage.requestFocus();
            this.stage.show();
        }
    }
}
