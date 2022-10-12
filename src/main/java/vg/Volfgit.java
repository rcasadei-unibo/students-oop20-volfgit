package vg;

import javafx.application.Application;
import vg.core.GameEngine;
import vg.view.gameBoard.GameBoard;


public final class Volfgit {

    private Volfgit() { }

    public static void main(final String[] args) {

        System.out.println("Hello, World!");

        Application.launch(GameBoard.class, args);
        //TODO: mostrare menu principale e sol quando si clicca su "Gioca" o "Play" viene creato il GameEngine
        GameEngine engine = new GameEngine();
        engine.setup();
        engine.gameLoop();
        System.out.println("GameLoop stopped!");

    }
}
