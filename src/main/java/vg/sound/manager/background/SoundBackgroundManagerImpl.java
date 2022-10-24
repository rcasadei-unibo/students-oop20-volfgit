package vg.sound.manager.background;

import vg.sound.Sound;
import vg.sound.factory.StaticFactorySoundBackground;
import vg.sound.manager.ESoundBackground;

import java.util.HashMap;
import java.util.Map;

public class SoundBackgroundManagerImpl implements SoundBackgroundManager {
    private final Map<ESoundBackground, Sound> mapEffect;
    public SoundBackgroundManagerImpl() {
        this.mapEffect = new HashMap<>();
        this.mapEffect.put(ESoundBackground.START, StaticFactorySoundBackground.createStart());
    }

    @Override
    public void play(final ESoundBackground effect) {
        this.mapEffect.get(effect).play();
    }
}
