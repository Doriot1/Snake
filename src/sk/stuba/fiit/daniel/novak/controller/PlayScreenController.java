package sk.stuba.fiit.daniel.novak.controller;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import sk.stuba.fiit.daniel.novak.model.Context;
import sk.stuba.fiit.daniel.novak.model.Graphics;
import sk.stuba.fiit.daniel.novak.model.audio.Music;
import sk.stuba.fiit.daniel.novak.model.snake.Snake;
import sk.stuba.fiit.daniel.novak.view.screens.MainScreen;
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
    private MainScreen mainScreen;

    public PlayScreenController(Graphics graphics, PlayScreen playScreen, Context context, Music music) {

        snake = new Snake();
        music.play(music.getSong());

        playScreen.setPlayScreenListener(new PlayScreen.PlayScreenListener() {
            @Override
            public void onKeyPressed(KeyCode keyCode) {
                switch (keyCode) {
                    case W:
                        if (snake.getDirection() == Snake.Direction.DOWN)
                            ;
                        else
                            snake.setDirection(Snake.Direction.UP);
                        break;
                    case D:
                        if (snake.getDirection() == Snake.Direction.LEFT)
                            ;
                        else
                            snake.setDirection(Snake.Direction.RIGHT);
                        break;
                    case S:
                        if (snake.getDirection() == Snake.Direction.UP)
                            ;
                        else
                            snake.setDirection(Snake.Direction.DOWN);
                        break;
                    case A:
                        if (snake.getDirection() == Snake.Direction.RIGHT)
                            ;
                        else
                            snake.setDirection(Snake.Direction.LEFT);
                        break;
                }
            }

            @Override
            public void onMainMenuPressed() {
                mainScreen = new MainScreen(context);
                context.switchScene(mainScreen);
                new MainScreenController(context, mainScreen, music);
            }
        });


        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    if (snake.isAlive()) {
                        graphics.render(playScreen.getGc(), snake);
                        playScreen.score.setText("" + graphics.score);
                    } else {
                        cancel();
                        Image image = new Image("/stiahnut.jpg");
                        playScreen.getGc().drawImage(image, 0, 0, 500, 440);
                        music.loss();
                    }
                });
            }
        }, 0L, 100L);

    }
}
