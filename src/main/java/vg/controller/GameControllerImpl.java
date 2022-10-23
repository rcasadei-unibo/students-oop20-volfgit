package vg.controller;

import javafx.application.Platform;
import vg.controller.entity.EntityManager;
import vg.controller.entity.EntityManagerImpl;
import vg.controller.gameBoard.GameBoardController;
import vg.controller.leaderboard.ScoreManagerImpl;
import vg.model.Stage;
import vg.model.StageImpl;
import vg.model.entity.dynamicEntity.player.Player;
import vg.model.score.Score;
import vg.utils.*;
import vg.view.AdaptableView;
import vg.view.SceneController;
import vg.view.View;
import vg.view.ViewManager;
import vg.view.ViewFactory;
import vg.view.gameOver.GameOverView;
import vg.controller.prompt.PromptOption;
import vg.view.menu.prompt.PromptView;
import vg.controller.prompt.PromptObserver;
import vg.view.transition.TransitionViewController;
import vg.view.utils.CountdownView;
import vg.view.utils.KeyAction;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Game Engine class, manager game loop and refresh timing
 * during gameplay.
 * */
public class GameControllerImpl extends Controller<AdaptableView<GameBoardController>> implements SceneController, PromptObserver, GameController {
    /**
     * Waiting time of timed screens.
     */
    private static final int SCREEN_DURATION_TIME = 4;
    /**
     * Command queue of new player's movement got from input to be applied.
     */
    private final List<Command<Player>> movementQueue;
    /**
     * Period of each frame.
     */
    private static final long CYCLE_PERIOD = 50; // frequencies = 1/period
    /**
     * Terminating condition of game loop.
     */
    private GameState gameState = GameState.PLAYING;
    /**
     * Game domain.
     */
    private Stage<V2D> stageDomain;

    private final EntityManager entityManager;

    public GameControllerImpl(final AdaptableView<GameBoardController> view, final Stage<V2D> stageDomain, final ViewManager viewManager) {
        super(view, viewManager);
        this.entityManager = new EntityManagerImpl();
        this.movementQueue = new ArrayList<>();
        this.stageDomain = stageDomain;
        this.getGameViewController().initMapView();
        this.render();
        ((StageImpl<?>)this.stageDomain).setEntityManagerController(this.entityManager);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void launchGameSession() {
        this.gameState = GameState.PLAYING;
        this.entityManager.initializeRound(super.getView().getViewController());
        this.gameLoop();
    }

    /**
     * Loop to make game running. At every cycle it processes input, update domain then update gui.
     */
    private void gameLoop() {
        oneTimeRender();
        //Launch on new thread game loop in order to not block gui.
        new Thread(() -> {
            long prevCycleTime = System.currentTimeMillis();
            while (gameState == GameState.PLAYING) {
                long curCycleTime = System.currentTimeMillis();
                long elapsedTime = curCycleTime - prevCycleTime;
                this.processInput();
                updateGameDomain(elapsedTime);
                render();
                checkGameoverCondition();
                checkVictory();
                waitForNextFrame(curCycleTime);
                prevCycleTime = curCycleTime;
            }
            if (this.gameState == GameState.GAMEOVER) {
                this.gameOver();
            } else if (this.gameState == GameState.VICTORY) {
                this.victory();
            } else if (gameState == GameState.PAUSED) {
                this.showPause();
            }
        }).start();
    }

    /**
     * Method to keep each loop cycle duration at a fixed time,
     * it prevents that cycle duration is less than framerate period.
     * @param elapsedTime current time elapsed from prev. cycle
     */
    private void waitForNextFrame(final long elapsedTime) {
        long dt = System.currentTimeMillis() - elapsedTime;
        if (dt < CYCLE_PERIOD) {
            try {
                Thread.sleep(CYCLE_PERIOD - dt);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Update game domain: move entities, check collision and refresh bonus timer.
     * @param elapsedTime time elapsed between current and previous gameLoop cycle
     */
    private void updateGameDomain(final long elapsedTime) {
        this.stageDomain.getPlayer().getShield().updateTimer(elapsedTime);
        this.stageDomain.getMap().updateBonusTimer(elapsedTime);
        this.stageDomain.doCycle();
        this.entityManager.countingTimeMysteryBox(elapsedTime, this.stageDomain);
        this.entityManager.checkMysteryBoxOnBorder(this.stageDomain, this.getGameViewController());
    }

    /**
     * Checks game over conditions then if player loose set {@link GameControllerImpl#gameState} to {@link GameState#GAMEOVER}.
     */
    private void checkGameoverCondition() {
        if (this.stageDomain.getPlayer().getLife() <= 0) {
            this.gameState = GameState.GAMEOVER;
        }
    }

    /**
     * Check condition of victory then set {@link GameControllerImpl#gameState} if player complete current level.
     */
    private void checkVictory() {
        if (this.stageDomain.getMap().getOccupiedPercentage() > 80) {
            this.gameState = GameState.VICTORY;
        }
    }

    /**
     * Render static elements that during game-loop doesn't change.
     */
    private void oneTimeRender() {
        Platform.runLater(() -> {
            //Round
            getGameViewController().setRound(this.stageDomain.getLv());
            //HighScore
            Optional<Score> highScore = ScoreManagerImpl.newScoreManager().getTopScore(1).stream().findFirst();
            highScore.ifPresent(score -> getGameViewController().setHighScoreText(score.getScore()));
        });
    }

    /**
     * Update view of game on JavaFX thread in order to no block controller thread.
     */
    private void render() {
        Platform.runLater(() -> {
            //Game Counters
            getGameViewController().updateLifeCounter(this.stageDomain.getPlayer().getLife());
            getGameViewController().updateShieldTime(this.stageDomain.getPlayer().getShield().getRemainingTime());
            getGameViewController().updateScoreText(this.stageDomain.getCurrentScore());
            getGameViewController().updatePercentage(this.stageDomain.getMap().getOccupiedPercentage());

            //Player
            Player player = this.stageDomain.getPlayer();
            getGameViewController()
                    .updatePlayer(player.getPosition(),
                            this.stageDomain.getMap().isPlayerOnBorders() && player.getShield().isActive(),
                            player.getTail().getVertex(),
                            this.stageDomain.getMap().isTailCompleted());
            //Boss
            getGameViewController().updateBossPosition(this.stageDomain.getBoss().getPosition());
            //Borders
            getGameViewController().updateBorders(V2DUtility.getVertex(List.copyOf(this.stageDomain.getBorders())));
            //Mosquitoes
            getGameViewController().updateMosquitoesPosition(this.stageDomain.getDynamicEntitySet());
        });
    }

    /**
     * Put game in pause then show a dialog to ask if user wants stop playing and go back to main menu.
     * The response is received by the method {{@link #notifyDialogAnswer(PromptOption)}} of interface
     * {@link PromptObserver} and resume or go home depending on response.
     */
    public void closeGame() {
        this.gameState = GameState.QUITTING;
        PromptView promptView = ViewFactory.promptView(this.getViewManager(), this);
        promptView.setTitle("Stop playing and back home?");
        //launch confirmation dialog
        //the response is communicated through method notifyDialogAnswer
        this.getViewManager().addScene(promptView);
    }

    /**
     * Put gameplay in pause state and show pause screen.
     */
    private void showPause() {
        System.out.println("PAUSE");
        View pauseView = ViewFactory.pauseView();
        showView(pauseView);
    }

    /**
     * Resume gameplay setting {@link GameControllerImpl#gameState} to {@link GameState#PLAYING},
     * removing pause view and starting {@linkplain GameControllerImpl#gameLoop()}.
     */
    private void resumeGame() {
        System.out.println("RESUME");
        this.gameState = GameState.PLAYING;
        this.getViewManager().popScene();
        this.gameLoop();
    }

    /**
     * Show game-over view then back to home.
     */
    private void gameOver() {
        System.out.println("GAMEOVER");
        GameOverView gameOverView = ViewFactory.gameOverView(
                stageDomain.getCurrentScore(),
                stageDomain.getLv(),
                this.getViewManager());
        this.showView(gameOverView);
    }

    /**
     *  Show victory screen then load next level domain and when are elapsed 3 second is called
     *  {@link GameControllerImpl#resumeGame()}.
     */
    private void victory() {
        System.out.println("VICTORY");
        this.stageDomain.createNextLevel();
        CountdownView<TransitionViewController> transView = ViewFactory.transitionView(
                stageDomain.getCurrentScore(),
                stageDomain.getLv());
        transView.setIoLogicController(this);
        showTimedView(transView, SCREEN_DURATION_TIME);
        resumeGame();
    }

    /**
     * Show for an amount of time a view then remove it.
     *
     * @param view View to be temporarily showed that implements {@link CountdownView}
     * @param duration amount of time to show the view
     */
    private void showTimedView(final CountdownView view, final int duration) {
        this.showView(view);
            int i = duration;
            while (i > 0) {
                i--;
                final int r = i;
                Platform.runLater(() -> view.setCountdown(r));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Platform.runLater(() -> getViewManager().popScene());
    }

    /**
     * Gets {@link javafx.scene.Scene}'s controller of game view.
     * @return {@link GameBoardController}
     */
    private GameBoardController getGameViewController() {
        return this.getView().getViewController();
    }

    /**
     * Show passed view on screen;
     * this method delegates {@link ViewManager#addScene(View)} to do it.
     * @param view View to show on screen
     */
    private void showView(final View view) {
        Platform.runLater(() -> {
            view.setIoLogicController(this);
            this.getViewManager().addScene(view);
        });
    }

    /**
     * Process command in the head of queue (the older one)
     * in order to move player.
     */
    private void processInput() {
        if (!this.movementQueue.isEmpty()) {
            Command<Player> cmd = this.movementQueue.get(0);
            this.movementQueue.remove(cmd);
            //set new player direction
            cmd.execute(this.stageDomain.getMap().getPlayer());
        }
    }

    /**
     * Append command to change player direction at the movementQueue.
     * @param dir new direction of player to be set
     */
    private void appendPlayerCommand(final Direction dir) {
        Boolean isOnBorder = this.stageDomain.getMap().isPlayerOnBorders();
        this.movementQueue.add(pl -> pl.changeDirection(dir, isOnBorder));
    }

    @Override
    public void notifyDialogAnswer(final PromptOption answer) {
        if (answer == PromptOption.CONFIRM) {
            this.getViewManager().backHome();
        } else if (answer == PromptOption.DENY) {
            resumeGame();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void keyTapped(final KeyAction action) {
        if (action != null) {
            switch (action) {
                case P:
                    //Toggle from pause and playing state
                    if (gameState == GameState.PLAYING) {
                        this.gameState = GameState.PAUSED;
                    } else if (gameState == GameState.PAUSED) {
                        this.resumeGame();
                    }
                    break;
                case ENTER:
                    break;
                case ESCAPE: this.closeGame();
                    break;
                default:
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void keyPressed(final KeyAction action) {
        if (gameState == GameState.PLAYING) {
            switch (action) {
                case UP:
                    appendPlayerCommand(Direction.UP);
                    break;
                case DOWN:
                    appendPlayerCommand(Direction.DOWN);
                    break;
                case LEFT:
                    appendPlayerCommand(Direction.LEFT);
                    break;
                case RIGHT:
                    appendPlayerCommand(Direction.RIGHT);
                    break;
                default:
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void keyReleased(final KeyAction k) {
        System.out.println("RELEASED : " + k.name());
        if (gameState == GameState.PLAYING &&
            (k == KeyAction.DOWN || k == KeyAction.UP ||
             k == KeyAction.LEFT || k == KeyAction.RIGHT)) {
            appendPlayerCommand(Direction.NONE);
        }
        keyTapped(k);
    }

}
