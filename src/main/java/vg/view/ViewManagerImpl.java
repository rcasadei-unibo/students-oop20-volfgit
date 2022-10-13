package vg.view;

import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import vg.view.utils.KeyEventHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * ViewManager is responsible to manage and the navigation stack from main page;
 * it keeps Stage and set/remove scene to be shown and notify the controller of visible view (scene)
 * about the keyEvent registered by EventHandler of stage.
 */
public class ViewManagerImpl implements ViewManager {
    private final Stage stage;
    private List<Scene> sceneStack;

    /**
     * Return new ViewManager that control scene of a stage.
     * @param stage the main scene that cannot be removed, the entry point view
     */
    public ViewManagerImpl(final Stage stage) {
        this.stage = stage;
        //stage.addEventHandler(KeyEvent.KEY_PRESSED,);
        /*TODO: IDEA COSA ANDREBBE FATTO :
           quando si verifca un evento questo deve essere comunicato al controller della view attiva attraverso
           il metodo di interfaccia SceneController.activateEvent()
           (event, controller) -> {
                c.activateEvent(e.keyAction);
           }
        */
        this.sceneStack = new ArrayList<>();
    }

    @Override
    public void addScene(final Scene scene/*, final EventHandlerController controller*/) {
        /* TODO: remove handler ....
        * */
        this.stage.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
            /*TODO:
               1) get controller from element in sceneStack
               2) call method on controller passing event e (in order to call method activatesEvent(....))
            */
        });
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

    private Optional<Scene> currentScene() {
        if (!this.sceneStack.isEmpty()) {
            return Optional.of(this.sceneStack.get(sceneStack.size()-1));
        }
        else {
            return Optional.empty();
        }
    }
}
