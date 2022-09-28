package vg;

import vg.core.GameEngine;

public class Volfgit {
    public static void main(String[] args) {
        GameEngine engine = new GameEngine();
        engine.setup();
        engine.gameLoop();
    }
}
