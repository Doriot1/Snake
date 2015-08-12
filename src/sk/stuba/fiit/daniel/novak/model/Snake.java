package sk.stuba.fiit.daniel.novak.model;

/**
 * Created by Daniel on 8.8.2015.
 */
public class Snake {
    public final static int UP = 0, DOWN = 2, EAST = 1, WEST = 3;
    private boolean isAlive = true;
    private int xPosition = 200;
    private int yPosition = 200;
    private int direction = 1;
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

    public int getDirection() {
        return direction;
    }

    public int getTicks(){
        return ticks;
    }


    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void move() {

        if (direction == 0)
            yPosition -= 4;
        else if (direction == 1)
            xPosition += 4;
        else if (direction == 2)
            yPosition += 4;
        else if (direction == 3)
            xPosition -= 4;
    }

}
