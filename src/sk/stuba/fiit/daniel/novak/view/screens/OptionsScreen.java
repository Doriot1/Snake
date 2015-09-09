package sk.stuba.fiit.daniel.novak.view.screens;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
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
    private Button button3_2;

    private Label label1;
    private Label label3;
    private Label label3_2;

    private ListView<String> list;

    private int select = 0;

    private ImageView imageView;


    public OptionsScreen(Context context) {
        super(context);
        init();
        add();

        gridPane3.setGridLinesVisible(false);
        setTop(hBox);
        hBox.setId("fancy2");
    }

    private void init() {
        Image image = new Image("footer-art.png");
        imageView = new ImageView(image);

        button1 = new Button("How to play");
        button2 = new Button("Game Settings");
        button3 = new Button("Music");
        button4 = new Button("Back");
        button3_2 = new Button("Confirm");

        gridPane1.setId("fancyTypo");
        gridPane3.setId("fancyTypo");
        label1 = new Label("\n      Controls: W, A, D, S. For each food eaten score increments by 10.\n      After reaching certain amount of " +
                "points you will be let into next level.\n      Try reaching top place at the leader board. Good luck, snake!\n" +
                "      You can also change the music to suit your style and start from\n      a different level once it's unlocked!");
        label3 = new Label(" Here you can choose music you like, if you don't like any of the music\n listed here, let me know and I'll add something " +
                "to suit your needs.");
        label3_2 = new Label(" Don't forget to confirm your choice by pressing this -->");

        HBox.setMargin(button1, new Insets(20));
        HBox.setMargin(button2, new Insets(20));
        HBox.setMargin(button3, new Insets(20));
        HBox.setMargin(button4, new Insets(20));

        button1.setOnAction(e -> optionsScreenListener.onButtonHowToPlay(gridPane1, hBox));
        button2.setOnAction(e -> optionsScreenListener.onButtonGameSettings(gridPane2, hBox));
        button3.setOnAction(e -> optionsScreenListener.onButtonMusic(gridPane3, hBox));
        button4.setOnAction(e -> optionsScreenListener.onButtonBack());
        button3_2.setOnAction(e -> optionsScreenListener.onButtonChoice(select, list));

        ObservableList<String> list2 = FXCollections.observableArrayList("Chopin - Rain Drop", "Darude - Sandstorm", "Eluveitie - DRUID",
                "Eminem - Without me", "Wintersun - Death & the Healing");
        list = new ListView<>(list2);

        for (int i = 0; i < 10; i++) {
            gridPane3.getColumnConstraints().add(new ColumnConstraints(94));
            gridPane3.getRowConstraints().add(new RowConstraints(44));
        }
    }

    private void add() {
        hBox.getChildren().addAll(button1, button2, button3, button4);
        gridPane1.add(label1, 1, 1);
        gridPane3.add(label3, 0, 1, 5, 1);
        gridPane3.add(label3_2, 0, 5, 4, 1);
        gridPane3.add(button3_2, 3, 5, 2, 1);
        GridPane.setHalignment(button3_2, HPos.RIGHT);
        gridPane3.add(list, 3, 2, 2, 3);
        gridPane3.add(imageView, 0, 7, 2, 3);
    }

    public void setOptionsScreenListener(OptionsScreenListener optionsScreenListener) {
        this.optionsScreenListener = optionsScreenListener;
    }

    public interface OptionsScreenListener {
        void onButtonHowToPlay(GridPane gridPane, HBox hBox);

        void onButtonGameSettings(GridPane gridPane, HBox hBox);

        void onButtonMusic(GridPane gridPane, HBox hBox);

        void onButtonBack();

        void onButtonChoice(int select, ListView<String> list);
    }
}
