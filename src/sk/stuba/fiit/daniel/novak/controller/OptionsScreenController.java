package sk.stuba.fiit.daniel.novak.controller;

import sk.stuba.fiit.daniel.novak.model.Context;
import sk.stuba.fiit.daniel.novak.view.screens.OptionsScreen;

/**
 * Created by Daniel on 3.9.2015.
 */
public class OptionsScreenController {

    public OptionsScreenController(Context context, OptionsScreen optionsScreen){

        optionsScreen.setOptionsScreenListener(new OptionsScreen.OptionsScreenListener() {
            @Override
            public void onButtonHowToPlay() {

            }

            @Override
            public void onButtonGameSettings() {

            }

            @Override
            public void onButtonMusic() {

            }

            @Override
            public void onButtonBack() {

            }
        });
    }
}
