package sk.stuba.fiit.daniel.novak.controller;

import sk.stuba.fiit.daniel.novak.model.Context;
import sk.stuba.fiit.daniel.novak.view.screens.MainScreen;
import sk.stuba.fiit.daniel.novak.view.screens.PlayScreen;

/**
 * Created by Daniel on 10.8.2015.
 */
public class MainScreenController {
    private Context context;
    private MainScreen mainScreen;

    public MainScreenController(Context context, MainScreen mainScreen) {
        this.context = context;
        this.mainScreen = mainScreen;

        mainScreen.setMainScreenListener(new MainScreen.MainScreenListener() {
            @Override
            public void onButtonClose() {
                context.getStage().close();
                System.out.println("Program successfully closed.");
            }

            @Override
            public void onButtonPlay() {
                context.switchScene(new PlayScreen(context));
            }
        });
    }

}
