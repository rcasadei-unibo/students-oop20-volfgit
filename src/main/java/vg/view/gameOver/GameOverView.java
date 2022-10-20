package vg.view.gameOver;

import vg.view.AdaptableView;
import vg.view.utils.CountdownView;

public class GameOverView extends AdaptableView<GameOverViewController> implements CountdownView<GameOverViewController> {
    public GameOverView() {
        super("/layout/GameOver.fxml");
    }

    @Override
    public void setCountdown(int time) {
        this.getViewController().setCountdown(time);
    }
}
