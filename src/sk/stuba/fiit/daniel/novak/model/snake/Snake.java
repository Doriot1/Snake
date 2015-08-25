package sk.stuba.fiit.daniel.novak.model.snake;

/**
 * nope
 * Created by Daniel on 8.8.2015.
 */
public class Snake {
    private boolean isAlive = true;
    private int xPosition = 25;
    private int yPosition = 22;
    private int lastXPosition = 22;
    private int lastYPosition = 22;
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

    public int getLastXPosition() {
        return lastXPosition;
    }

    public void setLastXPosition(int lastXPosition) {
        this.lastXPosition = lastXPosition;
    }

    public void setLastYPosition(int lastYPosition) {
        this.lastYPosition = lastYPosition;
    }

    public int getLastYPosition() {
        return lastYPosition;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getTicks() {
        return ticks;
    }

    /**
     * move() method changes x and y positions of head
     * according to key pressed
     */
    public void move() {

        switch (direction) {

            case UP:
                yPosition -= 1;
                break;
            case DOWN:
                yPosition += 1;
                break;
            case RIGHT:
                xPosition += 1;
                break;
            case LEFT:
                xPosition -= 1;
                break;
        }
    }

    public enum Direction {UP, DOWN, RIGHT, LEFT}

}
