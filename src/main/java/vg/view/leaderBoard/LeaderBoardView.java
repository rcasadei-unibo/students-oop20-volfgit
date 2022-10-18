package vg.view.leaderBoard;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import vg.view.AdaptableView;
import vg.view.menu.confirmMenu.ConfirmView;

import java.io.IOException;
import java.util.Optional;

public class LeaderBoardView extends AdaptableView<LeaderBoardViewController> {
    public LeaderBoardView() {
        super("/layout/LeaderBoard/LeaderBoard.fxml");
    }

    public static Optional<Node> listItem(final int pos, final int score, final int round) {
        Node item = null;
        FXMLLoader loader = new FXMLLoader(ConfirmView.class.getResource("/layout/LeaderBoard/SingleItemList.fxml"));
        try {
            item = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SingleItemListController itemListController = loader.getController();
        itemListController.setValue(pos, score, round);
        return Optional.ofNullable(item);
    }
}
