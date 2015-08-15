package sk.stuba.fiit.daniel.novak.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by Daniel on 11.8.2015.
 */
public class GamePlay {

    public void render(GraphicsContext gc, Snake snake){
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 500, 440);
        gc.setStroke(Color.WHEAT);
        gc.setLineWidth(5);

        snake.move();
        if (snake.getDirection() == Snake.Direction.UP)
            gc.strokeLine(snake.getXPosition(), snake.getYPosition(), snake.getXPosition(), snake.getYPosition() - 4);
        if (snake.getDirection() == Snake.Direction.LEFT)
            gc.strokeLine(snake.getXPosition(), snake.getYPosition(), snake.getXPosition() - 4, snake.getYPosition());
        if (snake.getDirection() == Snake.Direction.DOWN)
            gc.strokeLine(snake.getXPosition(), snake.getYPosition(), snake.getXPosition(), snake.getYPosition() + 4);
        if (snake.getDirection() == Snake.Direction.RIGHT)
            gc.strokeLine(snake.getXPosition(), snake.getYPosition(), snake.getXPosition() + 4, snake.getYPosition());
    }

}
