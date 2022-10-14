package vg.view;

import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import vg.view.utils.KeyAction;
import vg.view.utils.KeyEventHandler;

import java.util.Optional;
import java.util.Stack;

/**
 * ViewManager is responsible to manage and the navigation stack from main page;
 * it keeps Stage and set/remove scene to be shown and notify the controller of visible view (scene)
 * about the keyEvent registered by EventHandler of stage.
 */
public class ViewManagerImpl implements ViewManager {
    private final Stage stage;
    private final Stack<Scene> sceneStack;
    private final KeyEventHandler keyEventHandler;

    /**
     * Return new ViewManager that control scene of a stage.
     * @param stage the main scene that cannot be removed, the entry point view
     */
    public ViewManagerImpl(final Stage stage) {
        this.stage = stage;
        this.sceneStack = new Stack<>();
        this.keyEventHandler = new KeyEventHandler();
        stage.addEventHandler(KeyEvent.ANY, this.keyEventHandler);
    }

    @Override
    public void addScene(final Scene scene) {
        //TODO: get controller of view and set
        //this.keyEventHandler.setSceneController(getCurrentController());
        this.sceneStack.push(scene);
        this.stage.setScene(scene);
    }

    @Override
    public void popScene() {
        if (this.sceneStack.size() > 1) {
            this.sceneStack.pop();
            //TODO: get controller of view and set
            this.stage.setScene(this.sceneStack.lastElement());
        }
    }

    public Stage getStage() {
        return this.stage;
    }
}
