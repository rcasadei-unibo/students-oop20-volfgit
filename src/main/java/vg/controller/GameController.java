package vg.controller;

import javafx.scene.input.KeyCode;
import vg.utils.Command;
import vg.model.Stage;
import vg.model.entity.dynamicEntity.player.Player;
import vg.utils.Direction;
import vg.view.AdaptableView;

import java.util.ArrayList;
import java.util.List;

/**
 * Game Engine class, manager game loop and refresh timing
 * during gameplay
 * */
public class GameController<T>  {
    private List<Command<Player>> movementQueue;
    private static final long CYCLE_PERIOD = 500; // frequencies = 1/period
    private boolean gameLoopIsRunning = true;

    private Stage<T> stage;
    private AdaptableView view;
    private KeyEventHandler keyEventSettings;

    /**
     * Setup view, keyEvent and domain.
     * @param view game map view
     * @param keyEventSettings keyboard key-action mapper
     * @param stage Model of game
     */

    public void setup(final AdaptableView view, final KeyEventHandler keyEventSettings, final Stage<T> stage) {
        this.movementQueue = new ArrayList<>();
        this.stage = stage;
        this.keyEventSettings = keyEventSettings;
        this.view = view;
    }

    /**
     * Loop to make game running. At every cycle it processes input, update domain then update gui.
     */
    public void gameLoop() {
        long prevCycleTime = System.currentTimeMillis();

        while (gameLoopIsRunning) {
            long curCycleTime = System.currentTimeMillis();
            long elapsedTime = curCycleTime - prevCycleTime;
            processInput();

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
        this.stage.getMap().updateBonusTimer(elapsedTime);
        this.stage.doCycle();

        if (this.stage.getPlayer().getLife() <= 0) {
            gameOver();
        }



        //TODO: check if level is end then pass to next level
    }

    private void gameOver() {
        gameLoopIsRunning = false;
        //TODO: show gameover screen
    }

    /**
     * Process command in the head of queue (the older one)
     * in order to move player.
     */
    private void processInput() {

        System.out.println("Processing input: " + this.movementQueue.size());
        if (!this.movementQueue.isEmpty()) {
            Command<Player> cmd = this.movementQueue.get(0);
            this.movementQueue.remove(cmd);
            //set new player direction
            cmd.execute(this.stage.getPlayer());
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
     * Append new player command to the queue.
     * @param cmd command to be executed on player
     */
    private void appendMovementCommand(final Command cmd) {
        this.movementQueue.add(cmd);
    }

    /**
     * Terminate gameLoop and go back to the previous screen.
     */
    private void closeGame() {
        //end game and go back to home
        gameLoopIsRunning = false;
    }

    /**
     * Stop gameLoop and show pause view.
     */
    private void pauseGame() {
        gameLoopIsRunning = true;
        //this.gameState = GameState.PAUSED;
        //TODO: show pause screen
        //this.view = pause view
    }

    /**
     * Restart gameLoop and show again game view.
     */
    private void resumeGame() {
        gameLoopIsRunning = true;
        //TODO: show game view
        //this.view = show game play view
        this.gameLoop();
    }

    public void setView(final AdaptableView view) {
        this.view = view;
    }

    //@Override
    public void notifyKeyEvent(final KeyCode code) {
        switch (code) {
            case UP: appendPlayerCommand(Direction.UP); break;
            case DOWN:  appendPlayerCommand(Direction.DOWN); break;
            case LEFT: appendPlayerCommand(Direction.LEFT); break;
            case RIGHT:  appendPlayerCommand(Direction.RIGHT); break;
            case P:
                //Toggle from pause and playing state
                if (gameLoopIsRunning) {
                    this.pauseGame();
                } else {
                    this.resumeGame();
                }
                break;
            case CANCEL:
            case ENTER:
                break;
            case ESCAPE: this.closeGame(); break;
            default:
        }
        System.out.println(code.getName());
    }

    private void appendPlayerCommand(final Direction dir) {
        this.appendMovementCommand((Command<Player>) pl -> pl.changeDirection(dir));
    }


}
