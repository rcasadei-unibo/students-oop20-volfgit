package vg.core;

enum GameState{
    PLAYING, //playing game
    PAUSED, //playing level but paused
    STOPPED, //not playing level
}

/**
 * Game Engine class, manager game loop and refresh timing
 * during gameplay
 * */
public class GameEngine {
    //TODO: save object model and view
    //private model object
    //private view object
    private long period = 20; // frequencies = 1/period
    private GameState gameState = GameState.STOPPED;

    public void setup(){
        //TODO: init model and view in GameEngine.setup()
        //init model
        //init view
    }

    public void gameLoop(){
        long prevCycleTime = System.currentTimeMillis();
        //TODO: it has to be always true ?
        while(gameState != GameState.STOPPED || gameState != GameState.PAUSED){
            long curCycleTime = System.currentTimeMillis();
            long elapsedTime = curCycleTime - prevCycleTime;
            processInput();

            updateGame(elapsedTime);
            render();
            waitForNextFrame(curCycleTime);
            prevCycleTime = curCycleTime;
        }
    }


    private void updateGame(long elapsedTime) {
        //TODO: call update method of model
        //world.update(elapsedTime);
    }

    private void processInput() {
        //TODO: process keyboard input
        System.out.println("Process input");
    }

    private void render() {
        //view.render();
        System.out.println("render gui ");
    }

    private void waitForNextFrame(long elapsedTime){
        long dt = System.currentTimeMillis() - elapsedTime;
        if (dt < period) {
            try {
                Thread.sleep(period-dt);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
                //TODO: how to handle that exception?
            }
        }
    }
}
