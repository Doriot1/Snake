package sk.stuba.fiit.daniel.novak.controller;

import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import sk.stuba.fiit.daniel.novak.model.GamePlay;
import sk.stuba.fiit.daniel.novak.model.Snake;
import sk.stuba.fiit.daniel.novak.view.screens.PlayScreen;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Daniel on 10.8.2015.
 */
public class PlayScreenController {
    private Timer timer = new Timer();

    private Snake snake;

    public PlayScreenController(GamePlay gamePlay, PlayScreen playScreen) {

        snake = new Snake();

        playScreen.setPlayScreenListener(keyCode -> {
            if (keyCode == KeyCode.W)
                snake.setDirection(0);
            else if (keyCode == KeyCode.D)
                snake.setDirection(1);
            else if (keyCode == KeyCode.S)
                snake.setDirection(2);
            else if (keyCode == KeyCode.A)
                snake.setDirection(3);

        });


        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    if (snake.isAlive()) {
                        System.out.println("I live");
                        gamePlay.render(playScreen.getGc(), snake);
                    } else
                        cancel();

                });
            }
        }, 0L, 100L);


    }
}
