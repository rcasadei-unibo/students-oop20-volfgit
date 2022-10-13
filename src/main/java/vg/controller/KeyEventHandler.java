package vg.controller;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static javafx.scene.input.KeyEvent.KEY_PRESSED;

public final class KeyEventHandler implements EventHandler<KeyEvent> {
    /**
     * The map the associates an action to a key.
     */
    private final Map<KeyCode, KeyAction> currentSettings;
    private KeyEventHandler(final Map<KeyCode, KeyAction> settings) {
        this.currentSettings = settings;
    }
    public static KeyEventHandler defaultKeyEventImpl() {
        Map<KeyCode, KeyAction> settings = new HashMap<>();
        Stream.of(KeyAction.values()).forEach(e -> settings.put(KeyCode.valueOf(e.toString()), e));
        return new KeyEventHandler(settings);
    }
    public KeyEventHandler fromSettingsKeyEventImpl(final Map<KeyCode, KeyAction> settings) {
        return new KeyEventHandler(settings);
    }
    /**
     * {@inheritDoc}
     */

    public KeyAction keyPressed(final KeyCode k) {
        return this.currentSettings.get(k);
    }

    /**
     * {@inheritDoc}
     */

    public KeyAction keyReleased(final KeyCode k) {
        return null;
    }


    @Override
    public void handle(KeyEvent event) {

        if (event.getEventType().equals(KEY_PRESSED)){
           //TODO do this in a non-static way ((StateController) Binder.getController()).activatesEvent(keyPressed(event.getCode()));
            System.out.println("KEY_PRESSED" + ": " + event.getCode());
        } else {
            System.out.println("KEY_RELEASED" + ": " + event.getCode());
        }
    }
}
