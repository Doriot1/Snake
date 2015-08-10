package sk.stuba.fiit.daniel.novak.controller;

import javafx.application.Platform;
import sk.stuba.fiit.daniel.novak.model.Context;
import sk.stuba.fiit.daniel.novak.model.Snake;
import sk.stuba.fiit.daniel.novak.view.screens.MainScreen;
import sk.stuba.fiit.daniel.novak.view.screens.PlayScreen;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Daniel on 10.8.2015.
 */
public class MainScreenController {
    private Context context;
    private MainScreen mainScreen;
    private Timer timer = new Timer();

    public MainScreenController(Context context, MainScreen mainScreen, Snake snake) {
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
                timer.scheduleAtFixedRate(new TimerTask() {

                    @Override
                    public void run() {
                        Platform.runLater(() -> {
                            if (snake.isAlive()) {
                                System.out.println("nieco");
                            } else
                                System.out.println("I am dead");

                        });
                    }
                }, 0L, 100L);
            }
        });
    }


}
