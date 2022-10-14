package vg.view;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import vg.view.utils.KeyAction;
import vg.view.utils.KeyEventHandler;

import java.util.Map;
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

    private ViewManagerImpl(final Stage stage, final KeyEventHandler keyEventHandler) {
        this.stage = stage;
        this.sceneStack = new Stack<>();
        this.keyEventHandler = keyEventHandler;
        stage.addEventHandler(KeyEvent.ANY, keyEventHandler);
    }

    /**
     * Return new ViewManager that control scene of a stage.
     * @param stage the main scene that cannot be removed, the entry point view
     * @param keySetting Map association KeyCode to KeyAction.
     */
    public ViewManager newViewManager(final Stage stage, final Map<KeyCode, KeyAction> keySetting) {
        KeyEventHandler keyEventHandler = new KeyEventHandler();
        keyEventHandler.updateKeySettings(keySetting);
        return new ViewManagerImpl(stage, keyEventHandler);
    }

    /**
     * Return new ViewManager that control scene of a stage.
     * @param stage the main scene that cannot be removed, the entry point view
     */
    public ViewManager newViewManager(final Stage stage) {
        return new ViewManagerImpl(stage, new KeyEventHandler());
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

    @Override
    public void backHome() {
        Scene mainScene = this.sceneStack.firstElement();
        this.sceneStack.removeAllElements();
        this.sceneStack.add(mainScene);
    }

    public Stage getStage() {
        return this.stage;
    }
}
