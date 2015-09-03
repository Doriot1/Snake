package sk.stuba.fiit.daniel.novak.controller;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import sk.stuba.fiit.daniel.novak.model.Context;
import sk.stuba.fiit.daniel.novak.view.screens.MainScreen;
import sk.stuba.fiit.daniel.novak.view.screens.OptionsScreen;

/**
 * Created by Daniel on 3.9.2015.
 */
public class OptionsScreenController {

    private MainScreen mainScreen;


    public OptionsScreenController(Context context, OptionsScreen optionsScreen) {

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
                new MainScreenController(context, mainScreen);
            }
        });
    }
}
