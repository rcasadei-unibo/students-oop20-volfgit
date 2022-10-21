package vg.view.leaderBoard;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import vg.model.score.Score;
import vg.view.ViewController;

import java.util.List;
import java.util.Optional;

public class LeaderBoardViewController extends ViewController {

    @FXML
    private Label closeBtn;

    @FXML
    private VBox list;

    @FXML
    private Separator sep1;

    @FXML
    private Separator sep2;

    public void closeBtnPressing() {
        closeBtn.setTextFill(Paint.valueOf("#fff600"));
    }

    public void showList(final List<Score> scoreList) {
        for(int i = 1; i < scoreList.size(); i++) {
            Score score = scoreList.get(i);
            Optional<Node> itemRow = LeaderBoardView.listItem(i, score.getName(), score.getScore(), score.getRound());
            itemRow.ifPresent(node -> list.getChildren().add(node));
        }
    }

}
