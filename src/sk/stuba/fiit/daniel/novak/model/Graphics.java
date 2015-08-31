package sk.stuba.fiit.daniel.novak.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sk.stuba.fiit.daniel.novak.model.snake.Snake;

import java.util.Random;

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

    //(optional update), input, update, render
    private void drawBoard(GraphicsContext gc, Snake snake) {

        if (snake.isAlive()) {
            board[snake.getXPosition()][snake.getYPosition()] = snake.getTicks() + 1;
            gc.setStroke(Color.DARKGOLDENROD);
            gc.setLineWidth(2);

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    gc.strokeRect(i * 10, j * 10, 10, 10);
                    if (board[i][j] == 1) {
                        gc.setFill(Color.BLACK);
                        gc.fillRect(i * 10, j * 10, 10, 10);
                        board[i][j]--;

                    } else if (board[i][j] > 1) {
                        gc.setFill(Color.AQUAMARINE);
                        gc.fillRect(i * 10, j * 10, 10, 10);
                        board[i][j]--;

                    } else if (board[i][j] == -1) {
                        gc.setFill(Color.CORAL);
                        gc.fillRect(i * 10, j * 10, 10, 10);
                    }
                }
            }
        }
    }

    private void food() {
        Random random = new Random();
        int x;
        int y;

        do {
            x = random.nextInt(50);
            y = random.nextInt(44);

            if (board[x][y] == 0) {
                board[x][y] = -1;
            }

        } while (board[x][y] != -1);

    }

    public void render(GraphicsContext gc, Snake snake) {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 500, 440);

        food();
        snake.move();
        drawBoard(gc, snake);

    }

}
