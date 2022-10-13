package vg.controller;

import javafx.scene.input.KeyCode;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class KeySettings {
    /**
     * The map the associates an action to a key.
     */
    public final Map<KeyCode, KeyAction> currentSettings;

    private KeySettings(Map<KeyCode, KeyAction> settings) {
        this.currentSettings = settings;
    }
    public static KeySettings defaultKeyEventImpl() {
        Map<KeyCode, KeyAction> settings = new HashMap<KeyCode, KeyAction>();
        Stream.of(KeyAction.values()).forEach(e -> settings.put(KeyCode.valueOf(e.toString()), e));
        return new KeySettings(settings);
    }

    public static KeySettings fromSettingsKeyEventImpl(final Map<KeyCode, KeyAction> settings) {
        return new KeySettings(settings);
    }
}