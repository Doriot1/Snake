package sk.stuba.fiit.daniel.novak.view.screens;

import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import sk.stuba.fiit.daniel.novak.model.Context;
import sk.stuba.fiit.daniel.novak.view.BasicView;

/**
 * Created by Daniel on 8.8.2015.
 */
public class MainScreen extends BasicView {

    private MainScreenListener mainScreenListener;

    private Button button;
    private Button button2;
    private Button button3;


    public MainScreen(Context context) {
        super(context);
        init();
        add();

    }

    private void init() {
        grid.setId("pane");
        getStylesheets().add("style.css");

        button = new Button("Play");
        button2 = new Button("Options");
        button3 = new Button("Quit");

        grid.setHalignment(button, HPos.CENTER);
        grid.setHalignment(button2, HPos.CENTER);
        grid.setHalignment(button3, HPos.CENTER);

        getContext().getStage().setOnCloseRequest(e -> mainScreenListener.onButtonClose());
        button.setOnAction(e -> mainScreenListener.onButtonPlay());
        button3.setOnAction(e -> mainScreenListener.onButtonClose());
        setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER)
                mainScreenListener.onButtonPlay();
        });


    }


    private void add() {
        grid.add(button, 3, 2, 3, 1);
        grid.add(button2, 3, 4, 3, 1);
        grid.add(button3, 3, 6, 3, 1);
    }

    public void setMainScreenListener(MainScreenListener listener) {
        this.mainScreenListener = listener;
    }

    public interface MainScreenListener {
        void onButtonClose();

        void onButtonPlay();
    }
}
