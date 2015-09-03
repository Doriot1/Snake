package sk.stuba.fiit.daniel.novak.view.screens;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import sk.stuba.fiit.daniel.novak.model.Context;
import sk.stuba.fiit.daniel.novak.view.BasicView;

/**
 * GUI for options
 * Created by Daniel on 3.9.2015.
 */
public class OptionsScreen extends BasicView {

    private HBox hBox = new HBox(20);
    private GridPane gridPane1 = new GridPane();
    private GridPane gridPane2 = new GridPane();
    private GridPane gridPane3 = new GridPane();

    private OptionsScreenListener optionsScreenListener;

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;

    private Label label1;


    public OptionsScreen(Context context) {
        super(context);
        init();
        add();

        grid.setGridLinesVisible(false);
        setTop(hBox);
    }

    private void init() {
        button1 = new Button("How to play");
        button2 = new Button("Game Settings");
        button3 = new Button("Music");
        button4 = new Button("Back");

        label1 = new Label("\n      Controls: W, A, D, S. For each food eaten score increments by 10.\n      After reaching certain amount of " +
                "points you will be let into next level.\n      Try reaching top place at the leader board. Good luck, snake!\n" +
                "      You can also change the music to suit your style and start from\n      a different level once it's unlocked!");

        hBox.setMargin(button1, new Insets(20));
        hBox.setMargin(button2, new Insets(20));
        hBox.setMargin(button3, new Insets(20));
        hBox.setMargin(button4, new Insets(20));

        button1.setOnAction(e -> optionsScreenListener.onButtonHowToPlay(gridPane1, hBox));
        button2.setOnAction(e -> optionsScreenListener.onButtonGameSettings(gridPane2, hBox));
        button3.setOnAction(e -> optionsScreenListener.onButtonMusic(gridPane3, hBox));
        button4.setOnAction(e -> optionsScreenListener.onButtonBack());
    }

    private void add() {
        hBox.getChildren().addAll(button1, button2, button3, button4);
        gridPane1.add(label1, 1, 1);
    }

    public void setOptionsScreenListener(OptionsScreenListener optionsScreenListener) {
        this.optionsScreenListener = optionsScreenListener;
    }

    public interface OptionsScreenListener {
        void onButtonHowToPlay(GridPane gridPane, HBox hBox);

        void onButtonGameSettings(GridPane gridPane, HBox hBox);

        void onButtonMusic(GridPane gridPane, HBox hBox);

        void onButtonBack();
    }
}
