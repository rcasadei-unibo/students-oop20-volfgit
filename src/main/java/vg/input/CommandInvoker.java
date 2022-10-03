package vg.input;

public interface CommandInvoker {
    /**
     * Append command to queue of execution of GameLoop
     * @param cmd Command to be appended in execution input queue of GameLoop
     * */
    <T> void appendMovementCommand(Command<T> cmd);
    /**
     * Set gameLoop state to PAUSE
     * */
    void pauseGame();
}
