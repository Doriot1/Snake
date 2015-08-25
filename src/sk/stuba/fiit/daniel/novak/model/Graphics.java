package sk.stuba.fiit.daniel.novak.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sk.stuba.fiit.daniel.novak.model.snake.Snake;

/**
 * nope
 * Created by Daniel on 11.8.2015.
 */
public class Graphics {

    private int[][] board = new int[50][44];

    public Graphics() {
        board[25][22] = 4;
        board[24][22] = 3;
        board[23][22] = 2;
        board[22][22] = 1;
    }

    //(optional update) input, update, render
    public void drawBoard(GraphicsContext gc, Snake snake) {


        board[snake.getXPosition()][snake.getYPosition()] = snake.getTicks() + 1;
        gc.setStroke(Color.DARKGOLDENROD);
        gc.setLineWidth(2);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                gc.strokeRect(i * 10, j * 10, 10, 10);
                if (board[i][j] == 1) {
                    gc.setFill(Color.BLACK);
                    gc.fillRect(i * 10, j * 10, 10, 10);
                } else if (board[i][j] > 1) {
                    gc.setFill(Color.AQUAMARINE);
                    gc.fillRect(i * 10, j * 10, 10, 10);
                }
                board[i][j]--;
            }
        }
    }

    public void render(GraphicsContext gc, Snake snake) {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 500, 440);

        snake.move();
        drawBoard(gc, snake);

    }

}
