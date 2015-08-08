package sk.stuba.fiit.daniel.novak.view.screens;

import javafx.geometry.HPos;
import javafx.scene.control.Button;
import sk.stuba.fiit.daniel.novak.model.Context;
import sk.stuba.fiit.daniel.novak.view.BasicView;

/**
 * Created by Daniel on 8.8.2015.
 */
public class MainScreen extends BasicView {

    private Button button;
    private Button button2;
    private Button button3;

    public MainScreen(Context context) {
        super(context);
        init();
        add();
        getStylesheets().add("style.css");

    }

    private void init() {
        grid.setId("pane");
        button = new Button("Play");
        button2 = new Button("Options");
        button3 = new Button("Quit");

        grid.setHalignment(button, HPos.CENTER);
        grid.setHalignment(button2, HPos.CENTER);
        grid.setHalignment(button3, HPos.CENTER);
    }

    private void add() {
        grid.add(button, 3, 2, 3, 1);
        grid.add(button2, 3, 4, 3, 1);
        grid.add(button3, 3, 6, 3, 1);
    }


}
