package sk.stuba.fiit.daniel.novak.view.screens;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import sk.stuba.fiit.daniel.novak.model.Context;
import sk.stuba.fiit.daniel.novak.view.BasicView;

/**
 * GUI for options
 * Created by Daniel on 3.9.2015.
 */
public class OptionsScreen extends BasicView {

    private HBox hBox = new HBox(20);

    private OptionsScreenListener optionsScreenListener;

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;


    public OptionsScreen(Context context) {
        super(context);
        init();
        add();

        setCenter(grid);
        setTop(hBox);
    }

    private void init() {
        button1 = new Button("How to play");
        button2 = new Button("Game Settings");
        button3 = new Button("Music");
        button4 = new Button("Back");

        hBox.setMargin(button1, new Insets(20));
        hBox.setMargin(button2, new Insets(20));
        hBox.setMargin(button3, new Insets(20));
        hBox.setMargin(button4, new Insets(20));

        button1.setOnAction(e -> optionsScreenListener.onButtonHowToPlay());
        button2.setOnAction(e -> optionsScreenListener.onButtonGameSettings());
        button3.setOnAction(e -> optionsScreenListener.onButtonMusic());
        button4.setOnAction(e -> optionsScreenListener.onButtonBack());
    }

    private void add() {
        hBox.getChildren().addAll(button1, button2, button3, button4);
    }

    public void setOptionsScreenListener(OptionsScreenListener optionsScreenListener) {
        this.optionsScreenListener = optionsScreenListener;
    }

    public interface OptionsScreenListener {
        void onButtonHowToPlay();
        void onButtonGameSettings();
        void onButtonMusic();
        void onButtonBack();
    }
}
