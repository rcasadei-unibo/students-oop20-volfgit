package vg.core;

import vg.input.Command;
import vg.input.CommandInvoker;
import vg.model.Stage;
import vg.model.entity.dynamicEntity.player.BasePlayer;
import vg.model.entity.dynamicEntity.player.Player;
import vg.utils.GameState;
import vg.utils.V2D;
import vg.view.MainFrame;

import java.util.ArrayList;
import java.util.List;

/**
 * Game Engine class, manager game loop and refresh timing
 * during gameplay
 * */
public class GameEngine implements CommandInvoker {
    //TODO: save object model and view
    private Stage stage;

    //TODO: da rimuovere
    private Player pl = BasePlayer.newPlayer(new V2D(0,0));

    private List<Command<Player>> movementQueue;

    private long period = 500; // frequencies = 1/period
    private GameState gameState = GameState.STOPPED;

    public void setup() {
        //TODO: init model and view in GameEngine.setup()
        this.movementQueue = new ArrayList<>();
    }

    public void gameLoop() {
        long prevCycleTime = System.currentTimeMillis();

        while (gameState != GameState.PAUSED) {
            long curCycleTime = System.currentTimeMillis();
            long elapsedTime = curCycleTime - prevCycleTime;
            processInput();

            updateGame(elapsedTime);
            render();

            waitForNextFrame(curCycleTime);
            prevCycleTime = curCycleTime;
        }

    }


    private void updateGame(final long elapsedTime) {
        //TODO: call update method of model
        //world.update(elapsedTime);
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
            //cmd.execute(this.stage.getPlayer());
            cmd.execute(pl);
        }
    }

    private void render() {

        //System.out.println("render gui: " + pl.getPosition().toString());
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

    public void appendMovementCommand(Command cmd) {
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
}
