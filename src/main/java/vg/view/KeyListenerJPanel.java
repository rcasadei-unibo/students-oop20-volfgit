package vg.view;

import vg.input.CommandInvoker;
import vg.model.entity.dynamicEntity.player.Player;
import vg.utils.Direction;

import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListenerJPanel extends JPanel implements KeyListener {
    /**
     * Class that calls action method of command (Pattern Command) and react to key event.
     */
    private final CommandInvoker cmdInvoker;

    KeyListenerJPanel(final CommandInvoker cmdInvoker) {
        this.cmdInvoker = cmdInvoker;
    }

    @Override
    public void keyTyped(final KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_P) {
            this.cmdInvoker.pauseGame();
        } else {
            Direction dir;
            switch (code) {
                case KeyEvent.VK_LEFT: dir = Direction.LEFT; break; //37
                case KeyEvent.VK_UP: dir = Direction.UP; break; //38
                case KeyEvent.VK_RIGHT: dir = Direction.RIGHT; break; //39
                case KeyEvent.VK_DOWN: dir = Direction.DOWN; break; //40

                default: dir = Direction.NONE;
            }

            //send action to gameLoop in order to append it to queue of command to be executed
            this.cmdInvoker.appendMovementCommand((Player player) -> {
                player.move(dir);
            });
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
