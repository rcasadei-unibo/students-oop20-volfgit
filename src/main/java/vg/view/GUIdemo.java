package vg.view;

import vg.input.CommandInvoker;

import javax.swing.JPanel;

public class GUIdemo {

    /**
     * Every time that key is typed and is valid, the player movement
     * associated to the key is sent to CommandInvoker (Gameloop for now).
     * */
    private CommandInvoker cmdInvoker;
    private KeyListenerJPanel panel;

    GUIdemo(final CommandInvoker cmdInvoker) {
        this.cmdInvoker = cmdInvoker;
        this.panel = new KeyListenerJPanel(cmdInvoker);
    }

}
