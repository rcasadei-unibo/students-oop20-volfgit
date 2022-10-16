package vg.controller;


import javafx.application.Platform;
import vg.utils.Command;
import vg.model.Stage;
import vg.model.entity.dynamicEntity.player.Player;
import vg.utils.Direction;
import vg.view.AdaptableView;
import vg.view.SceneController;
import vg.view.ViewManager;
import vg.view.utils.KeyAction;

import java.util.ArrayList;
import java.util.List;

/**
 * Game Engine class, manager game loop and refresh timing
 * during gameplay
 * */
public class GameController<T> extends Controller implements SceneController {
    /**
     * Command queue of new player's movement got from input to be applied.
     */
    private List<Command<Player>> movementQueue;
    /**
     * Period of each frame.
     */
    private static final long CYCLE_PERIOD = 500; // frequencies = 1/period
    /**
     * Terminating condition of game loop.
     */
    private boolean gameLoopIsRunning = true;
    /**
     * Game domain.
     */
    private Stage<T> stageDomain;

    public GameController(final Stage<T> stage, AdaptableView view, ViewManager viewManager) {
        super(view, viewManager);
        this.movementQueue = new ArrayList<>();
        this.stageDomain = stage;
    }

    /**
     * Loop to make game running. At every cycle it processes input, update domain then update gui.
     */
    public void gameLoop() {
        long prevCycleTime = System.currentTimeMillis();
        System.out.println("gameLoop Is FX Thread" + Platform.isFxApplicationThread());
        while (gameLoopIsRunning) {
            long curCycleTime = System.currentTimeMillis();
            long elapsedTime = curCycleTime - prevCycleTime;
            processInput();
            System.out.println("loop");
            updateGameDomain(elapsedTime);
            render();

            waitForNextFrame(curCycleTime);
            prevCycleTime = curCycleTime;
        }
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
        gameLoopIsRunning = false;
        //TODO: show gameover screen
        //this.viewManager.addScene(gameOverSceneView);
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
            cmd.execute(this.stageDomain.getPlayer());
        }
    }

    /**
     * Update view of game.
     */
    private void render() {
        //TODO: call method refresh on view object passing domain
        //this.view.refresh();
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
     * Terminate gameLoop and go back to the previous screen.
     */
    private void closeGame() {
        gameLoopIsRunning = false;
       this.getViewManager().backHome();
    }

    /**
     * Stop gameLoop and show pause view.
     */
    private void pauseGame() {
        gameLoopIsRunning = true;
        //TODO: show pause screen
        //this.viewManager.addScene();
    }

    /**
     * Restart gameLoop and show again game view.
     */
    private void resumeGame() {
        gameLoopIsRunning = true;
        this.getViewManager().popScene();
        this.gameLoop();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void keyTapped(final KeyAction action) {
        switch (action) {
            case P:
                //Toggle from pause and playing state
                if (gameLoopIsRunning) {
                    this.pauseGame();
                } else {
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void keyReleased(final KeyAction k) {
        if (k == KeyAction.DOWN || k == KeyAction.UP || k == KeyAction.LEFT || k == KeyAction.RIGHT) {
            appendPlayerCommand(Direction.NONE);
        }
    }

}
