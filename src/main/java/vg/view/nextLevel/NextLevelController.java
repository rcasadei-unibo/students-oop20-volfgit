package vg.view.nextLevel;

import vg.controller.Controller;
import vg.view.ViewManager;
import vg.view.utils.KeyAction;

public class NextLevelController extends Controller<NextLevelView> {

    private int waitingTime = 5;

    public NextLevelController(final NextLevelView view, final ViewManager viewManager) {
        super(view, viewManager);
    }

    private void showTimedView() {
        //this.getViewManager().
        new Thread(() -> {
            while (waitingTime > 0) {
                this.waitingTime--;
            }
        }).start();
    }


    @Override
    public void keyTapped(final KeyAction k) {

    }

    @Override
    public void keyPressed(final KeyAction k) {

    }

    @Override
    public void keyReleased(final KeyAction k) {

    }
}
