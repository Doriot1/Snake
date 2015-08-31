package sk.stuba.fiit.daniel.novak.model.snake;

/**
 * nope
 * Created by Daniel on 8.8.2015.
 */
public class Snake {
    private boolean isAlive = true;
    private int xPosition = 25;
    private int yPosition = 22;
    private Direction direction = Direction.RIGHT;
    private int ticks = 4;


    public boolean isAlive() {
        return isAlive;
    }


    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getTicks() {
        return ticks;
    }

    public void setTicks(int ticks) {
        this.ticks = ticks;
    }

    /**
     * move() method changes x and y positions of head
     * according to key pressed
     */
    public void move() {

        switch (direction) {

            case UP:
                if (yPosition == 0)
                    isAlive = false;
                else
                    yPosition -= 1;
                break;
            case DOWN:
                if (yPosition == 43)
                    isAlive = false;
                else
                    yPosition += 1;
                break;
            case RIGHT:
                if (xPosition == 49)
                    isAlive = false;
                else
                    xPosition += 1;
                break;
            case LEFT:
                if (xPosition == 0)
                    isAlive = false;
                else
                    xPosition -= 1;
                break;
        }
    }

    public enum Direction {UP, DOWN, RIGHT, LEFT}

}
