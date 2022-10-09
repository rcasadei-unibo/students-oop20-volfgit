package vg.controller;

import javafx.scene.input.KeyCode;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public final class KeyEventImpl implements KeyEvent {
    /**
     * The map the associates an action to a key.
     */
    private final Map<KeyCode, KeyAction> currentSettings;
    private KeyEventImpl(final Map<KeyCode, KeyAction> settings) {
        this.currentSettings = settings;
    }
    public KeyEventImpl defaultKeyEventImpl() {
        Map<KeyCode, KeyAction> settings = new HashMap<>();
        Stream.of(KeyAction.values()).forEach(e -> settings.put(KeyCode.valueOf(e.toString()), e));
        return new KeyEventImpl(settings);
    }
    public KeyEventImpl fromSettingsKeyEventImpl(final Map<KeyCode, KeyAction> settings) {
        return new KeyEventImpl(settings);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public KeyAction keyPressed(final KeyCode k) {
        return this.currentSettings.get(k);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public KeyAction keyReleased(final KeyCode k) {
        return null;
    }
}
