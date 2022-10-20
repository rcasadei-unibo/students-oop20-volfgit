package vg.controller;

import javafx.application.Platform;
import vg.controller.entity.EntityManager;
import vg.controller.entity.EntityManagerImpl;
import vg.controller.gameBoard.GameBoardController;
import vg.model.StageImpl;
import vg.model.entity.dynamicEntity.enemy.Mosquitoes;
import vg.model.Stage;
import vg.model.entity.dynamicEntity.player.Player;
import vg.utils.*;
import vg.view.AdaptableView;
import vg.view.SceneController;
import vg.view.View;
import vg.view.ViewManager;
import vg.view.ViewFactory;
import vg.view.gameOver.GameOverViewController;
import vg.view.menu.confirmMenu.ConfirmOption;
import vg.view.menu.confirmMenu.ConfirmView;
import vg.view.menu.confirmMenu.DialogConfirmController;
import vg.view.menu.confirmMenu.DialogAnswerObserver;
import vg.view.utils.CountdownView;
import vg.view.utils.KeyAction;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Game Engine class, manager game loop and refresh timing
 * during gameplay.
 * */
public class GameController extends Controller<AdaptableView<GameBoardController>> implements SceneController, DialogAnswerObserver {
    /**
     * Waiting time of timed screens.
     */
    private static final int WAITING_TIME = 5;
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



    //TODO: pass satgeDomain as parameter
    public GameController(final AdaptableView<GameBoardController> view, final ViewManager viewManager) {
        super(view, viewManager);
        this.entityManager = new EntityManagerImpl();
        this.entityManager.initializeRound(view.getViewController());
        this.movementQueue = new ArrayList<>();
        try {
            this.stageDomain = loadStageModel();
        } catch (Exception e) { }

        this.getGameViewController()
            .initMapView(this.stageDomain.getPlayer().getPosition(),
                         this.stageDomain.getBoss().getPosition(),
                         //TODO: stageDomain.getMosquitoes
                         Set.of(new Mosquitoes(new V2D(4,4),new V2D(4,4),7,Shape.CIRCLE,MassTier.LOW)));
    }

    private Stage<V2D> loadStageModel() throws IOException, ClassNotFoundException {

        return new StageImpl<V2D>();
    }

    /**
     * Loop to make game running. At every cycle it processes input, update domain then update gui.
     */
    public void gameLoop() {
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
                //checkVictory(); ---> RALLENTA TUTTO
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
        this.stageDomain.getMap().updateBonusTimer(elapsedTime);
        this.entityManager.updateBlinkingMysteryBox(elapsedTime);
        //this.stageDomain.doCycle();
        this.stageDomain.getPlayer().move();
    }

    /**
     * Checks game over conditions then if player loose set {@link GameController#gameState} to {@link GameState#GAMEOVER}.
     */
    private void checkGameoverCondition() {
//        this.gameState = GameState.GAMEOVER; decommenta
        if (this.stageDomain.getPlayer().getLife() <= 0) {
            this.gameState = GameState.GAMEOVER;
            //TODO: save current score and level then show gameover scree
        }
    }

    /**
     * Check condition of victory then set {@link GameController#gameState} if player complete current level.
     */
    private void checkVictory() {
        if (this.stageDomain.getMap().getOccupiedPercentage() > 80) {
            this.gameState = GameState.VICTORY;
        }
    }

    /**
     * Update view of game.
     */
    private void render() {
        getGameViewController().updatePlayerPosition(this.stageDomain.getPlayer().getPosition());
        getGameViewController().updateBossPosition(this.stageDomain.getBoss().getPosition());
        //TODO: fare anche con i mosquitoes
    }

    /**
     * Put game in pause then show a dialog to ask if user wants stop playing and go back to main menu.
     * The response is received by the method {{@link #notifyDialogAnswer(ConfirmOption)}} of interface
     * {@link DialogAnswerObserver} and resume or go home depending on response.
     */
    public void closeGame() {
        this.gameState = GameState.QUITTING;
        ConfirmView confirmView = ConfirmView.newConfirmDialogView();
        DialogConfirmController dialogConfirmController =
                new DialogConfirmController(confirmView, this.getViewManager(), this);
        confirmView.setIoLogicController(dialogConfirmController);
        //launch confirmation dialog
        this.getViewManager().addScene(confirmView);
        //the response is communicated through method notifyDialogAnswer
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
     * Resume gameplay setting {@link GameController#gameState} to {@link GameState#PLAYING},
     * removing pause view and starting {@linkplain GameController#gameLoop()}
     */
    private void resumeGame() {
        System.out.println("RESUME");
        this.gameState = GameState.PLAYING;
        this.getViewManager().popScene();
        this.gameLoop();
    }

    /**
     * Show game-over view.
     */
    private void gameOver() {
        System.out.println("GAMEOVER");
        //TODO: add viewcontroller tipe in OPtional<View<T>>
        CountdownView<GameOverViewController> gameOverView = ViewFactory.gameOverView();
        gameOverView.setIoLogicController(this);
        showTimedView(gameOverView, WAITING_TIME);
    }

    /**
     *  Show victory view then load next level domain.
     */
    private void victory() {
        System.out.println("Player WIN: go to next level");
        //TODO: show screen for 5 sec then pass to new level
        //this.showView();
        this.stageDomain.createNextLevel();
        //showTimedView(gameOverView, WAITING_TIME);
    }

    private void showTimedView(final CountdownView view, final int duration) {
        this.showView(view);
        new Thread(() -> {
            int i = duration;
            while (i > 0) {
                i--;
                final int r = i;
                Platform.runLater(() -> view.setCountdown(r));
                ThreadUtils.sleep(1000);
            }
            Platform.runLater(() -> getViewManager().popScene());
        }).start();
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
        this.movementQueue.add(pl -> pl.changeDirection(dir));
    }

    @Override
    public void notifyDialogAnswer(final ConfirmOption answer) {
        if (answer == ConfirmOption.CONFIRM) {
            this.getViewManager().backHome();
        } else if (answer == ConfirmOption.DENY) {
            this.getViewManager().popScene();
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
