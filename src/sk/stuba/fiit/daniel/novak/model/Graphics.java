package sk.stuba.fiit.daniel.novak.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * nope
 * Created by Daniel on 11.8.2015.
 */
public class Graphics {

    public void drawBoard(GraphicsContext gc) {
        int[][] board = new int[50][44];
        gc.setStroke(Color.RED);
        gc.setLineWidth(2);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                gc.strokeLine(i * 10, j * 10, i * 10, j * 10 + 10);
            }
            gc.strokeLine(0, i * 10, 500, i * 10);
        }
    }

    public void render(GraphicsContext gc, Snake snake) {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 500, 440);
        gc.setStroke(Color.WHEAT);
        gc.setLineWidth(8);

        snake.move();



        if (snake.getDirection() == Snake.Direction.UP)
            gc.strokeLine(snake.getXPosition(), snake.getYPosition(), snake.getXPosition(), snake.getYPosition() - 3);
        if (snake.getDirection() == Snake.Direction.LEFT)
            gc.strokeLine(snake.getXPosition(), snake.getYPosition(), snake.getXPosition() - 3, snake.getYPosition());
        if (snake.getDirection() == Snake.Direction.DOWN)
            gc.strokeLine(snake.getXPosition(), snake.getYPosition(), snake.getXPosition(), snake.getYPosition() + 3);
        if (snake.getDirection() == Snake.Direction.RIGHT)
            gc.strokeLine(snake.getXPosition(), snake.getYPosition(), snake.getXPosition() + 3, snake.getYPosition());
    }

}
