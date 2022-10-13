package vg.controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


import java.util.Map;

import static javafx.scene.input.KeyEvent.KEY_PRESSED;
import static javafx.scene.input.KeyEvent.KEY_RELEASED;

public final class KeyEventHandler implements EventHandler<KeyEvent> {
    private final KeySettings keySettings = KeySettings.defaultKeySettings();

    /**
     * {@inheritDoc}
     */

    public KeyAction keyPressed(final KeyCode k) {
        return this.keySettings.currentSettings.get(k);
    }

    /**
     * {@inheritDoc}
     */

    public KeyAction keyReleased(final KeyCode k) {
        return null;
    }


    @Override
    public void handle(KeyEvent event) {
       // System.out.println(event);
        if (event.getEventType().equals(KEY_PRESSED)){
           //TODO do this in a non-static way ((StateController) Binder.getController()).activatesEvent(keyPressed(event.getCode()));
            System.out.println("KEY_PRESSED" + ": " + event.getCode());
        } else if (event.getEventType().equals(KEY_RELEASED)){
            System.out.println("KEY_RELEASED" + ": " + event.getCode());
        } else {
            //TODO this is "typed"...........
            System.out.println(event);
        }
    }
}
