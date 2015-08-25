package sk.stuba.fiit.daniel.novak.controller;

import sk.stuba.fiit.daniel.novak.model.Context;
import sk.stuba.fiit.daniel.novak.model.Graphics;
import sk.stuba.fiit.daniel.novak.view.screens.MainScreen;
import sk.stuba.fiit.daniel.novak.view.screens.PlayScreen;

/**
 * Created by Daniel on 10.8.2015.
 */
public class MainScreenController {

    private PlayScreen playScreen;
    private Graphics graphics = new Graphics();

    public MainScreenController(Context context, MainScreen mainScreen) {

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
                new PlayScreenController(graphics, playScreen);
            }
        });
    }

    // Factory method - it's static and creates a new object
    public static void initAndStart(Context context, MainScreen mainScreen) {
        new MainScreenController(context, mainScreen);
    }
}
