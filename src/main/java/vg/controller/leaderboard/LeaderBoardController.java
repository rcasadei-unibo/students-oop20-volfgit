package vg.controller.leaderboard;

import vg.controller.Controller;
import vg.view.ViewManager;
import vg.view.leaderBoard.LeaderBoardView;
import vg.view.utils.KeyAction;

public class LeaderBoardController extends Controller<LeaderBoardView> {

    public LeaderBoardController(LeaderBoardView view, ViewManager viewManager) {
        super(view, viewManager);
    }

    @Override
    public void keyTapped(final KeyAction k) {
    }

    @Override
    public void keyPressed(final KeyAction k) {
        if (k == KeyAction.ENTER) {
            this.getView().getViewController().closeBtnPressing();
        }
    }

    @Override
    public void keyReleased(final KeyAction k) {
        if (k == KeyAction.ENTER) {
            this.getViewManager().popScene();
        }
    }
}
