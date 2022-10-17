package vg.controller;


import javafx.application.Platform;
import vg.model.Boss.BossImpl;
import vg.model.MapImpl;
import vg.model.StageImpl;
import vg.model.entity.dynamicEntity.enemy.Boss;
import vg.model.entity.dynamicEntity.player.BasePlayer;
import vg.utils.*;
import vg.model.Stage;
import vg.model.entity.dynamicEntity.player.Player;
import vg.view.AdaptableView;
import vg.view.SceneController;
import vg.view.ViewManager;
import vg.view.utils.KeyAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Game Engine class, manager game loop and refresh timing
 * during gameplay
 * */
public class GameController extends Controller implements SceneController {
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

    public GameController(AdaptableView view, ViewManager viewManager) {
        super(view, viewManager);
        this.movementQueue = new ArrayList<>();
        this.stageDomain = loadStageModel();
    }

    private Stage<V2D> loadStageModel() {
        Boss boss =  new BossImpl(
                new V2D(1,1),
                new V2D(4,4),
                3,
                Shape.CIRCLE,
                MassTier.HIGH);

        Stage stage =  new StageImpl<V2D>(0, new MapImpl(
                BasePlayer.newPlayer(new V2D(0, 0)),
                boss,
                Set.of(),
                Set.of(),
                Set.of(),
                Set.of()
        ));
        return stage;
    }

    /**
     * Loop to make game running. At every cycle it processes input, update domain then update gui.
     */
    public void gameLoop() {

        new Thread(() -> {
            System.out.println("gameloop THREAD");
            long prevCycleTime = System.currentTimeMillis();
            //System.out.println("gameLoop Is FX Thread" + Platform.isFxApplicationThread());
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
        //this.stage.doCycle();
        this.stageDomain.getPlayer().move();

        if (this.stageDomain.getPlayer().getLife() <= 0) {
            gameOver();
        }

        //TODO: check if level is end then pass to next level
    }

    /**
     * gameOver state, stop running game loop then show gameOver screen view.
     */
    private void gameOver() {
        gameState = GameState.STOPPED;
        System.out.println("GAMEOVER");
        //TODO: show gameover screen
        //this.getViewManager().addScene();
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
        //TODO: call method refresh on view object passing domain
        //this.view.refresh();
        System.out.println(this.stageDomain.getPlayer().getPosition());
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
     * Terminate gameLoop thread and go back to the previous screen.
     */
    public void closeGame() {
        System.out.println("close game");
        this.gameState = GameState.STOPPED;
        //this.getViewManager().backHome();
    }

    /**
     * Stop gameLoop and show pause view.
     */
    private void pauseGame() {
        System.out.println("PAUSE game");
        this.gameState = GameState.PAUSED;
        //this.viewManager.addScene();
    }

    /**
     * Restart gameLoop and show again game view.
     */
    private void resumeGame() {
        System.out.println("RESUME game");
        this.gameState = GameState.PLAYING;
        //this.getViewManager().popScene();
        this.gameLoop();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void keyTapped(final KeyAction action) {
        //TODO: find out why these type of event are not seen
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
    }

}
