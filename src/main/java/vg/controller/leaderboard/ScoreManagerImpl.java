package vg.controller.leaderboard;

import vg.model.score.Score;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ScoreManagerImpl implements Serializable, ScoreManager {
    /**
     * Name of file where is saved list of scores.
     */
    private static final String LEADERBOARD_FILE = "leaderboard";

    /**
     * List of all score saved.
     */
    private List<Score> leaderboard;

    private ScoreManagerImpl() {
        this.init();
    }

    /**
     * Static initializer.
     * @return ScoreManager
     */
    static ScoreManager newScoreManager() {
        return new ScoreManagerImpl();
    }

    /**
     * Save list of score on file, updating it.
     * @throws IOException if occurs error in writing file
     */
    private void saveCurrentLeaderboard() throws IOException {
        FileOutputStream out = new FileOutputStream("leaderboard");
        ObjectOutputStream oOut = new ObjectOutputStream(out);
        oOut.writeObject(leaderboard);
        oOut.flush();
        oOut.close();
    }

    /**
     * Read saved scores from {@link ScoreManagerImpl#LEADERBOARD_FILE} and create a local runtime copy.
     * @return list of {@link Score} loaded from file.
     * @throws IOException If file not found
     * @throws ClassNotFoundException if cast of read object
     */
    private List<Score> readSavedLeaderboard() throws IOException, ClassNotFoundException {
        FileInputStream in = new FileInputStream(LEADERBOARD_FILE);
        ObjectInputStream oIn = new ObjectInputStream(in);
        var leaderboard = (List<Score>) oIn.readObject();
        oIn.close();
        return leaderboard;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void init() {
        try {
            this.leaderboard = readSavedLeaderboard();
        } catch (Exception e) {
            this.leaderboard = new ArrayList<>();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveScore(final Score score) {
        this.leaderboard.add(score);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Score> getTop10Score() {
        return this.getTopScore(10);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Score> getTopScore(final int limit) {
        //TODO: implement comaprison of scores in sorted()
        return this.leaderboard.stream().sorted().limit(limit).collect(Collectors.toList());
    }
}
