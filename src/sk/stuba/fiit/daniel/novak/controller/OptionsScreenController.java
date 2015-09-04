package sk.stuba.fiit.daniel.novak.controller;

import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import sk.stuba.fiit.daniel.novak.model.Context;
import sk.stuba.fiit.daniel.novak.model.audio.Music;
import sk.stuba.fiit.daniel.novak.view.screens.MainScreen;
import sk.stuba.fiit.daniel.novak.view.screens.OptionsScreen;

/**
 * Created by Daniel on 3.9.2015.
 */
public class OptionsScreenController {

    private MainScreen mainScreen;


    public OptionsScreenController(Context context, OptionsScreen optionsScreen, Music music) {

        optionsScreen.setOptionsScreenListener(new OptionsScreen.OptionsScreenListener() {
            @Override
            public void onButtonHowToPlay(GridPane gridPane, HBox hBox) {
                optionsScreen.setCenter(gridPane);
                optionsScreen.setTop(hBox);
            }

            @Override
            public void onButtonGameSettings(GridPane gridPane, HBox hBox) {
                optionsScreen.setCenter(gridPane);
                optionsScreen.setTop(hBox);
            }

            @Override
            public void onButtonMusic(GridPane gridPane, HBox hBox) {
                optionsScreen.setCenter(gridPane);
                optionsScreen.setTop(hBox);
            }

            @Override
            public void onButtonBack() {
                mainScreen = new MainScreen(context);
                context.switchScene(mainScreen);
                new MainScreenController(context, mainScreen, music);
            }

            @Override
            public void onButtonChoice(int select, ListView<String> list) {
                select = list.getSelectionModel().getSelectedIndex();

                switch (select) {
                    case 0:
                        music.setSong("/Chopin.mp3");
                        break;
                    case 1:
                        music.setSong("/Darude - Sandstorm.mp3");
                        break;
                    case 2:
                        music.setSong("/Eluveitie - Druid.mp3");
                        break;
                    case 3:
                        music.setSong("/Eminem - Without Me.mp3");
                        break;
                    case 4:
                        music.setSong("/Wintersun - Death and the Healing.mp3");
                        break;
                }
                System.out.println(music.getSong());
            }
        });
    }
}
