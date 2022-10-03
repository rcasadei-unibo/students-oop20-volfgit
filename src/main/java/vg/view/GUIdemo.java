package vg.view;

import vg.input.CommandInvoker;
import vg.utils.Direction;

public class GUIdemo {

    /**
     * Every time that key is typed and is valid, the player movement
     * associated to the key is sent to CommandInvoker (Gameloop for now)
     * */
    private CommandInvoker cmdInvoker;

    GUIdemo(final CommandInvoker cmdInvoker) {
        this.cmdInvoker = cmdInvoker;

    }

    /*TODO: Il JPanel del campo di gioco implementa KeyListener, ad ogni evento della tastiera
       ed in base al tasto premuto, comunica al CommandInvoker (gameLoop) il comando del movimento che deve
       fare il player inovcando il metodo appendMovementCommand(Command cmd) che lo aggiunge alla coda
       di comandi da eseguire.
    */
    /*
       Quando il game loop arriva alla fase di gestione degli input, prende il comando piu vecchio dalla coda e ne
       esegue il comando. Il comando richiama il metodo del player move(Direction dir).


       @Override
       void onKeyTyped(Event e) {
            Direction dir = Direction.NONE;
            if (e.getKeyCode() == ) {
                dir = Direction.UP;
            }
            ....
            else if(e.getKeyChar() == "P") {
                this.cmdInvoker.pause();
            }

            this.cmdInvoker.appendMovementCommand( (player) -> {
                    player.move(dir);
                }
            );

            ....ecc...
       }
    */
}
