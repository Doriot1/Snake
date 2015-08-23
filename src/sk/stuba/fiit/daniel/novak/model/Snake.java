package sk.stuba.fiit.daniel.novak.model;

/**
 * Created by Daniel on 8.8.2015.
 */
public class Snake {
    private boolean isAlive = true;
    private int xPosition = 200;
    private int yPosition = 196;
    private Direction direction = Direction.RIGHT;
    private int ticks = 3;

    public boolean isAlive() {
        return isAlive;
    }

    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
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
                yPosition -= 4;
                break;
            case DOWN:
                yPosition += 4;
                break;
            case RIGHT:
                xPosition += 4;
                break;
            case LEFT:
                xPosition -= 4;
                break;
        }
    }

    public enum Direction {UP, DOWN, RIGHT, LEFT}

}
