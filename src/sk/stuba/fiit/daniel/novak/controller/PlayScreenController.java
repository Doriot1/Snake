package sk.stuba.fiit.daniel.novak.controller;

import javafx.application.Platform;
import sk.stuba.fiit.daniel.novak.model.Graphics;
import sk.stuba.fiit.daniel.novak.model.snake.Snake;
import sk.stuba.fiit.daniel.novak.view.screens.PlayScreen;

import java.util.Timer;
import java.util.TimerTask;

/**
 * nope
 * Created by Daniel on 10.8.2015.
 */
public class PlayScreenController {
    private Timer timer = new Timer();

    private Snake snake;

    public PlayScreenController(Graphics graphics, PlayScreen playScreen) {

        snake = new Snake();

        playScreen.setPlayScreenListener(keyCode -> {
            switch (keyCode) {
                case W:
                    snake.setDirection(Snake.Direction.UP);
                    break;
                case D:
                    snake.setDirection(Snake.Direction.RIGHT);
                    break;
                case S:
                    snake.setDirection(Snake.Direction.DOWN);
                    break;
                case A:
                    snake.setDirection(Snake.Direction.LEFT);
                    break;
            }
        });


        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    if (snake.isAlive()) {
                        graphics.render(playScreen.getGc(), snake);
                    } else
                        cancel();
                });
            }
        }, 0L, 200L);


    }
}
