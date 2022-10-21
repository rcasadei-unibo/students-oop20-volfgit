package vg.controller.leaderboard;

import vg.controller.Controller;
import vg.view.ViewManager;
import vg.view.leaderBoard.LeaderBoardView;
import vg.view.utils.KeyAction;

public class LeaderBoardController extends Controller<LeaderBoardView> {



    public LeaderBoardController(final LeaderBoardView view, final ViewManager viewManager) {
        super(view, viewManager);
        loadData();
    }

    //TODO: here load from file list of player and theri scores, after load update view

    private void loadData() {
/*  //TODO: read file then when has finished call gui to show list
        new Thread(() ->
        {
        });
*/
        this.getView().getViewController().showList();
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
