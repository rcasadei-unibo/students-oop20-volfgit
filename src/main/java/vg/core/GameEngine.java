package vg.core;

import javafx.scene.input.KeyCode;
import vg.controller.KeyAction;
import vg.controller.KeyEventImpl;
import vg.controller.StateController;
import vg.controller.StateType;
import vg.input.Command;
import vg.input.CommandInvoker;
import vg.model.Map;
import vg.model.Stage;
import vg.model.StageImpl;
import vg.model.entity.dynamicEntity.player.Player;
import vg.utils.Direction;
import vg.utils.GameState;
import vg.utils.V2D;
import vg.view.AdaptableView;

import java.util.ArrayList;
import java.util.List;

/**
 * Game Engine class, manager game loop and refresh timing
 * during gameplay
 * */
public class GameEngine implements CommandInvoker, StateController<AdaptableView> {
    private List<Command<Player>> movementQueue;
    private long period = 500; // frequencies = 1/period
    private GameState gameState = GameState.STOPPED;

    private Stage stage;
    private AdaptableView view;
    private KeyEventImpl keyEventSettings;

    public void setup(final AdaptableView view, final KeyEventImpl keyEventSettings, final Map<V2D> map) {
        this.movementQueue = new ArrayList<>();
        this.stage = new StageImpl(0, map);
        this.keyEventSettings = keyEventSettings;
        this.view = view;
    }

    public void gameLoop() {
        long prevCycleTime = System.currentTimeMillis();

        while (gameState != GameState.PAUSED) {
            long curCycleTime = System.currentTimeMillis();
            long elapsedTime = curCycleTime - prevCycleTime;
            processInput();

            updateGameDomain(elapsedTime);
            render();

            waitForNextFrame(curCycleTime);
            prevCycleTime = curCycleTime;
        }

    }

    private void updateGameDomain(final long elapsedTime) {
        this.stage.getMap().updateBonusTimer(elapsedTime);
        this.stage.moveAll();
    }

    /**
     * Process command in the head of queue (the older one)
     * in order to move player.
     * */
    private void processInput() {

        System.out.println("Processing input: " + this.movementQueue.size());
        if (!this.movementQueue.isEmpty()) {
            Command<Player> cmd = this.movementQueue.get(0);
            this.movementQueue.remove(cmd);
            //set new player direction
            cmd.execute(this.stage.getPlayer());
        }
    }

    private void render() {
        //TODO: call method refresh on view object
        //this.view.refresh();
    }

    private void waitForNextFrame(final long elapsedTime) {
        long dt = System.currentTimeMillis() - elapsedTime;
        if (dt < period) {
            try {
                Thread.sleep(period - dt);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void appendMovementCommand(final Command cmd) {
        this.movementQueue.add(cmd);
    }

    @Override
    public void pauseGame() {
        this.gameState = GameState.PAUSED;
    }

    @Override
    public void resumeGame() {
        this.gameState = GameState.PLAYING;
    }

    @Override
    public AdaptableView getView() {
        //if gamestate is paused --> pause screen
        //else game is running --> show game screen
        return this.view;
    }

    @Override
    public void setView(final AdaptableView view) {
        this.view = view;
    }

    @Override
    public KeyAction captureKeyEvent(final KeyCode key) {
        return getKeyEventSettings().keyPressed(key);
    }

    @Override
    public void activatesEvent(final KeyAction e) {
        Direction dir;
        switch (e) {
            case UP: dir = Direction.UP; break;
            case DOWN: dir = Direction.DOWN; break;
            case LEFT: dir = Direction.LEFT; break;
            case RIGHT: dir = Direction.RIGHT; break;
            case P: this.pauseGame();
            default: dir = Direction.NONE;
        }

        this.appendMovementCommand((Command<Player>) pl -> pl.changeDirection(dir));
    }

    @Override
    public void activatesEvent(StateType e) {

    }

    @Override
    public KeyEventImpl getKeyEventSettings() {
        return this.keyEventSettings;
    }

    @Override
    public void setKeyEventSettings(final KeyEventImpl keyEventSettings) {
        this.keyEventSettings = keyEventSettings;
    }
}
