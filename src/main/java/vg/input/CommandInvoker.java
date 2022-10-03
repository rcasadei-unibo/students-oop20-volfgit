package vg.input;

public interface CommandInvoker {

    void appendMovementCommand(Command cmd);

    void pauseGame();
}
