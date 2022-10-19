package vg.controller;

import javafx.application.Platform;
import vg.controller.gameBoard.GameBoardController;
import vg.model.Boss.BossImpl;
import vg.model.MapImpl;
import vg.model.StageImpl;
import vg.model.entity.dynamicEntity.enemy.Boss;
import vg.model.entity.dynamicEntity.enemy.Mosquitoes;
import vg.model.entity.dynamicEntity.player.BasePlayer;
import vg.model.Stage;
import vg.model.entity.dynamicEntity.player.Player;
import vg.utils.Command;
import vg.utils.Direction;
import vg.utils.GameState;
import vg.utils.MassTier;
import vg.utils.Shape;
import vg.utils.V2D;
import vg.view.AdaptableView;
import vg.view.SceneController;
import vg.view.View;
import vg.view.ViewManager;
import vg.view.ViewFactory;
import vg.view.menu.confirmMenu.ConfirmOption;
import vg.view.menu.confirmMenu.ConfirmView;
import vg.view.menu.confirmMenu.DialogConfirmController;
import vg.view.menu.confirmMenu.DialogAnswerObserver;
import vg.view.utils.KeyAction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Game Engine class, manager game loop and refresh timing
 * during gameplay
 * */
public class GameController extends Controller implements SceneController, DialogAnswerObserver {
    /**
     * Command queue of new player's movement got from input to be applied.
     */
    private List<Command<Player>> movementQueue;
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


    public GameController(final AdaptableView<GameBoardController> view, final ViewManager viewManager) {
        super(view, viewManager);
        this.movementQueue = new ArrayList<>();
        try {
            this.stageDomain = loadStageModel();
        } catch (Exception e) {

        }

        this.getGameViewController()
                .initMapView(
                        this.stageDomain.getPlayer().getPosition(),
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

        new Thread(() -> {
            //System.out.println("gameloop THREAD");
            long prevCycleTime = System.currentTimeMillis();
            //System.out.println("gameLoop Is FX Thread" + Platform.isFxApplicationThread());
            this.stageDomain.getPlayer().enableSpeedUp(new V2D(5,5));
            while (gameState == GameState.PLAYING) {
                long curCycleTime = System.currentTimeMillis();
                long elapsedTime = curCycleTime - prevCycleTime;
                this.processInput();

                updateGameDomain(elapsedTime);
                render();
                waitForNextFrame(curCycleTime);
                prevCycleTime = curCycleTime;
            }
        }).start();
    }

    /**
     * Update game domain: entities position, bonuses and borders.
     * @param elapsedTime time elapsed between current and previous gameLoop cycle
     */
    private void updateGameDomain(final long elapsedTime) {
        this.stageDomain.getMap().updateBonusTimer(elapsedTime);
        //this.stageDomain.doCycle();
        this.stageDomain.getPlayer().move();

        if (this.stageDomain.getPlayer().getLife() <= 0) {
            this.gameState = GameState.GAMEOVER;
            //TODO: save current score and level then show gameover scree
            Platform.runLater(this::gameOver);
        }

        //TODO: check if level is end then pass to next level
        //TODO: show screen for 5 sec then pass to new level
        //this.stageDomain.createNextLevel();
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
     * Update view of game.
     */
    private void render() {
        getGameViewController().updatePlayerPosition(this.stageDomain.getPlayer().getPosition());
        getGameViewController().updateBossPosition(this.stageDomain.getBoss().getPosition());
        System.out.println(this.stageDomain.getPlayer().getPosition());
    }

    private GameBoardController getGameViewController() {
        return ((GameBoardController) this.getView().getViewController());
    }

    /**
     * Method to keep fixed time of each loop cycle,
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
     * Append command to change player direction at the movementQueue.
     * @param dir new direction of player to be set
     */
    private void appendPlayerCommand(final Direction dir) {
        this.movementQueue.add(pl -> pl.changeDirection(dir));
    }

    /**
     * Terminate gameLoop then show a dialog to ask if user wants stop playing and go back to main menu.
     * The response is received by the method {{@link #notifyDialogAnswer(ConfirmOption)}} of interface
     * {@link DialogAnswerObserver}.
     */
    public void closeGame() {
        System.out.println("close game");
        this.gameState = GameState.STOPPED;
        ConfirmView confirmView = ConfirmView.newConfirmDialogView();
        DialogConfirmController dialogConfirmController =
                new DialogConfirmController(confirmView, this.getViewManager(), this);
        confirmView.setIoLogicController(dialogConfirmController);
        //launch confirmation dialog
        this.getViewManager().addScene(confirmView);
        //the response is communicated through method notifyDialogAnswer
    }

    @Override
    public void notifyDialogAnswer(final ConfirmOption answer) {
        if (answer == ConfirmOption.CONFIRM) {
            this.getViewManager().backHome();
        } else if (answer == ConfirmOption.DENY) {
            this.getViewManager().popScene();
            System.out.println(this.gameState.name()); //STOOPED
            //TODO: fix-> put in pause, escape tha game then deny quitting
            // screen is in pause but gameloop is running
            if (gameState == GameState.PAUSED) {
                this.getViewManager().popScene();
            } else {
                this.gameState = GameState.PLAYING;
                this.gameLoop();
            }
        }
    }

    /**
     * Stop gameLoop and show pause view.
     */
    private void pauseGame() {
        System.out.println("PAUSE");
        this.gameState = GameState.PAUSED;
        Optional<View> pauseView = ViewFactory.viewState(this.gameState);
        pauseView.ifPresent(this::showView);
    }

    /**
     * Restart gameLoop and show again game view.
     */
    private void resumeGame() {
        System.out.println("RESUME");
        this.gameState = GameState.PLAYING;
        this.getViewManager().popScene();
        this.gameLoop();
    }

    /**
     * gameOver state, stop running game loop then show gameOver screen view.
     */
    private void gameOver() {
        System.out.println("GAMEOVER");
        this.gameState = GameState.GAMEOVER;
        Optional<View> gameOverView = ViewFactory.viewState(GameState.GAMEOVER);
        gameOverView.ifPresent(this::showView);
    }

    private void showView(final View view) {
        view.setIoLogicController(this);
        this.getViewManager().addScene(view);
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
                        this.pauseGame();
                    } else if (gameState == GameState.PAUSED) {
                        this.resumeGame();
                    }
                    break;
                case ENTER:
                    break;
                case ESCAPE: this.closeGame(); break;
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
