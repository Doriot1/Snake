package sk.stuba.fiit.daniel.novak.controller;

import sk.stuba.fiit.daniel.novak.model.Context;
import sk.stuba.fiit.daniel.novak.model.Graphics;
import sk.stuba.fiit.daniel.novak.model.audio.Music;
import sk.stuba.fiit.daniel.novak.view.screens.MainScreen;
import sk.stuba.fiit.daniel.novak.view.screens.OptionsScreen;
import sk.stuba.fiit.daniel.novak.view.screens.PlayScreen;

/**
 * Created by Daniel on 10.8.2015.
 */
public class MainScreenController {

    private PlayScreen playScreen;
    private OptionsScreen optionsScreen;
    private Graphics graphics;


    public MainScreenController(Context context, MainScreen mainScreen, Music music) {

        graphics = new Graphics();

        mainScreen.setMainScreenListener(new MainScreen.MainScreenListener() {
            @Override
            public void onButtonClose() {
                context.getStage().close();
                System.out.println("Program successfully closed.");
                System.exit(0);
            }

            @Override
            public void onButtonPlay() {
                playScreen = new PlayScreen(context);
                context.switchScene(playScreen);
                playScreen.requestFocus();
                new PlayScreenController(graphics, playScreen, context, music);
            }

            @Override
            public void onButtonOptions() {
                optionsScreen = new OptionsScreen(context);
                context.switchScene(optionsScreen);
                new OptionsScreenController(context, optionsScreen, music);
            }
        });
    }

    // Factory method - it's static and creates a new object
    public static void initAndStart(Context context, MainScreen mainScreen, Music music) {
        new MainScreenController(context, mainScreen, music);
    }
}
