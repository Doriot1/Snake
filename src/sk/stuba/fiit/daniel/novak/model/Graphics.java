package sk.stuba.fiit.daniel.novak.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sk.stuba.fiit.daniel.novak.model.audio.Sounds;
import sk.stuba.fiit.daniel.novak.model.snake.Snake;

import java.util.Random;

/**
 * nope
 * Created by Daniel on 11.8.2015.
 */
public class Graphics {

    public int score = 0;
    private Sounds sounds = new Sounds();
    private int[][] board = new int[50][44];
    private boolean eaten = true;

    public Graphics() {
       /* board[26][30] = -2;
        board[27][30] = -2;
        board[28][30] = -2;
        board[29][30] = -2;
        board[30][30] = -2;
        board[31][30] = -2;
        board[32][30] = -2;
        board[33][30] = -2;
        board[34][30] = -2;
        board[35][30] = -2;
        board[36][30] = -2;
        board[37][30] = -2;
        board[38][30] = -2;
        board[39][30] = -2;
        board[40][30] = -2;
        board[41][30] = -2;
        board[42][30] = -2;
*/
        board[25][22] = 4;
        board[24][22] = 3;
        board[23][22] = 2;
        board[22][22] = 1;
    }

    //(optional update), input, update, render
    private void drawBoard(GraphicsContext gc, Snake snake) {

        if (board[snake.getXPosition()][snake.getYPosition()] > 0 || board[snake.getXPosition()][snake.getYPosition()] == -2)
            snake.setIsAlive(false);
        else if (snake.isAlive()) {
            if (board[snake.getXPosition()][snake.getYPosition()] == -1) {
                snake.setTicks(snake.getTicks() + 1);
                eaten = true;
                score += 10;
                sounds.play();
            }


            board[snake.getXPosition()][snake.getYPosition()] = snake.getTicks() + 1;
            gc.setStroke(Color.BLACK);
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
                        eaten = false;

                    } else if (board[i][j] == -2) {
                        gc.setFill(Color.WHITE);
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

        if (eaten)
            food();
        snake.move();
        drawBoard(gc, snake);
    }

}
