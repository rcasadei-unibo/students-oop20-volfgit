package vg.view;


import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import vg.controller.Controller;
import vg.view.utils.KeyAction;

public interface View {

    Controller getController();
    void setController(Controller controller);
    Scene getScene();

    void draw();
    void reset();
}
