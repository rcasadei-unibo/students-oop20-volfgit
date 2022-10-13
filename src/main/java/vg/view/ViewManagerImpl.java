package vg.view;

import javafx.scene.Scene;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ViewManagerImpl implements ViewManager {
    private List<Scene> sceneStack;

    private ViewManagerImpl(final Scene rootScene) {
        this.sceneStack = new ArrayList<>();
        this.sceneStack.add(rootScene);
    }
    /**
     * Return new ViewManager with.
     * @param root the main scene that cannot be removed, the entry point view
     */
    public static ViewManagerImpl ViewManagerWithRoot(final Scene root) {
       return new ViewManagerImpl(root);
    }

    @Override
    public void addScene(final Scene scene) {
        this.sceneStack.add(scene);
    }

    @Override
    public void popScene() throws ExecutionException {
        int stackSize = this.sceneStack.size();
        if (stackSize > 1) {
            this.sceneStack.remove(stackSize-1);
        } else {
            throw new ExecutionException("No other scene can be removed from stack!",
                    new Throwable("You are trying to removed the root scene from sceneStack"));
        }
    }
}
